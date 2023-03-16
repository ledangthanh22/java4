<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 3/11/2023
  Time: 10:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Khach Hang</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="col-10 offset-1">
        <form action="/SOF3011_IT17311_thanhldph22749_war_exploded/khachhang/store" method="post" >
            <h3 class="my-3 text-danger text-center">Quản lý khách hàng</h3>
            <div class="row">
                <div class="col-md-6">
                    <label class="form-label">Mã</label>
                    <input type="text" class="form-control" name="ma" placeholder="Nhập mã...">
                </div>
                <div class="col-md-6">
                    <label class="form-label">Họ</label>
                    <input type="text" class="form-control" name="ho" placeholder="Nhập họ...">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label class="form-label">Tên đệm</label>
                    <input type="text" class="form-control" name="tenDem" placeholder="Nhập tên đệm...">
                </div>
                <div class="col-md-6">
                    <label class="form-label">Tên</label>
                    <input type="text" class="form-control" name="ten" placeholder="Nhập tên...">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label class="form-label">Ngày sinh</label>
                    <input type="date" class="form-control" name="ngaySinh" placeholder="Nhập ngày sinh...">
                </div>
                <div class="col-md-6">
                    <label class="form-label">Số điện thoại </label>
                    <input type="text" class="form-control" name="soDienThoai" placeholder="Nhập sdt...">
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <label class="form-label">Địa chỉ</label>
                    <input type="text" class="form-control" name="diaChi" placeholder="Nhập địa chỉ...">
                </div>
                <div class="col-md-6">
                    <label class="form-label">Mật khẩu</label>
                    <input type="password" class="form-control" name="matKhau" placeholder="Nhập mật khẩu...">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label class="form-label">Quốc gia</label>
                    <select name="quocGia" class="form-select">
                        <option value="vi">Việt Nam</option>
                        <option value="us">Mỹ</option>
                    </select>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Thành phố</label>
                    <select name="thanhPho" class="form-select">
                        <option value="vi">Thái Nguyên</option>
                        <option value="us">Bắc Ninh</option>
                    </select>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <button class="btn btn-primary">Thêm mới</button>
                </div>
                <div class="col-6"></div>
            </div>
        </form>
    </div>
</div>
<style>
    .row{
        margin-top: 13px;
    }
</style>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>