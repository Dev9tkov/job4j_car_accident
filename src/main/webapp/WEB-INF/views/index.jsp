<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Accident</title>
</head>
<body>

<h2 style="text-align: center">Accidents</h2>

<div class="card-body">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Text</th>
            <th scope="col">Address</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${accidents}" var="accident">
            <tr>
                <td>${accident.id}</td>
                <td>${accident.name}</td>
                <td>${accident.text}</td>
                <td>${accident.address}
                    <a href="<c:url value="/edit?id=${accident.id}"/>">Редактировать</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div>
    <a class="nav-link" href="<c:url value="/create"/>">Добавить инцидент</a>
</div>
</body>
</html>