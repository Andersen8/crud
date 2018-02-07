<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 03.02.2018
  Time: 0:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Books library</title>
    <style>
      body {
        background: #2a2fc7;
        color: #ff0a1b; /* Цвет текста */
      }
    </style>
  </head>
  <body>
      <div align="center">
        <form method="post" action="/add">
        <h2>Please add book to the library</h2>
          <table border="2" cellpadding="2" cellspacing="2" bgcolor="#7fff00">
            <tr>
              <td><h4>Input title of the book:</h4></td>
              <td><h4><input type="text" name="title"/></h4></td>
            </tr>
            <tr>
              <td><h4>Input description of the book:</h4></td>
              <td><h4><input type="text" name="description"/></h4></td>
            </tr>
            <tr>
              <td><h4>Input author of the book:</h4></td>
              <td><h4><input type="text" name="author"/></h4></td>
            </tr>
            <tr>
              <td><h4>Input isbn of the book:</h4></td>
              <td><h4><input type="text" name="isbn"/></h4></td>
            </tr>
            <tr>
              <td><h4>Input Year of the book:</h4></td>
              <td><h4><input type="text" name="printYear"/></h4></td>
            </tr>
            <tr>
              <td><h4>Already read the book?</h4></td>
              <td><h4><select name="readAlready" size="1">
                <option value="false">No</option>
                <option value="true">Yes</option>
              </select></h4></td>
            </tr>
          </table>
          <p><button type="submit">Confirm</button></p>
        </form>
        <form method="get" action="/list"><button type="submit">To Library</button> </form>

      </div>
  </body>
</html>
