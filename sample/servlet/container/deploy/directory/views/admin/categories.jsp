<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Categories</title></head>
<body>
<h2>Categories</h2>

<form method="post" action="${pageContext.request.contextPath}/admin/categories/insert">
    <input type="text" name="name" placeholder="Category name" required/>
    <button type="submit">Add</button>
</form>

<hr/>
<table border="1" cellpadding="6">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Image</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${categories}">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>
                <c:choose>
                    <c:when test="${not empty c.image}">
                        <img src="${c.image}" alt="img" style="max-height:40px"/>
                    </c:when>
                    <c:otherwise>—</c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>
</body>
</html>
