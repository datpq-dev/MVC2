/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datpq.controller;

import datpq.registration.RegistrationDAO;
import datpq.registration.RegistrationDTO;
import datpq.registration.RegistrationInsertError;
import datpq.util.MyApplicationConstants;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/CreateAccountServlet"})
public class CreateAccountServlet extends HttpServlet {

    //private final String INSERT_ERROR_PAGE = "createNewAccount.jsp";
    //private final String LOGIN_PAGE = "login.html";

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

        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        String fullName = request.getParameter("txtFullname");

        RegistrationInsertError errors = new RegistrationInsertError();
        boolean bErr = false;
//        ServletContext context = this.getServletContext();
//        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        //String url = siteMaps.getProperty(LOGIN_PAGE);
        String url = MyApplicationConstants.CreateAccountFeature.INSERT_ERROR_PAGE;

        try {
            if (username.trim().length() < 6 || username.trim().length() > 20) {
                bErr = true;
                errors.setUsernameLengthErr("Username length requires 6 - 20 chars");
            }
            if (password.trim().length() < 6 || password.trim().length() > 30) {
                bErr = true;
                errors.setPasswordLengthErr("Password length requires 6 - 30 chars");
            } else if (!confirm.trim().equals(password.trim())) {
                bErr = true;
                errors.setConfirmNotMatch("Confirm MUST match password");
            }
            if (fullName.trim().length() < 2 || fullName.trim().length() > 50) {
                bErr = true;
                errors.setFullNameLengthErr("Full Name length requires 2 - 50 chars");
            }

            if (bErr) {
                request.setAttribute("INSERTER", errors);
            } else {
                RegistrationDTO dto
                        = new RegistrationDTO(username, password, fullName, false);
                RegistrationDAO dao = new RegistrationDAO();
                boolean result = dao.createAccount(dto);

                if (result) {
                    url = MyApplicationConstants.DispatchFeature.LOGIN_PAGE;
                }
            }
        } catch (NamingException ex) {
            log("CreateAccountServlet _ Naming " + ex.getMessage());
        } catch (SQLException ex) {
            String msg = ex.getMessage();
            log("CreateAccountServlet _ SQL " + ex.getMessage());
            if (msg.contains("duplicate")) {
                errors.setUsernameIsExisted(username + " existed!!!");
                request.setAttribute("INSERTER", errors);
            }
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
