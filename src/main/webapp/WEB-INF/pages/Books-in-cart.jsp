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

        <c:forEach items="${bookList}" var="book">
            <tr>
                <td>${book.ISBN}</td>
                <td style="padding-left: 100px">${book.name}</td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>