package ar.edu.udc.ejemplo_jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rmpalacio
 */
@WebServlet("")
public class ListadoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        
        try {
            conn = Pool.getConnection("fichadas");
            Date hoy = new Date();
            List datos = Fichada.getListado(conn, hoy);
            req.setAttribute("datos", datos);
            req.setAttribute("hoy", hoy);
            req.getRequestDispatcher("/listado.jsp").forward(req, resp);
            
        } catch(Exception ex) {
            throw new ServletException(ex.getMessage(), ex);
        } finally {
            Pool.closeConnection(conn);
        }
    }
}
