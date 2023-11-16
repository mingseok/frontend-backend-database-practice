<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>스프링 부트로 시작하는 웹 서비스</title>
</head>
<body>
<h1>구글 로그인 하고 움직이자</h1>
<div class="col-md-12">
    <!-- 로그인 기능 영역 -->
    <div class="row">
        <a href="./list" role="button" class="btn btn-primary">메인 화면</a>
        <a href="./sign-up" role="button" class="btn btn-primary">회원 등록</a>
        <a href="./view" role="button" class="btn btn-primary">수정 화면</a>

        <c:if test="${not empty username}">
            Logged in as: <span id="user">${username}</span>
            <a href="/logout" class="btn btn-info active" role="button">로그아웃</a>
        </c:if>
        <c:if test="${empty username}">
            <a href="/oauth2/authorization/google" class="btn btn-success active" role="button">Google 로그인</a>
        </c:if>
    </div>
</div>
</body>
</html>