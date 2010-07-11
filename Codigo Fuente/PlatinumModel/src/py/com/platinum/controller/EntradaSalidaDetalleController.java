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
import py.com.platinum.entity.Empleado;
import py.com.platinum.entity.EntradaSalidaCabecera;
import py.com.platinum.entity.EntradaSalidaDetalle;
import py.com.platinum.entity.EntradaSalidaDetalle;
import py.com.platinum.entity.OrdenTrabajoDetalle;
import py.com.platinum.entity.Producto;
import py.com.platinum.entity.SolicitudInterna;
import py.com.platinum.entity.TareaAsignada;
import py.com.platinum.view.EntradaSalidaCantidad;

/**
 *
 * @author FerBoy
 */
public class EntradaSalidaDetalleController extends AbstractJpaDao <EntradaSalidaDetalle> {

    
    public EntradaSalidaDetalleController() {
        super();
    }

    @Override
    public EntradaSalidaDetalle findById(Long id) {
        return (EntradaSalidaDetalle) this.findById(EntradaSalidaDetalle.class, id);
    }

    @Override
    public List<EntradaSalidaDetalle> getAll(String orderBy) {
        return this.getAll(EntradaSalidaDetalle.class, orderBy);
    }

    public List<EntradaSalidaDetalle> getAllFiltered(Long codEntradaSalida, Long codEntSalDetalle, String producto, Long codProducto, Long codOrdenTrabajoDetalle, Long codSolicitud) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM EntradaSalidaDetalle o WHERE o.codEntSalDetalle = o.codEntSalDetalle";

        if (codEntradaSalida != null) {
            SQL = SQL + " and o.codEntradaSalida.codEntradaSalida = :codEntradaSalida";
        }
        if (codEntSalDetalle != null) {
            SQL = SQL + " and o.codEntSalDetalle = :codEntSalDetalle";
        }

        if (producto != null && !producto.equals("")) {
            SQL = SQL + " and UPPER(o.codProducto.descripcion) like upper:producto";
        }

        if (codProducto != null) {
            SQL = SQL + " and o.codProducto.codProducto = :codProducto";
        }

        if (codOrdenTrabajoDetalle != null) {
            SQL = SQL + " and o.codOrdenTrabajoDetalle.codOrdenTrabajoDet = :codOrdenTrabajoDetalle";
        }                       

        if (codSolicitud != null) {
            SQL = SQL + " and o.codSolicitud.codSolicitud = :codSolicitud";
        }


        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        if (codEntradaSalida != null) {
            q.setParameter("codEntradaSalida", codEntradaSalida);
        }
        if (codEntSalDetalle != null) {
            q.setParameter("codEntSalDetalle", codEntSalDetalle);
        }
         if (codProducto != null) {
            q.setParameter("codProducto", codProducto);
        }
      
        if (codProducto != null) {
            q.setParameter("codProducto", codProducto);
        }

        if (producto != null) {
            q.setParameter("producto", "%" + producto + "%");
        }

        if (codOrdenTrabajoDetalle != null) {
            q.setParameter("codOrdenTrabajoDetalle", codOrdenTrabajoDetalle);
        }

        if (codSolicitud != null) {
            q.setParameter("codSolicitud", codSolicitud);
        }

        List<EntradaSalidaDetalle> entities = q.getResultList();
        em.close();

        return entities;

      }

public static void main (String[] v) {
//        List <EntradaSalidaDetalle> entSal = new ArrayList();
//        entSal = new EntradaSalidaDetalleController().getAll("codProducto");

        List<EntradaSalidaCantidad> entSal = new ArrayList();
//        entSal = new EntradaSalidaDetalleController().getAll("codEntSalDetalle");
        entSal  = new EntradaSalidaDetalleController().getProductoCantidad(null);


        System.out.println("********************");
        System.out.println(entSal.size());


        for (int i = 0; i < entSal.size(); i++) {
        EntradaSalidaCantidad entradaSalidaCantidad = entSal.get(i);
                    System.out.println("******det****");
                    System.out.println(entradaSalidaCantidad.getCodProducto());
                    System.out.println(entradaSalidaCantidad.getCantidad().toString());
   
        }
};

//public static void main(String[] args){
//EntradaSalidaCabecera c = new EntradaSalidaCabecera();
//EntradaSalidaDetalle d = new EntradaSalidaDetalle();
//
//Deposito dep = new Deposito();
//dep.setCodDeposito(Long.valueOf("3"));
//
//c.setCodDeposito(dep);
//Empleado codEmpleado = new Empleado(Long.valueOf("1"));
//c.setCodEmpleado(codEmpleado);
//c.setCodEncargado(codEmpleado);
//
//
//
//d.setCantidadEntSal(new BigInteger("777"));
//d.setTipoEntradaSalida("E");
//Producto codProducto = new ProductoController().findById (Long.valueOf("1096"));
//d.setCodProducto(codProducto);
//        OrdenTrabajoDetalle codOrdenTrabajoDetalle = new OrdenTrabajoDetalleController().findById(Long.valueOf("161"));
//d.setCodOrdenTrabajoDetalle(codOrdenTrabajoDetalle);
//
//
//EntradaSalidaDetalle[] entSalDetArray = new EntradaSalidaDetalle[1];
//entSalDetArray[0] = d;
//
//new EntradaSalidaCabeceraController().createCabDet(c,entSalDetArray);
////d.setCodEntradaSalida(c);
////new EntradaSalidaDetalleController().create(d);
//}

    public List<EntradaSalidaCantidad> getProductoCantidad(Long codOrdenTrabajoDetalle) {
        //emf.createEntityManager Levanta el contexto del JPA


            String SQL = "SELECT COD_PRODUCTO as codProducto,sum(CANTIDAD_ENT_SAL) as cantidad FROM Entrada_Salida_Detalle ";
                 
            if (codOrdenTrabajoDetalle != null) {
                    SQL = SQL + "where cod_Orden_Trabajo_Detalle = :codOrdenTrabajoDetalle ";

            }
            SQL = SQL + "group by COD_PRODUCTO";


          EntityManager em = emf.createEntityManager();
          Query q = em.createNativeQuery(SQL, EntradaSalidaCantidad.class);

                if (codOrdenTrabajoDetalle != null) {
                    q.setParameter("codOrdenTrabajoDetalle", codOrdenTrabajoDetalle);
                }

                List<EntradaSalidaCantidad> entities = (List<EntradaSalidaCantidad>) q.getResultList();
                em.close();
                return entities;
        }
   

}
