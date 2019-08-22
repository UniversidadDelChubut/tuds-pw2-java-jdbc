package ar.edu.udc.ejemplo_jdbc;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rmpalacio
 */
public class Fichada implements Serializable {

    private Integer id;
    private Integer empleadoId;
    private Date fechaHora;
    private String tipoMovimiento;

    public Fichada() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleado_id) {
        this.empleadoId = empleado_id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipo_movimiento) {
        this.tipoMovimiento = tipo_movimiento;
    }

    private static final String SQL_SELECT_TODAS = "SELECT * FROM fichadas.movimiento WHERE fecha_hora::date = ?";

    public static List getListado(Connection conn, Date fecha) throws SQLException {
        List<Fichada> res = new ArrayList();

        PreparedStatement pstm = conn.prepareStatement(SQL_SELECT_TODAS);
        pstm.setDate(1, new java.sql.Date(fecha.getTime()));
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            do {
                Fichada item = new Fichada();
                item.setId(rs.getInt("id"));
                item.setEmpleadoId(rs.getInt("empleado_id"));
                item.setTipoMovimiento(rs.getString("tipo_movimiento"));
                item.setFechaHora(rs.getDate("fecha_hora"));

                res.add(item);
            } while (rs.next());
        }

        pstm.close();
        rs.close();

        return res;
    }

}
