<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/31
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/feign/userfind">
        <table >
        <tr>
            <td>用户登录</td>
        </tr>
        <tr>
            <td>
                <table>
                    <tr>
                        <td>用户名：</td>
                        <td>
                            <input id="username" name="username" type="text"/>
                        </td>
                    </tr>
                    <tr>
                        <td>密码：</td>
                        <td>
                            <input id="password" name="password" type="password" />
                        </td>
                    </tr>
                </table></td>
        </tr>
            <input type="submit" value="登录">
    </table>
</form>
</body>
</html>
