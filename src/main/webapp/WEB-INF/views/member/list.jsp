<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring Boot</title></head>
<body>
    <h1>LIST</h1>
        <table border="1">
            <thead>
                    <tr>
                        <th>id</th>
                        <th>email</th>
                        <th>password</th>
                        <th>-</th>
                    </tr>
            </thead>
            <tbody>
            <c:forEach var="data" items="${list}">
                    <tr>
                        <td>${data.id}</td>
                        <td><a href="./mod/${data.id}">${data.email}</a></td>
                        <td>${data.password}</td>
                        <td><a href="./del/${data.id}">삭제</a></td>
                    </tr>
            </c:forEach>
            </tbody>
        </table>
    <a href="./add">입력</a>
</body>
</html>
