<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h1>oauth2 테스트 화면</h1>
<div class="col-md-12">
    <!--로그인 기능 영역-->
    <div class="row">
        <div class="col-md-6">
            <a href="/sign-up" role="button" class="btn btn-primary">글 등록</a>
            <a href="/list" role="button" class="btn btn-primary">메인화면</a>


            <%--히든 화면 작성중--%>
            <c:choose>
                <c:when test="${role ne null && not empty role}">
                    <a href="/test" role="button" class="btn btn-primary">USER 등급일때만</a>
                </c:when>

                <c:otherwise>
                    <a href="/oauth2/authorization/google" class="btn btn-success active" role="button">로그인 하면 보이는 히든</a>
                </c:otherwise>
            </c:choose>

            <br/>

            <%--로그아웃 상태에서 인가 필요한 화면으로 이동한다--%>
            <c:choose>
                <c:when test="${userName ne null && not empty userName}">
                    Logged in as: <span id="user">${userName}</span>
                    <%--<%=userName%>--%>
                    <a href="/logout" class="btn btn-info active" role="button">Logout</a>
                </c:when>

                <c:otherwise>
                    <a href="/oauth2/authorization/google" class="btn btn-success active" role="button">Google Login</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
<br>
</body>
</html>