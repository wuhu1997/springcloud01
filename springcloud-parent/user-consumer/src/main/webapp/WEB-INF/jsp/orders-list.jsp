<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/2
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
<tr>
    <td>订单编号</td>
    <td>商品数量</td>
    <td>订单状态</td>
    <td>商品名称</td>
    <td>商品价格</td>
</tr>
<c:forEach items="${ordersList}" var="order">
    <tr>
        <td>${order.ordersnum}</td>
        <td>${order.number}</td>
        <%--<td>${order.orderStatus}</td>--%>
        <td>
            <c:if test="${order.orderStatus == 0 }">未支付</c:if>
            <c:if test="${order.orderStatus == 1 }">已支付</c:if>
        </td>
        <td>${order.product.productname}</td>
        <td>${order.product.price}</td>
        <td><input type="button" value="删除" onclick='location.href="/feign/deleteorder?orderid=${order.id}&userid=${order.userid}"'></td>
        <td><input type="button" value="结账" onclick='location.href="/feign/phyment?productid=${order.productid}&orderid=${order.id}&userid=${order.userid}"'></td>
    </tr>
</c:forEach>
</table>
</body>
</html>
