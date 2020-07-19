<%-- 
    Document   : HomePage
    Created on : Jul 8, 2020, 4:11:52 PM
    Author     : Duy Phu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/main.css" >
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>           
        <div id="wrapper">
            <div id="header">Header</div>
            <div id="menu">
                <ul>
                    <li><a class="active" href="homePage.jsp">Sản phẩm</a></li>
                    <li><a href="compare.jsp">So sánh</a></li>
                    <li><a href="ChooseProductServlet">Tìm kiếm</a></li>
                </ul>
            </div>
            <div id="search">
                <c:set var="searchValue" value="${param.searchTxt}"/>
                <form action="ProcessServlet">
                    <c:if test="${not empty searchValue}">
                        <input type="text" name="searchTxt" placeholder="Nhập mã hoặc tên sản phẩm..." value="${searchValue}">
                    </c:if> 
                    <c:if test="${empty searchValue}">
                        <input type="text" name="searchTxt" placeholder="Nhập mã hoặc tên sản phẩm...">
                    </c:if>
                    <input type="submit" name="btAction" value="Tìm kiếm" /> 
                </form>
            </div>
            <div id="content">
                <c:set var="products" value="${requestScope.PRODUCTS}"/>
                <c:set var="pagesize" value="${requestScope.PAGESIZE}"/>               
                <c:if test="${not empty products}">
                    <c:if test="${not empty searchValue}">
                        <c:import var="xsl" url="xsl/search.xsl" charEncoding="utf-8"/>
                        <x:transform doc="${products}" xslt="${xsl}">
                            <x:param name="searchValue" value="${searchValue}"/>
                        </x:transform>
                    </c:if>
                    <c:if test="${empty searchValue}">
                        <c:import var="xsl" url="xsl/homeView.xsl" charEncoding="utf-8"/>
                        <x:transform doc="${products}" xslt="${xsl}"/>
                    </c:if>

                </c:if>
                <c:if test="${not empty pagesize}">
                    <div id="page">
                        <c:forEach var ="i" begin="1" end="${pagesize}">
                            <form action="homePage.jsp">
                                <input type="submit" value="${i}" id="btnPage" name="page" />
                            </form>                           
                        </c:forEach>       
                    </div>
                </c:if>
            </div>


        </div>
    </body>
</html>
