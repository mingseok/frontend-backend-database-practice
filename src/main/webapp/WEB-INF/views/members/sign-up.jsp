<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
</head>
<body>
<h2>회원가입</h2>
<form action="/sign-up" method="post">
    <label for="username">사용자 ID 입력</label>
    <input type="text" id="username" name="loginId" required>
    <br>

    <label for="password">사용자 비밀번호 입력</label>
    <input type="password" id="password" name="memberPwd" required>
    <br>

    <label for="nickname">사용자 이름 입력</label>
    <input type="text" id="nickname" name="memberName" required>
    <br>

    <button type="submit">가입하기</button>
</form>
</body>
</html>