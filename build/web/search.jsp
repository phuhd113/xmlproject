<%-- 
    Document   : Search
    Created on : Jul 12, 2020, 3:14:13 PM
    Author     : Duy Phu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/main.css" >
        <link rel="stylesheet" type="text/css" href="css/search.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>

    </head>
    <body>
        <div id="wrapper">
            <div id="header">Header</div>
            <div id="menu">
                <ul>
                    <li><a href="homePage.jsp">Sản phẩm</a></li>
                    <li><a href="compare.jsp">So sánh</a></li>
                    <li><a class="active" href="ChooseProductServlet">Tìm kiếm</a></li>
                </ul>
            </div>
            <div id="content">           
                <c:set var="hashMap" value="${requestScope.HASHMAP}"/>
                <div class="filter"> 
                    <h1>Test</h1>
                    <c:if test="${not empty hashMap}">
                        <form action="ProcessServlet">
                            <div class="selectChoose">
                                <p>Nhà sản xuất : </p>                            
                                <select name="branch">
                                    <option>Tất cả</option>
                                    <c:forEach var="hash" items="${hashMap['branch']}">
                                        <option><c:out value="${hash.value()}"/></option>
                                    </c:forEach>                                
                                </select>
                            </div>
                            <div class="selectChoose">
                                <p>Loại : </p>
                                <select name="typeCPU">
                                    <option>Tất cả</option>
                                    <c:forEach var="hash" items="${hashMap['type']}">
                                        <option><c:out value="${hash.value()}"/></option>
                                    </c:forEach>    
                                </select>
                            </div>
                            <div class="selectChoose">
                                <p>Số nhân : </p>
                                <select name="core">
                                    <option>Tất cả</option>
                                    <c:forEach var="hash" items="${hashMap['core']}">
                                        <option><c:out value="${hash}"/></option>
                                    </c:forEach>  
                                </select>
                            </div>
                            <div class="selectChoose">
                                <p>Số luồng : </p>
                                <select name="thread">
                                    <option>Tất cả</option>
                                    <c:forEach var="hash" items="${hashMap['thread']}">
                                        <option><c:out value="${hash}"/></option>
                                    </c:forEach>  
                                </select>
                            </div>
                            <div class="selectChoose">
                                <p>Bộ nhớ đệm : </p>
                                <select name="memory">
                                    <option>Tất cả</option>
                                    <c:forEach var="hash" items="${hashMap['memoryType']}">
                                        <option><c:out value="${hash}"/></option>
                                    </c:forEach>  
                                </select>
                            </div>

                            <div class="selectChoose">
                                <p>Socket : </p>
                                <select name="socket">
                                    <option>Tất cả</option>
                                    <c:forEach var="hash" items="${hashMap['socket']}">
                                        <option><c:out value="${hash}"/></option>
                                    </c:forEach>  
                                </select>
                            </div>
                            <div class="selectChoose">
                                <p>Khả năng ép xung : </p>
                                <select name="overClocking">
                                    <option>Tất cả</option>
                                    <option>Có</option>
                                    <option>Không</option>
                                </select>
                            </div>
                            <input type="submit" name="btAction" value="TÌM KIẾM"/>                           
                        </form>
                    </c:if>        
                </div>
                <!--Result filter -->
                <c:set var="products" value="${requestScope.RESULT}"/>  
                <div class="resultFilter">
                    <c:if test="${not empty products}">
                        <table id="tableProduct" >
                            <tr>
                                <th></th>
                                <th>Tên CPU</th>
                                <th>Loại CPU</th>

                            </tr>
                            <c:forEach var = "product" items="${products}">
                                <tr>
                                    <td><img src="${product.image}"></td>
                                    <td>${product.name}</td>
                                    <td>${product.type}</td>                            
                                    <td>
                                        <form action="ProcessServlet">
                                            <input type="submit" name="btAction" value="Chọn"/>
                                            <input type="hidden" name="productId" value="${product.id}"/>
                                        </form>

                                    </td>
                                </tr> 
                            </c:forEach>
                        </table>
                    </c:if>  
                    <c:if test="${empty products}">
                        <h1 style="color: red; margin-top: 30px;">Không có sản phẩm nào phù hợp.</h1>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>
