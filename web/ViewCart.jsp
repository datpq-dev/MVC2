<%-- 
    Document   : ViewCart
    Created on : Feb 27, 2023, 8:34:07 AM
    Author     : ASUS
--%>

<%@page import="java.util.Map"%>
<%@page import="datpq.cart.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Store</title>
    </head>
    <body>
        <h1>Book Store</h1>
        <c:set var="cart" value="${sessionScope.CART}" />
        <c:if test="${not empty cart.items}">
            <form action="removeController">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Name</th>
                            <th>Quantity</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="id" items="${cart.items}" varStatus="counter">
                            <tr>
                                <td>
                                    ${counter.count}
                                </td>
                                <td>
                                    ${id.key}
                                </td>
                                <td>
                                    ${id.value}
                                </td>
                                <td>
                                    <input type="checkbox" name="chkItem" 
                                           value="${id.key}" />
                                </td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td colspan="3">
                                <a href="shoppingController">Add More Items To Your Cart </a>
                            </td>
                            <td>
                                <input type="submit" value="Remove Selected Items" name="btAction" />
                            </td>
                        </tr>
                    </tbody>
            </form>
                </c:if>
                <c:if test="${empty cart.items}"> 
                    <h2>
                        No cart is existed
                    </h2>
                </c:if>
                <%--<%
                    //1. Customer goes to his/her cart place
                    if (session != null) {
                        //2. Customer takes his/her cart
                        CartObj cart = (CartObj) session.getAttribute("CART");

                if (cart != null) {
                    //3. Customer gets all items
                    Map<String, Integer> items = cart.getItems();
                    if (items != null) {
                        //4. show 
        %>
                <form action="DispatchServlet">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Name</th>
                                <th>Quantity</th>
                                <th colspan="2">Action</th>
                            </tr>
                        </thead>
                        <tbody>

                            <%
                                int count = 0;
                                for (String id : items.keySet()) {
                            %>
                            <tr>
                                <td>
                                    <%= ++count%>
                                </td>
                                <td>
                                    <%= id%>
                                </td>
                                <td>
                                    <%= items.get(id)%>
                                </td>
                                <td>
                                    <input type="checkbox" name="chkItem" 
                                           value="<%= id%>" />
                                </td>
                                <td>
                                    <input type="checkbox" name="checkItem" 
                                           value="<%= id%>" />
                                </td>
                            </tr>
                            <%
                                }// end traverse items based on id 
                            %>
                            <tr>
                                <td colspan="3">
                                    <a href="shopping.html">Add More Items To Your Cart </a>
                                </td>
                                <td>
                                    <input type="submit" value="Remove Selected Items" name="btAction" />
                                </td>
                                <td>
                                    <input type="submit" value="Delete Selected Items" name="btAction" />
                                </td> 
                            </tr>
                        </tbody>
                    </table>
                </form>
                <%
                        return;
                    }
                }// cart has existed
                }//end view is executed when cart had existed 
                %>
                <h2>Item Not Found in your Cart</h2>--%>
                </body>
                </html>
