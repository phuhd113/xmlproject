<%-- 
    Document   : Compare
    Created on : Jul 12, 2020, 2:01:12 PM
    Author     : Duy Phu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/main.css" >
        <link rel="stylesheet" type="text/css" href="css/compare.css" >
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compare Page</title>
    </head>
    <body>

        <div id="wrapper">
            <div id="header">Header</div>
            <div id="menu">
                <ul>
                    <li><a href="homePage.jsp">Sản phẩm</a></li>
                    <li><a class="active" href="compare.jsp">So sánh</a></li>
                    <li><a href="ChooseProductServlet">Tìm kiếm</a></li>
                </ul>
            </div>
            <div id="content">     
                <c:set var="product_1" value="${sessionScope.PRODUCT_1}" />
                <c:set var="product_2" value="${sessionScope.PRODUCT_2}" />
                <!-- CPU 1 -->
                <div class="product">
                    <form action="ProcessServlet">
                        <input type="submit" value="Chọn sản phẩm" name="btAction">
                        <input type="hidden" name="product" value="1"/>
                    </form>
                    <c:if test="${not empty product_1}">
                        <div class="product_search">
                            <img src="${product_1.image}"/>
                            <h1 style="color: black;">${product_1.name}</h1>
                        </div>
                    </c:if>

                </div>
                <div class="product">
                    <form action="ProcessServlet">
                        <input type="submit" value="Chọn sản phẩm" name="btAction">
                        <input type="hidden" name="product" value="2"/>
                    </form>
                    <c:if test="${not empty product_2}">
                        <div class="product_search">
                            <img src="${product_2.image}"/>
                            <h1 style="color: black;">${product_2.name}</h1>
                        </div>
                    </c:if>

                </div>
                <form action="ProcessServlet">
                    <input type="submit" value="So Sánh" id="compare" name="btAction">
                    <input type="hidden" value="${product_2.id}" name="idProduct_2">
                    <input type="hidden" value="${product_1.id}" name="idProduct_1">
                </form>
                
            </div>
            <!-- CPU 2 -->


        </div>
    </div>
    <script src="js/compare.js"></script>
</body>
</html>
