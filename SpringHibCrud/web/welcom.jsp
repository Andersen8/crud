<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 06.02.2018
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to my Library</title>
    <style>
        body {
            background: #2a2fc7;
            color: #ff0a1b; /* Цвет текста */
        }
    </style>
</head>
<body>
        <div align="center">
            <br><br><br>
            <h1>To start library press START</h1><br>
            <form method="get" action="/add">
                <button type="submit">START</button>
            </form>
        </div>
</body>
</html>
