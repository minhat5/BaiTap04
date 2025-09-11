<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css"/>

<div class="page">
    <div class="container">
        <div class="card" style="width:100%">
            <div class="row" style="justify-content: space-between; align-items: center;">
                <h2>Danh sách danh mục</h2>
                <a class="btn" href="${pageContext.request.contextPath}/category/create">+ Thêm danh mục</a>
            </div>

            <table class="table">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Mã</th>
                    <th>Tên danh mục</th>
                    <th>Mô tả</th>
                    <th>Vai trò</th>
                    <th>Hành động</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="cate" items="${item}" varStatus="st">
                    <tr>
                        <td>${st.index + 1}</td>
                        <td>${cate.cate_id}</td>
                        <td><c:out value="${cate.cate_name}"/></td>
                        <td><c:out value="${cate.description}"/></td>
                        <td>
                            <span class="label" style="margin-left:8px;">
                            <c:choose>
                                <c:when test="${cate.user.roleid == 3}">Admin</c:when>
                                <c:when test="${cate.user.roleid == 2}">Manager</c:when>
                                <c:otherwise>User</c:otherwise>
                            </c:choose>
                          </span>
                        </td>
                        <td class="options">
                            <a href="${pageContext.request.contextPath}/category/view?id=${cate.cate_id}">Xem</a>
                            <a href="${pageContext.request.contextPath}/category/edit?id=${cate.cate_id}">Sửa</a>
                            <a href="${pageContext.request.contextPath}/category/delete?id=${cate.cate_id}"
                               onclick="return confirm('Xóa danh mục này?');">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
