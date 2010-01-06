package py.com.platinum.controllerUtil;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public abstract class AbstractJpaDao<T> {

    protected EntityManagerFactory emf;

    public AbstractJpaDao() {
        emf = JpaResourceBean.getInstance().getEMF();
    }

    /**
     * Este metodo recibe como parametro un Entity para insertar o persistir
     * dicha entidad a la base de datos.
     * @param entity
     * @return ControllerResult
     */
    public ControllerResult create(T entity) throws RuntimeException {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(entity);
            tx.commit();
            r.setCodRetorno(0);
            r.setMsg("Se creo correctamente el registro");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Error al persistir " + entity.getClass() + ": " + ex);
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

    /**
     * Este metodo recibe como parametro un Entity para actualizar
     * dicha entidad a la base de datos.
     * @param entity
     * @return ControllerResult
     */
    public ControllerResult update(T entity)  {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            r.setCodRetorno(0);
            r.setMsg("Registro actualizado correctamente");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Error al actualizar el registro " + entity.getClass());
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

    /**
     * Este metodo recibe como parametro un Entity para eliminar o borrar
     * dicha entidad a la base de datos.
     * @param entity
     * @return ControllerResult
     */
    public ControllerResult delete(T entity) {
        ControllerResult r = new ControllerResult();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(entity));
            em.getTransaction().commit();
            r.setCodRetorno(0);
            r.setMsg("Registro eliminado correctamente");
        } catch (Exception ex) {
            ex.printStackTrace();
            r.setCodRetorno(-1);
            r.setMsg("Error al persistir " + entity.getClass());
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

    /**
     * Busqueda de un entity por ID
     * @param tipo de entity a ser buscado
     * @param id de la entidad
     * @return Entity
     */
    protected T findById(Class<T> tipo, Long id) {
        EntityManager em = emf.createEntityManager();
        T entity = em.find(tipo, id);
        em.close();
        return entity;
    }

    public abstract T findById(Long id);

    /**
     * Obtener lla lista completa de una entidad
     * @param tipo de entity a ser buscado
     * @param orderBy atributo por el cual sera ordenado
     * @return Lista de la entidad
     */
    protected List<T> getAll(Class<T> tipo, String orderBy) {
        EntityManager em = emf.createEntityManager();
        orderBy = (orderBy != null && orderBy.length() > 0) ? " ORDER BY o." + orderBy : " ";
        List<T> entities = em.createQuery("SELECT o FROM " + tipo.getSimpleName() + " o").getResultList();
        em.close();
        return entities;
    }

    public abstract List<T> getAll(String orderBy);

}

