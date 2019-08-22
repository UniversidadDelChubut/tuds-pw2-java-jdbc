package ar.edu.udc.ejemplo_jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Pool {

    private static DataSource dataSource = null;
    
    public static Connection getConnection(String nombre_recurso) throws NamingException, SQLException {
        
        if (dataSource == null) {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/" + nombre_recurso);
        }
        Connection conn = dataSource.getConnection();

        return conn;
    }

    public static void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (Exception ex) {
            // silencio las excepciones en caso de error cerrando las conexiones.
        }
    }
}
