<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MariHaugen
  Date: 21/02/2020
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>INDKØB</title>
</head>
<body>

${sessionScope.besked}
<br>
<br>
<h1>Velkommen til Maris første webshop</h1>
<h3>På denne siden tilføye emner til din inkøbskurv</h3>

<form action="AddItemServlet" method="post">
    <label for="fname">Angiv varenavn</label><br>
    <input type="text" id="fname" name="vareNavn"><br>
    <input type="submit" value="Tilføj">
</form>
<br>

${requestScope.besked}

<br>
<br>

<c:forEach var="element" items="${sessionScope.basket}">

    ${element}
    <br>

</c:forEach>

<br>
<br>
<br>
<br>
<br>

<form action="LogOutServlet" method="post">

    <input type="submit" value="logout">
</form>

</body>
</html>
