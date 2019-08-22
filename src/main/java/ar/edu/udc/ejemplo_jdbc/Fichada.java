package ar.edu.udc.ejemplo_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rmpalacio
 */
public class Fichada {

    private static final String SQL_SELECT_TODAS = "SELECT * FROM fichadas.movimiento";

    public static List getListado(Connection conn) throws SQLException {
        List<Map> res = new ArrayList();

        PreparedStatement pstm = conn.prepareStatement(SQL_SELECT_TODAS);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            do {
                Map item = new HashMap();
                item.put("id", rs.getInt("id"));
                item.put("empleado_id", rs.getInt("empleado_id"));
                item.put("tipo_movimiento", rs.getString("tipo_movimiento"));
                
                
                res.add(item);
            } while (rs.next());
        }
        rs.close();
        pstm.close();

        return res;
    }

}
