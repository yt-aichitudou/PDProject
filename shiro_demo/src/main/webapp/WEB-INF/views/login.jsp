﻿<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>登录</title>

    </head>
    <body>
        <form method="post" action="${pageContext.request.contextPath}/loginCheck">
            用户名：<input type="text" name="username" >
            密码：<input type="password" name="password">
            <input type="submit" value="登录">
        </form>

    </body>
</html>