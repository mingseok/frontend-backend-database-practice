<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        form {
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin: 10px 0 5px;
            color: #555;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            background-color: #4caf50;
            color: #fff;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }

        button:hover {
            background-color: #45a049;
        }

        .home-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            text-decoration: none;
            color: #555;
            font-size: 14px;
        }

        .home-link:hover {
            color: #333;
        }
    </style>
</head>

<body>
<form action="/sign-up" method="post">
    <h2>회원등록</h2>

    <label for="username">사용자 ID 입력</label>
    <input type="text" id="username" name="loginId" required>

    <label for="password">사용자 비밀번호 입력</label>
    <input type="password" id="password" name="memberPwd" required>

    <label for="nickname">사용자 이름 입력</label>
    <input type="text" id="nickname" name="memberName" required>

    <button type="submit">가입하기</button>
</form>

<a href="/" class="home-link">초기화면</a>
</body>
</html>
