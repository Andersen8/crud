<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 05.02.2018
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit your book</title>
    <style>
        body {
            background: #2a2fc7;
            color: #ff0a1b; /* Цвет текста */
        }
    </style>
</head>
<body>
<div align="center">
    <h3>Please edit book in library</h3>
    <form method="post" action="/change">
    <table border="2" cellspacing="2" cellpadding="2" bgcolor="#7fff00">
        <tr>
            <td>Change title of the book:</td>
            <td><input type="text" name="title"/></td>
        </tr>
        <tr>
            <td>Change description of the book:</td>
            <td><input type="text" name="description"/></td>
        </tr>
        <tr>
            <td>Change ISBN of the book:</td>
            <td><input type="text" name="isbn"/></td>
        </tr>
        <tr>
            <td>Change Year of the book:</td>
            <td><input type="text" name="printYear"/></td>
        </tr>
    </table>
        <button type="submit">Change</button>
    </form>
</div>
</body>
</html>
