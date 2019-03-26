<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/registerUser">
    用户名：<input type="text" name="username" >
    密码：<input type="password" name="password">
    <input type="submit" value="注册">
</form>
</body>

</html>