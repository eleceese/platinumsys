package py.com.platinum.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBManager {

    public static Connection conn = null;
    public static String dataSourceContext;

    public DBManager(String dataSourceContext) {
        DBManager.dataSourceContext = dataSourceContext;
        conn = getJNDIConnection();
    }

    public static DBManager getInstance() {
        FacesContext fc = FacesContext.getCurrentInstance();
        return (DBManager) fc.getApplication().getVariableResolver().resolveVariable(fc, "DBManager");
    }

    /** Uses JNDI and Datasource (preferred style).   */
    public static Connection getJNDIConnection() {
        //String DATASOURCE_CONTEXT = "jdbc/cdm";
        dataSourceContext = "";
        String dsc = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("APP_DATA_SOURCE_NAME");

        if (dsc != null) {
            dataSourceContext = dsc;
        }
        String DATASOURCE_CONTEXT = dataSourceContext;

        Connection result = null;
        try {
            Context initialContext = new InitialContext();
            if (initialContext == null) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, "JNDI problem. Cannot get InitialContext.");
            }
            DataSource datasource = (DataSource) initialContext.lookup(DATASOURCE_CONTEXT);
            if (datasource != null) {
                result = datasource.getConnection();
            } else {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, "Failed to lookup datasource.");
            }
        } catch (NamingException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, "Cannot get connection: " + ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, "Cannot get connection: " + ex);
        }
        return result;
    }

    public static boolean conectar() {
        //Variables
        //ParametroManager man;
        //EntityManager em;
        //Session s;

        if (conn != null) {
            return true;
        }
        try {
//            man = new ParametroManager();
//
//            em = man.emf.createEntityManager();
//            s = (Session) em.getDelegate();
            //conn = s.connection();
            conn = getJNDIConnection();
            return true;
        } catch (Exception sqlex) {
            sqlex.printStackTrace();
            return false;
        }
    }

    public static void cerrarBD() {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }
}
