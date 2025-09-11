<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<footer class="border-top py-4 mt-5">
<div class="container text-secondary small">
    © ${pageContext.request.serverName} — <span class="text-muted">Made by Nguyen Nhat Minh - 23110265</span>
    <p><br></p>
    <c:if test="${not empty sessionScope.account}">
        <p>Chủ tài khoản: <strong><c:out value="${sessionScope.account.fullname}"/></strong></p>
        <p><br></p>
        <p>Chức năng:
            <strong>
                <c:choose>
                    <c:when test="${sessionScope.account.roleid == 3}">Admin</c:when>
                    <c:when test="${sessionScope.account.roleid == 2}">Manager</c:when>
                    <c:otherwise>User</c:otherwise>
                </c:choose>
            </strong>
        </p>
    </c:if>
</div>
</footer>
