<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>MOD</title></head>
<body>
    <h1>MOD</h1>
    <form action="./" method="post">
        <label>email</label>
        <input type="text" name="email" value="${data.email }">

        <br>

        <label>password</label>
        <input type="text" name="password" value="${data.password }">

        <br>

        <input type="submit" value="수정">
        <input type="hidden" name="id" value="${data.id }">
    </form>
    <a href="../list">리스트</a></body>

</html>