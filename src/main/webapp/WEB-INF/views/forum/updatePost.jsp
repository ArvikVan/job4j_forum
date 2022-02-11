<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arvik
  Date: 10.02.2022
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>forum - редактирование темы</title>
</head>
<body>
<div class="col-md-8 mx-auto">
    <h2>Edite - Posts - table</h2>
    <form  action="<c:url value='/save?id=${post.id}'/>" method='POST'>
    <table class="table table-bordered">
        <td>Enter Postname:</td>
        <td><input type='text' name='name' value="${post.name}"></td>
        </tr>
        <tr>
            <td>Enter description:</td>
            <td><input type='text' name='description' value="${post.description}"></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="UpdatePost" /></td>
        </tr>
    </table>
    </form>
    <a href="<c:url value='/'/>">Back to main page</a>

</div>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</body>
</html>
