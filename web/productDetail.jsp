<%-- 
    Document   : HomePage
    Created on : Jul 15, 2020, 4:11:52 PM
    Author     : Duy Phu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/main.css" >
        <link rel="stylesheet" type="text/css" href="css/detail.css" >
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Detail</title>
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
            <c:set var="product" value="${requestScope.PRODUCT}"/>
            <c:set var="detail" value="${requestScope.PRODUCTDETAIL}"/>
            <c:set var="mark" value="${requestScope.PRODUCTMARK}"/>

            <div id="content">
                <c:if test="${not empty product}">
                    <div class="images">
                        <img src="${product.image}" />
                    </div>                   
                    <div class="product">
                        <div class="name">
                            <h1>${product.name}</h1>
                        </div>
                        <div class="description">
                            <p style="font-weight: bold">Nhà sản xuất : </p>
                            <p> ${product.branch}</p></br><br/>
                            <p style="font-weight: bold">Tình trạng : </p>
                            <p> New - 100%</p></br><br/>
                            <p style="font-weight: bold">Bảo hành : </p>
                            <p> 36 tháng</p>

                        </div>
                        <div class="price">
                            <h1>
                                <c:if test="${product.price != 0}">
                                    <fmt:formatNumber type="number" pattern="#,###" value="${product.price}" />  VNĐ
                                </c:if>
                                <c:if test="${product.price == 0}">
                                    Liên hệ
                                </c:if>
                            </h1>
                        </div>

                        <div class="buttons">
                            <input type="submit" value="Đặt hàng" name="btAction"/>
                            <input type="submit" value="So sánh" name="btAction"/>
                        </div>
                    </div>
                </c:if>
                <c:if test="${not empty detail}">
                    <table id="details">
                        <tr>
                            <th>Mô tả chi tiết</th>
                        </tr>                       
                        <tr>
                            <td>Hãng sản xuất</td>
                            <td>${product.branch}</td>
                        </tr>  
                        <tr>
                            <td>Socket</td>
                            <td>${detail.socket}</td>
                        </tr>  
                        <tr>
                            <td>Xung nhịp cơ bản</td>
                            <td>${detail.frequency}</td>
                        </tr> 
                        <tr>
                            <td>Xung nhịp tối đa</td>
                            <td>${detail.turbo}</td>
                        </tr> 
                        <tr>
                            <td>Nhân CPU</td>
                            <td>${detail.core}</td>
                        </tr> 
                        <tr>
                            <td>Luồng CPU</td>
                            <td>${detail.thread}</td>
                        </tr> 
                        <tr>
                            <td>Bộ nhớ đệm</td>
                            <td>${detail.memoryType}</td>
                        </tr> 
                        <tr>
                            <td>Điện áp tiêu thụ tối đa</td>
                            <td>${detail.tdp}</td>
                        </tr> 
                        <tr>
                            <td>Khả năng ép xung</td>
                            <td>${detail.overClocking}</td>
                        </tr> 
                    </table>
                </c:if>
                <c:if test="${not empty mark}">
                    <div class="mark">
                        <h1>Điểm đánh giá hiệu năng :</h1>
                        <p> ${mark.singleCore} </p>
                    </div>
                </c:if>

            </div>
        </div>
    </body>
</html>
