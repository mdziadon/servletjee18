<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    Ilość kilometrów = ${empty param.km ? 'brak' : (km = param.km)}
</div>
<div>
    Ilość mil = ${empty km ? 'brak' : km * 1.609344}
</div>
</body>
</html>
