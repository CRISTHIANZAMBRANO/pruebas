/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.secoco;

import co.edu.unipiloto.secoco.entity.Usuarios;
import co.edu.unipiloto.secoco.session.UsuarioDaoLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author crist
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

    @EJB
    private UsuarioDaoLocal usuarioDao;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action= request.getParameter("action");
        String cedulaStr= request.getParameter("cedula");
        int cedula=0;
        if(cedulaStr!=null && !cedulaStr.equals(""))
            cedula=Integer.parseInt(cedulaStr);
        String nombre= request.getParameter("nombre");
        String apellido= request.getParameter("apellido");
        String correo= request.getParameter("correo");
        String clave= request.getParameter("clave");
        Usuarios usuario= new Usuarios(cedula, nombre, apellido, correo, clave);
        if("Add".equalsIgnoreCase(action)){
            usuarioDao.addUsuario(usuario);
        }else if("Edit".equalsIgnoreCase(action)){
            usuarioDao.editUsuario(usuario);
        }else if("Delete".equalsIgnoreCase(action)){
            usuarioDao.deleteUsuario(cedula);
        }else if("Search".equalsIgnoreCase(action)){
            usuario= usuarioDao.getUsuario(cedula);
        }
        request.setAttribute("usuario", usuario);
        request.setAttribute("allUsuario", usuarioDao.getAllUsuarios());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
