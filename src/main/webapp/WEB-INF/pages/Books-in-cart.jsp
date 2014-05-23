<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Books in Cart</title>
</head>
<body>
<h1>
    Books in your cart:
</h1>

<form>
    <table>
        <tr>
            <th>ISBN</th>
            <th style="padding-left: 100px">Book name</th>
        </tr>

        <c:forEach items="${cookie}" var="bookName">
            <tr>
                <td></td>
                <td style="padding-left: 100px">${bookName.value.value}</td>
            </tr>
        </c:forEach>

    </table>
</form>
</body>
</html>