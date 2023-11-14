<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Member</title>
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
    </style>
</head>
<body>

<h2>Update Member</h2>

<div class="container">
    <form action="/update" method="post">
        <input type="hidden" name="id" value="${member.getId()}">

        <label for="loginId">ID 수정</label>
        <input type="text" id="loginId" name="loginId" value="${member.getLoginId()}" required>

        <label for="memberPwd">비밀번호 수정</label>
        <input type="password" id="memberPwd" name="memberPwd" value="${member.getMemberPwd()}" required>

        <label for="memberName">이름 수정</label>
        <input type="text" id="memberName" name="memberName" value="${member.getMemberName()}" required>

        <button type="submit">저장</button>
    </form>
</div>

</body>
</html>