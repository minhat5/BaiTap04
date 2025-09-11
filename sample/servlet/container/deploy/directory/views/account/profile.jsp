<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<title>Thông tin cá nhân</title>

<div class="row">
    <div class="col-md-4">
        <c:choose>
            <c:when test="${empty user.avatar}">
                <img class="img-thumbnail"
                     src="<c:url value='/images/default-avatar.png'/>"
                     alt="avatar"
                     style="width:200px;height:200px;object-fit:cover;">
            </c:when>
            <c:otherwise>
                <img class="img-thumbnail"
                     src="<c:url value='${user.avatar}'/>"
                     alt="avatar"
                     style="width:200px;height:200px;object-fit:cover;">
            </c:otherwise>
        </c:choose>
    </div>
    <div class="col-md-8">
        <h3><c:out value="${user.fullname}"/></h3>
        <p><strong>Email:</strong> <c:out value="${user.email}"/></p>
        <p><strong>Số điện thoại:</strong> <c:out value="${user.phone}"/></p>
        <p><strong>Tài khoản:</strong> @<c:out value="${user.username}"/></p>
        <p><strong>Ngày tạo:</strong>
            <fmt:formatDate value="${user.createDate}" pattern="dd/MM/yyyy HH:mm"/>
        </p>
        <a href="${pageContext.request.contextPath}/profile-edit"
           class="btn btn-primary">
            <i class="fa fa-edit"></i> Chỉnh sửa
        </a>
    </div>
</div>
