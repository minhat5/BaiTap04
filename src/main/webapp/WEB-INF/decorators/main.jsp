<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8"/>
    <title><sitemesh:write property="title"/></title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"/>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"/>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style.css"/>

    <style>
        :root { --nav-h: 64px; }
        body { padding-top: var(--nav-h); }
    </style>
    <sitemesh:write property="head"/>
</head>
<body class="bg-light">
<%@ include file="/views/topbar/topbar.jsp" %>

<main class="container py-4">
    <sitemesh:write property="body"/>
</main>

<jsp:include page="/common/footer.jsp" />

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<sitemesh:write property="page.script"/>
</body>
</html>
