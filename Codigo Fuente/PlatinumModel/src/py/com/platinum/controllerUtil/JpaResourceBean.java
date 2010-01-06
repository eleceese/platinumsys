package py.com.platinum.controllerUtil;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * This is an Application Scoped bean that holds the JPA 
 * EntityManagerFactory.  By making this bean Applciation scoped the 
 * EntityManagerFactory resource will be created only once for the application
 * and cached here.
 *
 * @author Gordon Yorke
 */
public class JpaResourceBean {

    private static EntityManagerFactory emf;
    private static JpaResourceBean instance;

    public JpaResourceBean() {
    }
    
    public EntityManagerFactory getEMF() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("PlatinumModelPU");
        }
        return emf;
    }
    
    public static JpaResourceBean getInstance() {
        if(instance == null) instance =  new JpaResourceBean();
        return instance;       
    }
}
