/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.controllerUtil.ControllerResult;
import py.com.platinum.entity.FormulaCabecera;
import py.com.platinum.entity.FormulaDetalle;
import py.com.platinum.entity.Producto;

/**
 *
 * @author FerBoy
 */
public class FormulaCabeceraController extends AbstractJpaDao <FormulaCabecera> {

    public boolean existe(String codFormula){

        String SQL = "SELECT o FROM FormulaCabecera o WHERE o.codFormula = :codFormula";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        q.setParameter("codFormula", codFormula);

        List<FormulaCabecera> entities = q.getResultList();
        em.close();

        if (entities.size() > 0){
        return true;}
        else
        {return false;}


    }


    public FormulaCabeceraController() {
        super();
    }

    @Override
    public FormulaCabecera findById(Long id) {
        return (FormulaCabecera) this.findById(FormulaCabecera.class, id);
    }

    @Override
    public List<FormulaCabecera> getAll(String orderBy) {
        return this.getAll(FormulaCabecera.class, orderBy);
    }

    public List<FormulaCabecera> getAllFiltered(String codigo, String descripcion, String codProducto) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM FormulaCabecera o WHERE o.codFormula= o.codFormula";

        if (codigo != null && !codigo.equals("99999") && !codigo.equals("")) {
            SQL = SQL + " and UPPER(o.codFormula) like upper(:codigo)";
        }

        if (descripcion != null && !descripcion.equals("")) {
            SQL = SQL + " and UPPER(o.descripcion) like upper(:descripcion)";
        }

        if (codProducto != null && !codProducto.equals("99999") && !codProducto.equals("")) {
            SQL = SQL + " and UPPER(o.codProducto.descripcion) like upper(:codProducto)";
        }

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        if (codigo != null && !codigo.equals("99999") && !codigo.equals("")) {
            q.setParameter("codigo", codigo);
        }

        if (descripcion != null && !descripcion.equals("")) {
            q.setParameter("descripcion", "%"+descripcion+"%");
        }

        if (codProducto != null && !codProducto.equals("99999") && !codProducto.equals("")) {
            q.setParameter("codProducto", "%"+codProducto+"%");
        }

        List<FormulaCabecera> entities = q.getResultList();
        em.close();

        return entities;

      }

//public static void main (String[] v) {
//        ProductoController productoController = new ProductoController();
//        Producto producto = new Producto();
//        producto = productoController.findById(Long.valueOf("1000"));
//        System.out.println(producto.getDescripcion());
//        productoController.delete(producto);
//        };



    public ControllerResult deleteCabDet(FormulaCabecera cab, FormulaDetalle[] det) {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();

        FormulaDetalle[] detallesFormula = det;
        FormulaCabecera formulaCabecera = cab;
        try {
            em.getTransaction().begin();

            /// ELIMINACION DE LOS DETALLES
            if (detallesFormula != null) {
                for (int i = 0; i < detallesFormula.length; i++) {
                    FormulaDetalle fdet = new FormulaDetalle();
                    fdet = detallesFormula[i];
                    em.remove(em.merge(fdet));
               }
            }
             //// FIN DE ELIMINACION DE LOS DETALLES

            //// ELIMINACION DE LA CABECERA
                formulaCabecera = cab;
                em.remove(em.merge(formulaCabecera));
            ///FIN ELIMINACION DE LA CABECERA

                em.getTransaction().commit();
            r.setCodRetorno(0);
            r.setMsg("Registro eliminado correctamente");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Ha ocurrid un error durante la Eliminacion del Registro ");
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

    public ControllerResult createCabDet(FormulaCabecera cab, FormulaDetalle[] det) throws RuntimeException {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        FormulaDetalle[] detallesFormula = det;
        FormulaCabecera formulaCabecera = cab;

        try {
            tx.begin();

          //// CARGA DE LA CABECERA
            em.persist(formulaCabecera);
          //// FIN DE LA CARGA DE LA CABECERA

            //// CARGA DE LOS DETALLES

            for (int i = 0; i < detallesFormula.length; i++) {

                    FormulaDetalle fdet = new FormulaDetalle();
                    fdet = detallesFormula[i];
                    fdet.setCodFormula(formulaCabecera);
                    em.persist(fdet);
            }
            //// FIN DE CARGA DE LOS DETALLES

            tx.commit();
            r.setCodRetorno(0);
            r.setMsg("Se creo correctamente el registro");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Ha ocurrido un error en la creacion del Registro ");
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


    public ControllerResult updateCabDet(FormulaCabecera cab, FormulaDetalle[] det, FormulaDetalle[] detEli)  {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();

        FormulaDetalle[] detallesFormula = det;
        FormulaDetalle[] detallesFormulaEliminada = detEli;
        FormulaCabecera formulaCabecera = cab;

        try {
            em.getTransaction().begin();
            // ELIMINAR LOS DETALLES BORRADOS DE LA GRILLA
            if (detallesFormulaEliminada.length > 0) {

                        for (int i = 0; i < detallesFormulaEliminada.length; i++) {
                            FormulaDetalle fdetElim = new FormulaDetalle();
                            fdetElim = detallesFormulaEliminada[i];
                            FormulaDetalle formulaDetalle = em.find(FormulaDetalle.class, fdetElim.getCodFormulaDetalle());
                            em.remove(formulaDetalle);
                         }
             }
             // fin de la eliminacion

            //// ACTUALIZAR DETALLES
            formulaCabecera = cab;
            for (int i = 0; i < detallesFormula.length; i++) {
                 FormulaDetalle fdet = new FormulaDetalle();
                 fdet = detallesFormula[i];
                 if (fdet.getCodFormulaDetalle() != null) {
                        em.merge(fdet);
                 }else{
                        fdet.setCodFormula(formulaCabecera);
                        em.persist(fdet);
                 }
             }
             //// FIN ACTUALIZAR DETALLES

            ///// ACTUALIZAR CABECERA
                    em.merge(cab);
            ///// FIN ACTUALIZAR CABECERA
            em.getTransaction().commit();
            r.setCodRetorno(0);
            r.setMsg("Registro actualizado correctamente");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Ha ocurrido un error al actualizar el registro ");
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
