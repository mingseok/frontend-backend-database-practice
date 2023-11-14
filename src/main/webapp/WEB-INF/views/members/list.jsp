<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring Boot User List</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 10px;
            text-align: center; /* 가운데 정렬 추가 */
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #4caf50;
            color: white;
        }

        tbody tr:hover {
            background-color: #f5f5f5;
        }

        .align-center {
            text-align: center;
        }

        .align-right {
            margin-top: 10px;
            text-align: right;
        }

        button {
            background-color: #4caf50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        button:hover {
            background-color: #45a049;
        }

        a {
            text-decoration: none;
            color: #4caf50;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>
<h1>User List</h1>
<table border="1">
    <thead>
    <tr>
        <th>고유번호</th>
        <th>사용자 이름</th>
        <th>사용자 가입시간</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="data" items="${list}">
        <tr>
            <td>${data.id}</td>
            <td>
                <a href="<c:url value='/view/${data.id}'/>">${data.memberName}</a>

            </td>
            <td>${data.joinDate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="align-right">
    <button onclick="location.href='./sign-up'">계정등록</button>
</div>
</body>
</html>