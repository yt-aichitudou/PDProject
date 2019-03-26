<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>首页</title>
    </head>
    <body>
        欢迎来到首页
        <a href="${pageContext.request.contextPath}/register">用户注册加密</a>
        <a href="${pageContext.request.contextPath}/login">用户登录</a>
        <a href="${pageContext.request.contextPath}/admin">管理员权限访问</a>
        <a href="${pageContext.request.contextPath}/iflogin">登录权限访问</a>
        <a href="${pageContext.request.contextPath}/logout">登出</a>
        <a href="${pageContext.request.contextPath}/insert">增</a>
        <a href="${pageContext.request.contextPath}/delete">删</a>
        <a href="${pageContext.request.contextPath}/update">改</a>
        <a href="${pageContext.request.contextPath}/select">查</a>


    </body>
</html>