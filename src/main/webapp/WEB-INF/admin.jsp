<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MariHaugen
  Date: 21/02/2020
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>

Her kan du se en liste af brugere, og du kan slette brugere.
<br>
<br>
${requestScope.besked}
<form action="AdminServlet" method="post">
    <label for="fname">Slett bruger</label><br>
    <input type="text" id="fname" name="navn"><br>
    <input type="submit" value="Slett">
</form>

<br>
<br>

<c:forEach var="element" items="${applicationScope.brugerMap}">

    ${element}
    <br>

</c:forEach>

</body>
</html>
