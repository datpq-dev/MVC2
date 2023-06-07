/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datpq.controller;

import datpq.registration.RegistrationDAO;
import datpq.registration.RegistrationDTO;
import datpq.util.MyApplicationConstants;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;
 import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
public class LoginServlet extends HttpServlet {
    //public final String INVALID_PAGE = "invalid.html";
    //public final String SEARCH_PAGE = "search.jsp";
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
//        ServletContext context = this.getServletContext();
//        Properties siteMaps = (Properties)context.getAttribute("SITEMAPS");
//        String url = siteMaps.getProperty(
//                        MyApplicationConstants.LoginFeature.INVALID_PAGE);
        String url = MyApplicationConstants.LoginFeature.INVALID_PAGE;
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        
        try {
            //3. call Model/D.A.O
            //3.1 New Obj
            RegistrationDAO dao = new RegistrationDAO();
            //3.2 Call its method
            RegistrationDTO result = dao.checkLogin(username, password);
            //4. send to View
            if (result != null) {
                url = MyApplicationConstants.LoginFeature.SEARCH_PAGE;
                
                HttpSession session = request.getSession();
                session.setAttribute("USER", result);
//                Cookie cookie = new Cookie(username, password);
//                cookie.setMaxAge(60*3);
//                response.addCookie(cookie);
            }
            
        } catch (NamingException ex) {
            log("CreateAccountServlet _ Naming " + ex.getMessage());
        } catch (SQLException ex ) {
            log("CreateAccountServlet _ SQL " + ex.getMessage());
        } finally {
            response.sendRedirect(url);
//            RequestDispatcher rd = request.getRequestDispatcher(url);
//            rd.forward(request, response);
            out.close();
        }
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
