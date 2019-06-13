<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="/mvc13">
    <label>Tytuł:
        <input type="text" name="title"/>
    </label><br><br>

    <label>Autor:
        <input type="text" name="author"/>
    </label><br><br>

    <label>ISBN:
        <input type="text" name="isbn"/>
    </label><br><br>

    <input type="submit" value="Zapisz"/>
</form>

</body>
</html>
