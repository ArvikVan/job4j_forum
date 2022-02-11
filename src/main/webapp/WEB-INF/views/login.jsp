<%--
  Created by IntelliJ IDEA.
  User: arvik
  Date: 10.02.2022
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<head>
    <title>Forum-Login</title>
</head>
<body>
<div class="col-md-8 mx-auto">
    <h2>Forum login - авторизация пользователя</h2>
    <c:if test="${not empty errorMessage}">
        <div style="color:red; font-weight: bold; margin: 30px 0px;">
                ${errorMessage}
        </div>
    </c:if>
    <form name='login' action="<c:url value='/login'/>" method='POST'>
        <table>
            <tr>
                <td>UserName:</td>
                <td><input type='text' name='username'></td>
            </tr><br>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='password'/></td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit" value="submit" /></td>
                <td><a href="<c:url value='/reg'/>">Регистрация</a></td>
            </tr>
        </table>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
</div>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</body>
</html>
