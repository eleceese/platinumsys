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
import py.com.platinum.entity.FormulaSemiCabecera;
import py.com.platinum.entity.FormulaSemiDetalle;
import py.com.platinum.entity.Producto;
import py.com.platinum.entity.TareaFormula;

/**
 *
 * @author FerBoy
 */
public class FormulaSemiCabeceraController extends AbstractJpaDao <FormulaSemiCabecera> {

    public boolean existe(String codFormulaSemiCabecera){

        String SQL = "SELECT o FROM FormulaSemiCabecera o WHERE o.codFormulaSemiCabecera = :codFormulaSemiCabecera";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        q.setParameter("codFormulaSemiCabecera", codFormulaSemiCabecera);

        List<FormulaSemiCabecera> entities = q.getResultList();
        em.close();

        if (entities.size() > 0){
        return true;}
        else
        {return false;}


    }


    public FormulaSemiCabeceraController() {
        super();
    }

    @Override
    public FormulaSemiCabecera findById(Long id) {
        return (FormulaSemiCabecera) this.findById(FormulaSemiCabecera.class, id);
    }

    @Override
    public List<FormulaSemiCabecera> getAll(String orderBy) {
        return this.getAll(FormulaSemiCabecera.class, orderBy);
    }

    public List<FormulaSemiCabecera> getAllFiltered(String codigo, String descripcion, String codProducto) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM FormulaSemiCabecera o WHERE o.codFormulaSemiCabecera= o.codFormulaSemiCabecera";

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

        List<FormulaSemiCabecera> entities = q.getResultList();
        em.close();

        return entities;

      }

//public static void main (String[] v) {
//        FormulaSemiCabeceraController formulaSemiCabeceraController = new FormulaSemiCabeceraController();
//        FormulaSemiCabecera formulaSemiCabecera = new FormulaSemiCabecera();
//        formulaSemiCabecera = formulaSemiCabeceraController.findById(Long.valueOf("1001"));
//        System.out.println(formulaSemiCabecera.getDescripcion());
//
//        };

public ControllerResult deleteCabDet(FormulaSemiCabecera cab, FormulaSemiDetalle[]det, TareaFormula[] detFor) {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();

        FormulaSemiCabecera formulaSemiCabecera = cab;
        FormulaSemiDetalle[] detallesFormulaSemi = det;
        TareaFormula[] tareasFormula = detFor;

        try {
            em.getTransaction().begin();

            /// ELIMINACION DE LOS DETALLES DE RECURSOS
                if (detallesFormulaSemi != null) {
                    for (int i = 0; i < detallesFormulaSemi.length; i++) {

                        FormulaSemiDetalle fdet = new FormulaSemiDetalle();
                        fdet = detallesFormulaSemi[i];
                        em.remove(em.merge(fdet));
                    }
                }
            /// FIN ELIMINACION DE LOS DETALLES DE RECURSOS

            /// ELIMINACION DE LOS DETALLES DE TAREAS
            if (tareasFormula != null) {
                for (int i = 0; i < tareasFormula.length; i++) {

                    TareaFormula tfor = new TareaFormula();
                    tfor = tareasFormula[i];
                     em.remove(em.merge(tfor));
                }
            }
            /// FIN ELIMINACION DE LOS DETALLES DE TAREAS


       /// ELIMINACION DE LA CABECERA
            formulaSemiCabecera = cab;
            em.remove(em.merge(formulaSemiCabecera));
       /// FIN ELIMINACION DE LA CABECERA
            em.getTransaction().commit();
            r.setCodRetorno(0);
            r.setMsg("Registro eliminado correctamente");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Ha ocurrido un error en la Eliminacion del Registro");
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

public ControllerResult createCabDet (FormulaSemiCabecera cab, FormulaSemiDetalle[]det, TareaFormula[] detFor) throws RuntimeException {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        FormulaSemiCabecera formulaSemiCabecera = cab;
        FormulaSemiDetalle[] detallesFormulaSemi = det;
        TareaFormula[] tareasFormula = detFor;

        try {
            tx.begin();
            ///CARGA DE LA CABECERA
            em.persist(formulaSemiCabecera);
            /// FIN DE LA CARGA DE LA CABECERA

            // CARGA DE LOS DETALLES DE RECURSOS
            for (int i = 0; i < detallesFormulaSemi.length; i++) {

                FormulaSemiDetalle fsdet = new FormulaSemiDetalle();
                fsdet = detallesFormulaSemi[i];
                fsdet.setCodFormulaSemiCabecera(formulaSemiCabecera);
                em.persist(fsdet);
            }
            // FIN DE CARGA DE LOS DETALLES DE RECURSOS

            // CARGA DE LOS DETALLES DE TAREAS
           for (int i = 0; i < tareasFormula.length; i++) {
                    TareaFormula tfor = new TareaFormula();
                    tfor = tareasFormula[i];
                    tfor.setCodFormulaSemiCabecera(formulaSemiCabecera);
                    em.persist(tfor);
           }
            // FIN DE CARGA DE LOS DETALLES DE TAREAS
            tx.commit();
            r.setCodRetorno(0);
            r.setMsg("Se creo correctamente el registro");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Ha ocurrido un error al agregar el Registro");
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

public ControllerResult updateCabDet(FormulaSemiCabecera cab, FormulaSemiDetalle[]det, TareaFormula[] detFor, FormulaSemiDetalle[]detElim, TareaFormula[] detForElim)  {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();

        FormulaSemiCabecera formulaSemiCabecera = cab;
        FormulaSemiDetalle[] detallesFormulaSemi = det;
        TareaFormula[] tareasFormula = detFor;
        FormulaSemiDetalle[] detallesFormulaSemiElim = detElim;
        TareaFormula[] tareasFormulaElim = detForElim;

        try {
            em.getTransaction().begin();


             // ELIMINAR LOS DETALLES DE PRODUCTOS BORRADOS DE LA GRILLA

            if (detallesFormulaSemiElim.length > 0) {
                        for (int i = 0; i < detallesFormulaSemiElim.length; i++) {
                            FormulaSemiDetalle fdetSemiElim = new FormulaSemiDetalle();
                            fdetSemiElim = detallesFormulaSemiElim[i];
                            FormulaSemiDetalle fDetEli = em.find(FormulaSemiDetalle.class, fdetSemiElim.getCodFormulaSemiDetalle());
                            em.remove(fDetEli);
                         }
             }
            // FIN ELIMINAR LOS DETALLES DE PRODUCTOS BORRADOS DE LA GRILLA
            // ELIMINAR LOS DETALLES DE TAREAS DE LA GRILLA
            if (tareasFormulaElim.length> 0) {
                        for (int i = 0; i < tareasFormulaElim.length; i++) {
                            TareaFormula tarForElim = new TareaFormula();
                            tarForElim = tareasFormulaElim[i];
                            TareaFormula tarElim = em.find(TareaFormula.class, tarForElim.getCodTareaFormula());
                            em.remove(tarElim);
                        }
             }
        // FIN ELIMINAR LOS DETALLES DE TAREAS DE LA GRILLA

        //// ACTUALIZAR DETALLES RECURSOS
        formulaSemiCabecera = cab;

        for (int i = 0; i < detallesFormulaSemi.length; i++) {

            FormulaSemiDetalle fSemidet = new FormulaSemiDetalle();
            fSemidet = detallesFormulaSemi[i];

            if (fSemidet.getCodFormulaSemiCabecera() != null) {
                em.merge(fSemidet);
            }else{
                fSemidet.setCodFormulaSemiCabecera(formulaSemiCabecera);
                em.persist(fSemidet);
            }
        }
           //// FIN ACTUALIZAR DETALLES RECURSOS

           //// ACTUALIZAR DETALLES TAREAS
        formulaSemiCabecera = cab;
        for (int h = 0; h < tareasFormula.length; h++) {

            TareaFormula tarFor = new TareaFormula();
            tarFor = tareasFormula[h];

            if (tarFor.getCodFormulaSemiCabecera() != null) {
                em.merge(tarFor);
            }else{
                tarFor.setCodFormulaSemiCabecera(formulaSemiCabecera);
                em.persist(tarFor);
            }
        }
            //// FIN ACTUALIZAR DETALLES TAREAS

        ///// ACTUALIZAR CABECERA

                formulaSemiCabecera = cab;
                em.merge(formulaSemiCabecera);
                ///// FIN ACTUALIZAR CABECERA
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


public static void main (String[] v) {
        FormulaSemiCabeceraController formulaSemiCabeceraController = new FormulaSemiCabeceraController();
        FormulaSemiCabecera formulaSemiCabecera = formulaSemiCabeceraController.findById(Long.valueOf("1018"));



        System.out.println(formulaSemiCabecera.getFormulaSemiDetalleListList().size());
    for (int i = 0; i < formulaSemiCabecera.getFormulaSemiDetalleListList().size(); i++) {
            FormulaSemiDetalle formulaSemiDetalle = formulaSemiCabecera.getFormulaSemiDetalleListList().get(i);
            System.out.println(formulaSemiDetalle.getCodFormulaSemiDetalle().toString());
    }


};



}
