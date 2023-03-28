/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contededor;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marcela Portillo
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        String _usuario= request.getParameter("usuario");    
        String _password= request.getParameter("password");
        if(_usuario !=null && _password !=null){
        if(_usuario.equals("admin")&&_password.equals("prn315")){
            response.sendRedirect("http://localhost:8080/PRN315_GRUPO_7-war/faces/PlantillaGrupo7.xhtml");
        
        
       }else{
        out.println("usuario o contraseña inavalido");
        }
        
        
        }else{
       out.println("Porfavor escriba el usuario y contraseña");
       }
    }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    
}
