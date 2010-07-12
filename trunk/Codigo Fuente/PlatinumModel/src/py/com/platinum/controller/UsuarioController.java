/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.platinum.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import py.com.platinum.controllerUtil.AbstractJpaDao;
import py.com.platinum.entity.Usuarios;

/**
 *
 * @author FerBoy
 */
public class UsuarioController extends AbstractJpaDao <Usuarios> {

    public Usuarios getUsuario(String usuario){

        String SQL = "SELECT o FROM Usuarios o WHERE UPPER(o.usuario) = UPPER(:usuario)";

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        q.setParameter("usuario", usuario);

        Usuarios us = null;
         try {
            us = (Usuarios) q.getSingleResult();

        } catch (NoResultException e) {
            e.printStackTrace();

        }

        em.close();
        return us;
        
}


    public UsuarioController() {
        super();
    }

    @Override
    public Usuarios findById(Long id) {
        return (Usuarios) this.findById(Usuarios.class, id);
    }

    @Override
    public List<Usuarios> getAll(String orderBy) {
        return this.getAll(Usuarios.class, orderBy);
    }

    public List<Usuarios> getAllFiltered(String usuario, Long codEmpleado, String rol) {
        //emf.createEntityManager Levanta el contexto del JPA
        String SQL = "SELECT o FROM Usuarios o WHERE o.usuario= o.usuario";

        if (usuario != null && !usuario.equals("")) {
            SQL = SQL + " and UPPER(o.usuario) like upper(:usuario)";
        }

        if (rol != null && !rol.equals("")) {
            SQL = SQL + " and UPPER(o.rol) like upper(:rol)";
        }

        if (codEmpleado != null) {
            SQL = SQL + " and o.codEmpleado.codEmpleado = (:codEmpleado)";
        }

        
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery(SQL);

        if (usuario != null && !usuario.equals("")) {
            q.setParameter("usuario", "%"+usuario+"%");
        }

        if (rol != null && !rol.equals("")) {
            q.setParameter("rol", "%"+rol+"%");
        }

        if (codEmpleado != null) {
            q.setParameter("codEmpleado",codEmpleado);
        }

        List<Usuarios> entities = q.getResultList();
        em.close();

        return entities;

      }

}
