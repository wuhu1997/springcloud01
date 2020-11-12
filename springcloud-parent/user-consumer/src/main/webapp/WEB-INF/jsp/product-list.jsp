<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/31
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/feign/ordersfind?userid=${userid}">查询订单</a>
<form action="/feign/profindid">
    <table>
        <tr>
            <td>输入商品ID</td>
            <td>
                <input id="id" name="id" type="text"/>
            </td>
        </tr>
    </table>
</form>
<%--<table>--%>
    <%--<tr>用户ID</tr>--%>
    <%--<tr>${userid}</tr>--%>
<%--</table>--%>
<table>
    <tr>
        <td>id</td>
        <td>商品名称</td>
        <td>商品价格</td>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.productname}</td>
            <td>${product.price}</td>
            <td><input type="button" value="加入购物车" onclick='location.href="/feign/orderadd?userid=${userid}&productid=${product.id}&productname=${product.productname}&price=${product.price}"'></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>