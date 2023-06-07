<%-- 
    Document   : createNewAccount
    Created on : Feb 28, 2023, 12:59:29 AM
    Author     : ASUS
--%>

<%--<%@page import="datpq.registration.RegistrationInsertError"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New Account</title>
    </head>
    <body>
        <h1>Create Account</h1>
        <form action="createAccountController" method="POST">
            <c:set var="errors" value="${requestScope.INSERTER}" />
            
            Username* <input type="text" name="txtUsername" value="${param.txtUsername}" />(6 - 20 chars)<br/>
            <c:if test="${not empty errors.usernameLengthErr}">
                <font color="red">
                    ${errors.usernameLengthErr}
                </font><br/>
            </c:if>
            <%--<font color="red">
                <%
                    RegistrationInsertError errors =
                                        (RegistrationInsertError) request.getAttribute("INSERTER");
                    if (errors != null) {
                            if (errors.getUsernameLengthErr() != null) {
                                    %> 
                                        <%= errors.getUsernameLengthErr() %><br/>
            <%
                                }
                        }//end of errors
                %>
            </font>--%>
            
            <c:if test="${not empty errors.usernameIsExisted}">
                <font color="red">
                    ${errors.usernameIsExisted}
                </font><br/>
            </c:if>
            
            Password* <input type="password" name="txtPassword" value="" />(6 - 30 chars)<br/>
            <c:if test="${not empty errors.passwordLengthErr}">
                <font color="red">
                    ${errors.passwordLengthErr}
                </font><br/>
            </c:if>
            <%--<font color="red">
                <%
                    if (errors != null) {
                            if (errors.getPasswordLengthErr() != null) {
                                    %> 
                                        <%= errors.getPasswordLengthErr() %><br/>
            <%
                                }
                        }//end of errors
                %>
            </font>--%>
            
            Confirm* <input type="password" name="txtConfirm" value="" /><br/>
            <c:if test="${not empty errors.confirmNotMatch}">
                <font color="red">
                    ${errors.confirmNotMatch}
                </font><br/>
            </c:if>
            <%--<font color="red">
                <%
                    if (errors != null) {
                            if (errors.getConfirmNotMatch() != null) {
                                    %> 
                                        <%= errors.getConfirmNotMatch() %><br/>
            <%
                                }
                        }//end of errors
                %>
            </font>--%>
            
            Full name* <input type="text" name="txtFullname" value="${param.txtFullname}" />(2 - 50 chars)<br/>
            <c:if test="${not empty errors.fullNameLengthErr}">
                <font color="red">
                    ${errors.fullNameLengthErr}
                </font><br/>
            </c:if>
            <%--<font color="red">
                <%
                    if (errors != null) {
                            if (errors.getFullNameLengthErr() != null) {
                                    %> 
                                        <%= errors.getFullNameLengthErr() %><br/>
            <%
                                }
                        }//end of errors
                %>
            </font>--%>
            <input type="submit" value="Create New Account" name="btAction" />
            <input type="reset" value="Resest" />
        </form><br/>
        <%--<font color="red">
                <%
                    if (errors != null) {
                            if (errors.getUsernameIsExisted() != null) {
                                    %> 
                                        <%= errors.getUsernameIsExisted() %><br/>
            <%
                                }
                        }//end of errors
                %>
            </font>--%>
    </body>
</html>
