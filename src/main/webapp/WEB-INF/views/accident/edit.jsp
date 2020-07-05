<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Edit Accident</title>
</head>
<style>
    .form-group{
        width: 550px;
    }
    .heading {
        margin-left: 15px;
        margin-top: 15px;
    }
</style>
<body>
<div class="container">
    <div class="heading">
        <h2>Редактирование проишествия</h2>
    </div>
    <div class="card-body">
<%--        поменять /save на /edit --%>
        <form  action="<c:url value='/change'/>" modelAtribute="accident" th:object="${accident}" method='POST'>
            <div class="form-group">
                    <input type="hidden" class="form-control" name="id" value=${accident.id}>

                <label>Название: </label>
                <input type="text" class="form-control" name="name">
            </div>
            <div class="form-group">
                <label>Описание: </label>
                <input type="text" class="form-control" name="text">
            </div>
            <div class="form-group">
                <label class="form-check-label">Адрес: </label>
                <input type="text" class="form-control" name="address">
            </div>
            <button type="submit" class="btn btn-primary">Сохранить</button>
        </form>
    </div>
</div>
</body>
</html>
