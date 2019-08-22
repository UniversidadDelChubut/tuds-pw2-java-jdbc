package ar.edu.udc.ejemplo_jdbc;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rmpalacio
 */
public class Empleado implements Serializable {

    private Integer id;
    private Integer documento;
    private String apellido;
    private String nombre;

    public Empleado() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private static final String SQL_SELECT_POR_ID = "SELECT * FROM fichadas.empleado WHERE id = ?";

    public static Empleado getPorId(Connection conn, Integer id) throws SQLException {
        Empleado res = new Empleado();

        PreparedStatement pstm = conn.prepareStatement(SQL_SELECT_POR_ID);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            res.setId(rs.getInt("id"));
            res.setDocumento(rs.getInt("documento"));
            res.setApellido(rs.getString("apellido"));
            res.setNombre(rs.getString("nombre"));
        }

        pstm.close();
        rs.close();

        return res;
    }

    @Override
    public String toString() {
        return String.format("%s %s", apellido, nombre);
    }
    
    

}
