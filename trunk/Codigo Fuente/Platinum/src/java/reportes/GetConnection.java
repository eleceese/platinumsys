
package reportes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class GetConnection {
            /**
            * Provided by driver documentation. In this case, a MySql driver is
            * used.
            */
            public static Connection getSimpleConnection(){
            Connection result = null;
            try {
            Class.forName(fDriverName).newInstance();
            } catch (Exception ex) {
            System.err.println("Check classpath. Cannot load db driver: " + ex);
            }

            try {
            result = DriverManager.getConnection(fDbName, fUserName, fPassword);
            } catch (SQLException e) {
            System.err.println("Driver loaded, but cannot connect to db: " + e);
            }
            return result;
            } // PRIVATE //



            private static final String fDriverName = "oracle.jdbc.OracleDriver";
            /**
            * See driver documentation for the proper format of this string.
            */
            private static final String fDbName = "jdbc:oracle:thin:@localhost:1521:xe";
            /*private static final String fUserName = "pbflota_aplicacao";
            private static final String fPassword = "D8sdgter0p";*/
            private static final String fUserName = "sad";
            private static final String fPassword = "sad";


}
