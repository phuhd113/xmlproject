<%-- 
    Document   : compareDetail
    Created on : Jul 17, 2020, 6:50:12 PM
    Author     : Duy Phu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/main.css" >
        <link rel="stylesheet" type="text/css" href="css/compareDetail.css" >
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compare Product Detail</title>
    </head>
    <body>           
        <div id="wrapper">
            <div id="header">Header</div>
            <div id="menu">
                <ul>
                    <li><a href="homePage.jsp">Sản phẩm</a></li>
                    <li><a href="compare.jsp">So sánh</a></li>
                    <li><a href="ChooseProductServlet">Tìm kiếm</a></li>
                </ul>
            </div>       
            <c:set var="product_1" value="${requestScope.PRODUCT_1}"/>
            <c:set var="detail_1" value="${requestScope.DETAIL_1}"/>
            <c:set var="mark_1" value="${requestScope.MARK_1}"/>
            <c:set var="product_2" value="${requestScope.PRODUCT_2}"/>
            <c:set var="detail_2" value="${requestScope.DETAIL_2}"/>
            <c:set var="mark_2" value="${requestScope.MARK_2}"/>
            <div id="content">
                <div class="compare">                   
                    <h1>Chi tiết 2 sản phẩm</h1>
                    <c:if test="${not empty product_1 and not empty product_2}">
                        <table id="details">
                            <tr>
                                <th>${mark_1.name}</th>
                                <th>Thông số</th>
                                <th>${mark_2.name}</th>
                            </tr>                       
                            <tr>
                                <td>${product_1.branch}</td>
                                <td>Hãng sản xuất</td>
                                <td>${product_2.branch}</td>
                            </tr>  
                            <tr>
                                <td>${detail_1.socket}</td>
                                <td>Socket</td>
                                <td>${detail_2.socket}</td>
                            </tr>  
                            <tr>
                                <td>${detail_1.frequency} GHz</td>
                                <td>Xung nhịp cơ bản</td>
                                <td>${detail_2.frequency} GHz</td>
                            </tr> 
                            <tr>
                                <td>${detail_1.turbo} GHz</td>
                                <td>Xung nhịp tối đa</td>
                                <td>${detail_2.turbo} GHz</td>
                            </tr> 
                            <tr >
                                <td style="font-weight : bold;background-color: darkcyan;">${detail_1.core}</td>
                                <td>Nhân CPU</td>
                                <td style="font-weight : bold;background-color: darkcyan;">${detail_2.core}</td>
                            </tr> 
                            <tr >
                                <td style="font-weight : bold;background-color: darkcyan;">${detail_1.thread}</td>
                                <td>Luồng CPU</td>
                                <td style="font-weight : bold;background-color: darkcyan;">${detail_2.thread}</td>
                            </tr> 
                            <tr>
                                <td>${detail_1.memoryType}</td>
                                <td>Bộ nhớ đệm</td>
                                <td>${detail_2.memoryType}</td>
                            </tr> 
                            <tr>
                                <td>${detail_1.tdp} W</td>
                                <td>Điện áp tiêu thụ tối đa</td>
                                <td>${detail_2.tdp} W</td>
                            </tr> 
                            <tr>
                                <td>
                                    <c:if test="${detail_1.overClocking == true}">
                                        Có
                                    </c:if>
                                    <c:if test="${detail_1.overClocking != true}">
                                        Không
                                    </c:if>
                                    </td>
                                <td>Khả năng ép xung</td>
                                <td>
                                <c:if test="${detail_2.overClocking == true}">
                                        Có
                                    </c:if>
                                    <c:if test="${detail_2.overClocking != true}">
                                        Không
                                    </c:if>
                                </td>
                            </tr> 
                            <tr>
                                <td style="color: blue; font-weight: 600;font-size: 25px;">${mark_1.singleCore}</td>
                                <td>Điểm hiệu năng</td>
                                <td style="color: blue; font-weight: 600;font-size: 25px;">${mark_2.singleCore}</td>
                            </tr> 
                            <tr>
                                <td style="color: red; font-size: 30px;">
                                    <c:if test="${product_1.price != 0}">
                                        <fmt:formatNumber type="number" pattern="#,###" value="${product_1.price}" />  VNĐ
                                    </c:if>
                                    <c:if test="${product_1.price == 0}">
                                        Đang cập nhật
                                    </c:if>
                                </td>
                                <td>Giá sản phẩm</td>
                                <td style="color: red; font-size: 30px;">
                                    <c:if test="${product_2.price != 0}">
                                        <fmt:formatNumber type="number" pattern="#,###" value="${product_2.price}" />  VNĐ
                                    </c:if>
                                    <c:if test="${product_2.price == 0}">
                                        Đang cập nhật
                                    </c:if>
                                </td>
                            </tr> 
                        </table>
                    </c:if>

                </div>






            </div>
        </div>
    </body>
</html>
