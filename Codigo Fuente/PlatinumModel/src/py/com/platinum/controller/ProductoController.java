/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.Deposito;
import py.com.platinum.entity.Existencia;
import py.com.platinum.entity.Producto;

/**
 *
 * @author FerBoy
 */
public class ProductoController extends AbstractJpaDao <Producto> {

    public boolean existe(String codInterno){

        String SQL = "SELECT o FROM Producto o WHERE o.codigoInterno = :codInterno";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        q.setParameter("codInterno", codInterno);

        List<Producto> entities = q.getResultList();
        em.close();

        if (entities.size() > 0){
        return true;}
        else
        {return false;}


    }


    public ProductoController() {
        super();
    }

    @Override
    public Producto findById(Long id) {
        return (Producto) this.findById(Producto.class, id);
    }

    @Override
    public List<Producto> getAll(String orderBy) {
        return this.getAll(Producto.class, orderBy);
    }

    public List<Producto> getAllFiltered(String marca, String descripcion, String tipoProducto, String presentacion) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM Producto o WHERE o.codProducto = o.codProducto";

        if (marca != null && !marca.equals("99999") && !marca.equals("")) {
            SQL = SQL + " and UPPER(o.codMarca.codMarca) = upper(:marca)";
        }

        if (descripcion != null && !descripcion.equals("")) {
            SQL = SQL + " and UPPER(o.descripcion) like upper(:descripcion)";
        }

        if (tipoProducto != null && !tipoProducto.equals("Todos") && !tipoProducto.equals("")) {
            SQL = SQL + " and UPPER(o.codTipoProducto.descripcion) like upper(:tipoProducto)";
        }


        if (presentacion != null && !presentacion.equals("99999") && !presentacion.equals("")) {
            SQL = SQL + " and UPPER(o.codPresentacion.codPresentacion) = upper(:presentacion)";
        }


        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        if (marca != null && !marca.equals("99999") && !marca.equals("")) {
            q.setParameter("marca", marca);
        }

        if (descripcion != null && !descripcion.equals("")) {
            q.setParameter("descripcion", "%"+descripcion+"%");
        }

        if (tipoProducto != null && !tipoProducto.equals("Todos") && !tipoProducto.equals("")) {
            q.setParameter("tipoProducto", "%"+tipoProducto+"%");
        }

        if (presentacion != null && !presentacion.equals("99999") && !presentacion.equals("")) {
            q.setParameter("presentacion", presentacion);
        }

        List<Producto> entities = q.getResultList();
        em.close();

        return entities;

      }

    public List<Producto> getInsumosMaterias(String marca, String descripcion, String presentacion) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM Producto o WHERE UPPER(o.codTipoProducto.descripcion) like upper('Insumo') or UPPER(o.codTipoProducto.descripcion) like upper('MateriaPrima')";

        if (marca != null && !marca.equals("99999") && !marca.equals("")) {
            SQL = SQL + " and UPPER(o.codMarca.codMarca) = upper(:marca)";
        }

        if (descripcion != null && !descripcion.equals("")) {
            SQL = SQL + " and UPPER(o.descripcion) like upper(:descripcion)";
        }

        if (presentacion != null && !presentacion.equals("99999") && !presentacion.equals("")) {
            SQL = SQL + " and UPPER(o.codPresentacion.codPresentacion) = upper(:presentacion)";
        }


        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        if (marca != null && !marca.equals("99999") && !marca.equals("")) {
            q.setParameter("marca", marca);
        }

        if (descripcion != null && !descripcion.equals("")) {
            q.setParameter("descripcion", "%"+descripcion+"%");
        }

       if (presentacion != null && !presentacion.equals("99999") && !presentacion.equals("")) {
            q.setParameter("presentacion", presentacion);
        }

        List<Producto> insumos = q.getResultList();
        em.close();

        return insumos;

      }

//public static void main (String[] v) {
//        ProductoController productoController = new ProductoController();
//        Producto producto = new Producto();
//        producto = productoController.findById(Long.valueOf("1000"));
//        System.out.println(producto.getDescripcion());
//        productoController.delete(producto);
//        };

    @Override
     public ControllerResult create(Producto p) throws RuntimeException {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();


        try {
            
            tx.begin();
            em.persist(p);

            //// INSERCION DE LAS EXISTENCIAS
            DepositoController depositoController = new DepositoController();
            ExistenciaController existenciaController = new ExistenciaController();


                List<Deposito> listaDepositos = depositoController.getAll("nombre");
                Producto producto = p;
                for (int i = 0; i < listaDepositos.size(); i++) {
                    Existencia existencia = new Existencia();
                    Deposito deposito = listaDepositos.get(i);
                    existencia.setCodProducto(producto);
                    existencia.setCantidadExistencia(BigInteger.valueOf(Long.valueOf("0")));
                    existencia.setCodDeposito(deposito);
                    em.persist(existencia);
                }
            

            /// FIN DE INSERCION DE EXISTENCIAS
            tx.commit();
            r.setCodRetorno(0);
            r.setMsg("Se creo correctamente el registro");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Ha ocurrido un error al insertar el Producto");
            try {
                tx.rollback();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            em.close();
            return r;
        }
    
  }

    @Override
     public ControllerResult delete(Producto p) {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            /// ELIMINAMOS LAS EXISTENCIAS DEL PRODUCTO
            ExistenciaController existenciaController = new ExistenciaController();
            List<Existencia> existenciaList = existenciaController.getAllFiltered(null, p.getCodProducto(), null);
            for (int i = 0; i < existenciaList.size(); i++) {
                Existencia existencia = new Existencia();
                existencia = existenciaList.get(i);

                em.remove(em.merge(existencia));
            }
            Producto producto = p;

            em.remove(em.merge(producto));
            em.getTransaction().commit();
            r.setCodRetorno(0);
            r.setMsg("Registro eliminado correctamente");
        } catch (Exception ex) { 
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Error en la eliminacion del Registro");
            try {
                em.getTransaction().rollback();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            em.close();
            return r;
        }
    }




}
