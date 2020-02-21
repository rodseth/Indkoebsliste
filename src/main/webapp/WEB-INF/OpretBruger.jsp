<%--
  Created by IntelliJ IDEA.
  User: MariHaugen
  Date: 21/02/2020
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Opret bruger</title>
</head>
<body>

Her kan du registrere deg som bruger på huskelisten
<br>

${requestScope.besked}
<br>
<form action="OpretServlet" method="post">
    <label for="fname">Navn:</label><br>
    <input type="text" id="fname" name="navn"><br>
    <label for="lname">Kodeord:</label><br>
    <input type="text" id="lname" name="kodeord"><br><br>
    <input type="submit" value="Login">
</form>

</body>
</html>
