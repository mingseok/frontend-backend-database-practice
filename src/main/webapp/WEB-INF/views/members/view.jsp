<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상세화면</title>
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

        h2 {
            text-align: center;
            color: #333;
        }

        .container {
            width: 50%;
            margin: 20px auto;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            border-radius: 8px;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
        }

        input[type="hidden"] {
            display: none;
        }

        input[type="password"] {
            letter-spacing: 2px;
        }
    </style>
</head>
<body>

<h2>상세화면</h2>

<div class="container">

    <input type="hidden" name="id" value="${member.getId()}">

    <label for="id">고유번호</label>
    <input type="text" id="id" name="id" value="${member.getId()}" required readonly>

    <label for="loginId">ID</label>
    <input type="text" id="loginId" name="loginId" value="${member.getLoginId()}" required readonly>

    <label for="memberPwd">비밀번호</label>
    <input type="password" id="memberPwd" name="memberPwd" value="${member.getMemberPwd()}" required readonly>

    <label for="memberName">이름</label>
    <input type="text" id="memberName" name="memberName" value="${member.getMemberName()}" required readonly>

    <label for="joinDate">가입시간</label>
    <input type="text" id="joinDate" name="joinDate" value="${member.getJoinDate()}" required readonly>

</div>

    <a href="/update/${member.getId()}">수정하기</a>

</body>
</html>