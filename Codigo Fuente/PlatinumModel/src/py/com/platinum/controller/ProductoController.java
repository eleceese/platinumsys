/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.Deposito;
import py.com.platinum.entity.Existencia;
import py.com.platinum.entity.HistoricoCosto;
import py.com.platinum.entity.HistoricoPrecio;
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
        String SQL = "SELECT o FROM Producto o WHERE (UPPER(o.codTipoProducto.descripcion) like upper('Insumo') or UPPER(o.codTipoProducto.descripcion) like upper('MateriaPrima'))";

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
    public List<Producto> getSemiAcabado(String marca, String descripcion, String presentacion) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM Producto o WHERE (UPPER(o.codTipoProducto.descripcion) like upper('SemiTerminado') or UPPER(o.codTipoProducto.descripcion) like upper('Acabado'))";

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
    public List<Producto> getInsumosMateriasFinalesSemiter(String marca, String descripcion, String presentacion) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM Producto o WHERE (UPPER(o.codTipoProducto.descripcion) like upper('Insumo') or UPPER(o.codTipoProducto.descripcion) like upper('MateriaPrima') or UPPER(o.codTipoProducto.descripcion) like upper('Terminado'))";

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
    public List<Producto> getProductosGenericos(String marca, String descripcion, String presentacion) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM Producto o WHERE (UPPER(o.codTipoProducto.descripcion) like upper('ProductoGenerico'))";

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
                if (!producto.getCodTipoProducto().getDescripcion().equals("ProductoGenerico")
                        && !producto.getCodTipoProducto().getDescripcion().equals("Acabado")) {
                        for (int i = 0; i < listaDepositos.size(); i++) {
                            Existencia existencia = new Existencia();
                            Deposito deposito = listaDepositos.get(i);
                            existencia.setCodProducto(producto);
                            existencia.setCantidadExistencia(BigInteger.valueOf(Long.valueOf("0")));
                            existencia.setCodDeposito(deposito);
                            em.persist(existencia);
                        }
                 }
                /// FIN DE INSERCION DE EXISTENCIAS

                //// INSERCION DE LOS HISTORICOS DE COSTO Y PRECIO
                if (!producto.getCodTipoProducto().getDescripcion().equals("ProductoGenerico")
                        && !producto.getCodTipoProducto().getDescripcion().equals("Acabado")) {
                    HistoricoCostoController costoController = new HistoricoCostoController();
                    HistoricoCosto histCosto = new HistoricoCosto();
                    histCosto.setFecHistoricoCosto(new Date());
                    histCosto.setFechaAlta(new Date());
                    histCosto.setCodProducto(producto);
                    histCosto.setCostoHistorico(BigInteger.valueOf(producto.getCostoActual().longValue()));
                    histCosto.setCostoActual(BigInteger.valueOf(producto.getCostoActual().longValue()));
                    em.persist(histCosto);

                    HistoricoPrecioController precioController = new HistoricoPrecioController();
                    HistoricoPrecio histPrecio = new HistoricoPrecio();
                    histPrecio.setFecHistorico(new Date());
                    histPrecio.setFechaAlta(new Date());
                    histPrecio.setCodProducto(producto);
                    histPrecio.setPrecioHistorico(BigInteger.valueOf(producto.getPrecioActual().longValue()));
                    em.persist(histPrecio);
                    }


                /////
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
            /// ELIMINAMOS LOS HISTORICOS DE COSTOS Y PRECIOS
            HistoricoCostoController histController = new HistoricoCostoController();
            List<HistoricoCosto> histCostList = histController.getHistoricos(p.getCodProducto().longValue());
            for (int i = 0; i < histCostList.size(); i++) {
                HistoricoCosto histCost = new HistoricoCosto();
                histCost = histCostList.get(i);
                em.remove(em.merge(histCost));
            }
            /// ELIMINAMOS LOS HISTORICOS DE COSTOS Y PRECIOS
            HistoricoPrecioController histPrecController = new HistoricoPrecioController();
            List<HistoricoPrecio> histPrecList = histPrecController.getHistoricos(p.getCodProducto().longValue());
            for (int i = 0; i < histPrecList.size(); i++) {
                HistoricoPrecio histPrec = new HistoricoPrecio();
                histPrec = histPrecList.get(i);
                em.remove(em.merge(histPrec));
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

    @Override
     public ControllerResult update(Producto producto)  {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Producto p2 = new Producto();
            p2 = new ProductoController().findById(producto.getCodProducto().longValue());

             //// INSERCION DE LOS HISTORICOS DE COSTO Y PRECIO
                if (!producto.getCodTipoProducto().getDescripcion().equals("ProductoGenerico")
                        && p2.getCostoActual().longValue() != producto.getCostoActual().longValue()) {
                    HistoricoCostoController costoController = new HistoricoCostoController();
                    HistoricoCosto histCosto = new HistoricoCosto();
                    histCosto.setFecHistoricoCosto(new Date());
                    histCosto.setFechaAlta(new Date());
                    histCosto.setCodProducto(producto);
                    histCosto.setCostoHistorico(BigInteger.valueOf(producto.getCostoActual().longValue()));
                    histCosto.setCostoActual(BigInteger.valueOf(p2.getCostoActual().longValue()));
                    em.persist(histCosto);
                }
               if (!producto.getCodTipoProducto().getDescripcion().equals("ProductoGenerico")
                        && p2.getPrecioActual().longValue() != producto.getPrecioActual().longValue()){
                    HistoricoPrecioController precioController = new HistoricoPrecioController();
                    HistoricoPrecio histPrecio = new HistoricoPrecio();
                    histPrecio.setFecHistorico(new Date());
                    histPrecio.setFechaAlta(new Date());
                    histPrecio.setCodProducto(producto);
                    histPrecio.setPrecioHistorico(BigInteger.valueOf(producto.getPrecioActual().longValue()));
                    em.persist(histPrecio);
                    }
            //// FIN INSERCION DE HISTORICOS DE COSTOS

            em.merge(producto);
            em.getTransaction().commit();
            r.setCodRetorno(0);
            r.setMsg("Registro actualizado correctamente");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Error al actualizar el registro");
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

    public Long calcularMovimientos(Long codProducto, Date fecha1, Date fecha2, Long codDeposito){
    Long valor = Long.valueOf("0");

    BigDecimal codProd = BigDecimal.valueOf(codProducto);
    BigDecimal codDep = BigDecimal.valueOf(codDeposito);

    String SQL = "select sum(VALOR) from ( "
        +"select case when det.tipo_entrada_salida = 'E' then det.cantidad_ent_sal else det.cantidad_ent_sal*-1 end as Valor "
        +"from Entrada_Salida_Detalle det "
        +" join producto p on det.cod_producto = p.cod_producto  "
        +" join marca m on p.cod_marca = m.cod_marca "
        +" join entrada_salida_cabecera cab on det.cod_entrada_salida = cab.cod_entrada_salida "
        +" join deposito dep on cab.cod_deposito = dep.cod_deposito "
        +" where det.cod_producto = :codProducto "
        +" and dep.cod_deposito = :codDeposito "
        +" and cab.fecha_alta < :fecha1 "
        //+" and cab.fecha_alta < :fecha2 "
        +" union  "
        +"select f.cantidad * -1 as Valor "
        +" from factura_detalle f "
        +" join producto p1 on f.cod_producto = p1.cod_producto  "
        +" join factura_cabecera fc on f.cod_factura = fc.cod_factura  "
        +" join deposito dep on fc.cod_deposito = dep.cod_deposito "
        +" join marca m1 on p1.cod_marca = m1.cod_marca "
        +" where f.cod_producto = :codProducto "
        +" and fc.fecha_alta < :fecha1 "
       // +" and fc.fecha_alta < :fecha2 "
        +") ";

                EntityManager em = emf.createEntityManager();
                Query q = em.createNativeQuery(SQL);

                if (codProducto != null) {
                    q.setParameter("codProducto", codProd);
                }
                if (fecha1 != null) {
                    q.setParameter("fecha1", fecha1);
                }
//                if (fecha2 != null) {
//                    q.setParameter("fecha2", fecha2);
//                }
                if (codDeposito != null) {
                    q.setParameter("codDeposito", codDep);
                }

                BigDecimal valor2  =  (BigDecimal) q.getSingleResult();
                if (valor2 != null) {
                    valor = valor2.longValue();
                }

                em.close();
                return valor;
        }
   

    public static void main(String[] args) {
      Long resultado =  new ProductoController().calcularMovimientos(Long.valueOf("1170"), new Date(), new Date(), Long.valueOf("1"));
      System.out.println("********");
      System.out.println(resultado);


    }


}
