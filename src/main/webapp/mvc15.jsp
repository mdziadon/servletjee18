<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>Ilość książek = ${size = (empty param.count ? 1 : param.count)}</p>
    <a href="/mvc15show">Książki z sesji</a>

    <form method="post">

        <c:forEach begin="1" end="${size}" varStatus="status">
            <h3>Książka ${status.count}</h3>
            <label>Tytuł:
                <input type="text" name="title"/>
            </label><br><br>

            <label>Autor:
                <input type="text" name="author"/>
            </label><br><br>

            <label>ISBN:
                <input type="text" name="isbn"/>
            </label><br><br>
        </c:forEach>

        <input type="submit" value="Zapisz"/>

    </form>

</body>
</html>
