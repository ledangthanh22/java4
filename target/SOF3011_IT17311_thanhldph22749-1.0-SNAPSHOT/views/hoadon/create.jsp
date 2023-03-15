<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 3/13/2023
  Time: 8:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hoa Don</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="col-10 offset-1">
        <form action="" method="post" >
            <h3 class="my-3 text-danger text-center">Quản lý hóa đơn</h3>
            <div class="row">
                <div class="col-md-6">
                    <label class="form-label">Mã</label>
                    <input type="text" class="form-control" name="ma" placeholder="Nhập mã...">
                </div>
                <div class="col-md-6">
                    <label class="form-label">Ngày tạo</label>
                    <input type="date" class="form-control" name="ngayTao" >
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label class="form-label">Ngày thanh toán</label>
                    <input type="date" class="form-control" name="ngayThanhToan" >
                </div>
                <div class="col-md-6">
                    <label class="form-label">Ngày ship</label>
                    <input type="date" class="form-control" name="ngayShip" >
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label class="form-label">Ngày nhận</label>
                    <input type="date" class="form-control" name="ngayNhan" >
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
                    <label class="form-label">Tên người nhận</label>
                    <input type="password" class="form-control" name="tenNguoiNhan" placeholder="Nhập tên người nhận...">
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <label class="form-label">Nhân viên</label>
                    <select name="nhanVien" class="form-select">
                        <option value="ldt">Lê Đăng Thành</option>
                        <option value="ldth">Lê Đăng Thực</option>
                        <option value="lad">Lê Anh Dũng</option>

                    </select>
                </div>
                <div class="col-md-4">
                    <label class="form-label">Khách hàng</label>
                    <select name="khachHang" class="form-select">
                        <option value="ldt">Lê Đăng Thành</option>
                        <option value="ldth">Lê Đăng Thực</option>
                        <option value="lad">Lê Anh Dũng</option>
                    </select>
                </div>
                <div class="col-md-4">
                    <label class="form-label">Tình trạng</label>
                    <select name="tinhTrang" class="form-select">
                        <option value="ldt">Đã thanh toán</option>
                        <option value="ldth">Chưa thanh toán</option>
                        <option value="lad">Đã hủy</option>
                    </select>
            </div>


        </form>
    </div>
</div>
<style>
    .row{
        margin-top: 15px;
    }
</style>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
