<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<title>Cập nhật hồ sơ</title>

<div class="container">
    <h3>Cập nhật hồ sơ</h3>
    <form method="post" action="<c:url value='/profile-edit'/>" enctype="multipart/form-data">
        <div class="mb-3">
            <label class="form-label">Họ và tên</label>
            <input type="text" name="fullname" class="form-control" value="${user.fullname}" required/>
        </div>

        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="email" name="email" class="form-control" value="${user.email}" required/>
        </div>

        <div class="mb-3">
            <label class="form-label">Số điện thoại</label>
            <input type="text" name="phone" class="form-control" value="${user.phone}"/>
        </div>

        <div class="mb-3">
            <label class="form-label">Ảnh đại diện</label>
            <input type="file" name="image" accept=".png,.jpg,.jpeg,.webp" class="form-control"/>
            <div class="mt-2">
                <img src="<c:url value='${empty user.avatar ? "/images/default-avatar.png" : user.avatar}'/>"
                     class="img-thumbnail" style="max-height:160px" alt="preview">
            </div>
        </div>

        <button class="btn btn-primary" type="submit">Lưu thay đổi</button>
        <a class="btn btn-secondary" href="<c:url value='/profile'/>">Hủy</a>
    </form>
</div>
