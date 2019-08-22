package ar.edu.udc.ejemplo_jdbc;

import java.io.IOException;
import java.sql.Connection;
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
        try {
            Connection conn = Pool.getConnection("fichadas");
            
            List datos = Fichada.getListado(conn);
            req.setAttribute("datos", datos);
            req.getRequestDispatcher("/listado.jsp").forward(req, resp);
            
        } catch(Exception ex) {
            throw new ServletException(ex.getMessage(), ex);
        }
        
        
    }
    
}
