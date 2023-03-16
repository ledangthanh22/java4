<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 3/15/2023
  Time: 7:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Khach Hang</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3 class="text-center my-3 text-danger">Thông tin nhân viên</h3>
    <c:if test="${ f:length(danhSachNV) == 0 }">
        <h3 class="alert alert-warning">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${ f:length(danhSachNV) != 0 }">
        <table class="table table-hover" style="font-size: 13px">
            <thead>
            <tr>
                <th scope="col">Mã</th>
                <th scope="col">Họ</th>
                <th scope="col">Tên đệm</th>
                <th scope="col">Tên</th>
                <th scope="col">Giới tính</th>
                <th scope="col">Ngày sinh</th>
                <th scope="col">Địa chỉ</th>
                <th scope="col">Số điện thoại</th>
                <th scope="col">Mật khẩu</th>
                <th scope="col">Cửa hàng</th>
                <th scope="col">Chức vụ</th>
                <th scope="col">Trạng thái</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ danhSachNV }" var="nv">
                <tr>
                    <th>${nv.ma}</th>
                    <th>${nv.ho}</th>
                    <th>${nv.tenDem}</th>
                    <th>${nv.ten}</th>
                    <th>${nv.gioiTinh}</th>
                    <th>${nv.ngaySinh}</th>
                    <th>${nv.diaChi}</th>
                    <th>${nv.soDienThoai}</th>
                    <th>${nv.matKhau}</th>
                    <th>${nv.cuaHang}</th>
                    <th>${nv.chucVu}</th>
                    <th>${nv.trangThai}</th>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </c:if>
</div>
<style>

</style>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
