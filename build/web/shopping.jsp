<%-- 
    Document   : shopping
    Created on : Mar 4, 2023, 10:53:58 AM
    Author     : ASUS
--%>

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
        <c:set var="prolist" value="${requestScope.PRODUCT}" />
        <c:if test="${not empty prolist}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>SKU</th>
                        <th>ProductName</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${prolist}" varStatus="counter">
                    <form action="addItemToCartController"> 
                        <tr>
                            <td>
                                ${counter.count}
                                .</td>
                            <td>
                                ${dto.sku}
                                <input type="hidden" name="chBook" value="${dto.sku}" />
                            </td>
                            <td>
                                ${dto.productName}
                            </td>
                            <td>
                                ${dto.quantity}
                            </td>
                            <td>
                                ${dto.price}
                            </td>
                            <td>
                                ${dto.status}
                            </td>
                            <td>
                                <input type="submit" value="Add Book to Your Cart" name="btAction" />

                            </td>
                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>   
    <tr>
        <td>
            <form action="viewCartController">
                <input type="submit" value="View Your Cart" name="btAction" />
            </form>
        </td>  
    </tr>
</c:if>
<c:if test="${empty prolist}">
    <h2>
        No record is matched!!!
    </h2>
</c:if>
</body>
</html>
