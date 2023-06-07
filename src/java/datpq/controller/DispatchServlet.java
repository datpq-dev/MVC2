///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package datpq.controller;
//
//import datpq.util.MyApplicationConstants;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Properties;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author ASUS
// */
//@WebServlet(name = "DispatchServlet", urlPatterns = {"/DispatchServlet"})
//public class DispatchServlet extends HttpServlet {
//
//    //private final String LOGIN_PAGE = "login.html";
//    //private final String LOGIN_PAGE = "loginPage";
//    //private final String LOGIN_CONTROLLER = "LoginServlet";
//    //private final String LOGIN_CONTROLLER = "loginController";
//    //private final String SEARCH_CONTROLLER = "SearchLastnameServlet";
//    //private final String DELETE_CONTROLLER = "DeleteServlet";
//    //private final String UPDATE_CONTROLLER = "UpdateServlet";
//    //private final String START_CONTROLLER = "StartTimeServlet";
//    //private final String ADD_ITEM_TO_CART_CONTROLLER = "AddItemToCartServlet";
//    //private final String VIEW_CART_CONTROLLER = "ViewCart.jsp";
//    //private final String REMOVE_CART_CONTROLLER = "RemoveItemServlet";
//    //private final String DELETE_CART_CONTROLLER = "DeleteItemServlet";
//    //private final String CREATE_NEW_ACCOUNT_CONTROLLER = "CreateAccountServlet";
//    //private final String LOG_OUT_CONTROLLER = "LogoutServlet";
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
////        response.setContentType("text/html;charset=UTF-8");
////        PrintWriter out = response.getWriter();
////
////        //1.Which button did user click?
////        String button = request.getParameter("btAction");
////        ServletContext context = this.getServletContext();
////        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
////        //String url = siteMaps.getProperty(LOGIN_PAGE);
////        String url = siteMaps.getProperty(
////                MyApplicationConstants.DispatchFeature.LOGIN_PAGE);
////
////        try {
////            if (button == null) {
////                //fw to login page
////                //url = START_CONTROLLER;
////            } else if (button.equals("Login")) {
////                //url = siteMaps.getProperty(LOGIN_PAGE);
////                url = siteMaps.getProperty(
////                        MyApplicationConstants.DispatchFeature.LOGIN_CONTROLLER);
////            } else if(button.equals("Search")) {
////                url = siteMaps.getProperty(
////                        MyApplicationConstants.SearchFeature.SEARCH_CONTROLLER);
////            } else if (button.equals("Log out")) {
////                url = siteMaps.getProperty(
////                        MyApplicationConstants.LoginFeature.LOG_OUT_CONTROLLER);
////            }  else if (button.equals("delete")) {
////                url = siteMaps.getProperty(
////                        MyApplicationConstants.SearchFeature.DELETE_CONTROLLER);
////            } else if (button.equals("Update")) {
////                url = siteMaps.getProperty(
////                        MyApplicationConstants.SearchFeature.UPDATE_CONTROLLER);
////            } else if (button.equals("Add Book to Your Cart")) {
////                url = siteMaps.getProperty(
////                        MyApplicationConstants.ShoppingFeature.ADD_ITEM_TO_CART_CONTROLLER);
////            } else if (button.equals("View Your Cart")) {
////                url = siteMaps.getProperty(
////                        MyApplicationConstants.ShoppingFeature.VIEW_CART_CONTROLLER);
////            } else if (button.equals("Remove Selected Items")) {
////                url = siteMaps.getProperty(
////                        MyApplicationConstants.ShoppingFeature.REMOVE_CART_CONTROLLER);
////            } else if (button.equals("Delete Selected Items")) {
////                url = siteMaps.getProperty(
////                        MyApplicationConstants.ShoppingFeature.DELETE_CART_CONTROLLER);
////            } else if (button.equals("Create New Account")) {
////                url = siteMaps.getProperty(
////                        MyApplicationConstants.CreateAccountFeature.CREATE_NEW_ACCOUNT_CONTROLLER);
////            }
////        } finally {
////            RequestDispatcher rd = request.getRequestDispatcher(url);
////            rd.forward(request, response);
////            out.close();
////        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
