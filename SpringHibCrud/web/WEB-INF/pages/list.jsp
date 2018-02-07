<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 04.02.2018
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Library</title>
    <style>
        body {
            background: #2a2fc7;
            color: #ff0a1b; /* Цвет текста */
        }
    </style>
</head>
<body>

<div align="center">
    <h2>Books in the library:</h2>
    <form action="/find" method="post">
    <h4>Find book by TITLE: <input type="text" name="find"/><button type="submit">Ok</button></h4>
    </form>
    <form action="/add" method="get"><button type="submit">Add new Book</button> </form>
    <table border="2" cellspacing="2" cellpadding="2" bgcolor="#7fff00">
        <tr>
            <th>ID</th>
            <th>TITLE</th>
            <th>DESCRIPTION</th>
            <th>AUTHOR</th>
            <th>ISBN</th>
            <th>YEAR</th>
            <th>IS READ?</th>
        </tr>
        <c:forEach items="${list}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.description}</td>
                <td>${book.author}</td>
                <td>${book.isbn}</td>
                <td>${book.printYear}</td>
                <td>${book.readAlready}</td>
                <td><form action="/delete" method="post">
                    <input type="hidden" name="id" value="${book.id}"/>
                    <button type="submit">Delete</button>
                </form>
                </td>
                <td><form action="/updateread" method="post">
                    <input type="hidden" name="id" value="${book.id}"/>
                    <button type="submit">Read Already</button>
                </form> </td>
                <td><form action="/updatetdip" method="get">
                    <input type="hidden" name="id" value="${book.id}"/>
                    <button type="submit">Edit Book</button>
                </form></td>
            </tr>
        </c:forEach>
    </table>
    <form action="/paginationM" method="post">
        <button type="submit"><--</button>
    </form>
    <form action="/paginationP" method="post">
        <button type="submit">--></button>
    </form>
</div>
</body>
</html>
