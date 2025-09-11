<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin home</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/style/style.css">
</head>
<body>
<div class="page">
    <h2>Xin chào Admin: ${sessionScope.account.fullname}</h2>
    <p>Đây là trang quản trị dành cho admin.</p>
</div>
</body>
</html>