<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/2
  Time: 10:00
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
        <td>id</td>
        <td>商品名称</td>
        <td>商品价格</td>
    </tr>
    <tr>
        <td>${product.id}</td>
        <td>${product.productname}</td>
        <td>${product.price}</td>
    </tr>
</table>
</body>
</html>
