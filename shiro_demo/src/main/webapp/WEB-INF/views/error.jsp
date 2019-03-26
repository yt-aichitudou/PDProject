<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
${info}
${user.username}欢迎登录！
<a href="${pageContext.request.contextPath}/logout">登出</a>

</body>
</html>