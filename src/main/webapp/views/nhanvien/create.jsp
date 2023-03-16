<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 3/13/2023
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nhan Vien</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="col-10 offset-1">
        <form action="/SOF3011_IT17311_thanhldph22749_war_exploded/nhanvien/store" method="post">
            <h3 class="my-3 text-danger text-center">Quản lý nhân viên</h3>
            <div class="row">
                <div class="col-md-4">
                    <label class="form-label">Mã</label>
                    <input type="text" class="form-control" name="ma" placeholder="Nhập mã...">
                </div>
                <div class="col-md-4">
                    <label class="form-label">Họ</label>
                    <input type="text" class="form-control" name="ho" placeholder="Nhập họ...">
                </div>
                <div class="col-md-4">
                    <label class="form-label">Tên đệm</label>
                    <input type="text" class="form-control" name="tenDem" placeholder="Nhập tên đệm...">
                </div>
            </div>
            <div class="row">

                <div class="col-md-4">
                    <label class="form-label">Tên</label>
                    <input type="text" class="form-control" name="ten" placeholder="Nhập tên...">
                </div>


                <div class="col-md-4">
                    <label class="form-label">Ngày sinh</label>
                    <input type="date" class="form-control" name="ngaySinh" placeholder="Nhập ngày sinh...">
                </div>
                <div class="col-md-4">
                    <label class="form-label">Giới tính</label>
                    <select name="gioiTinh" class="form-select">
                        <option value="nv">Nam</option>
                        <option value="ql">Nữ</option>
                    </select>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <label class="form-label">Địa chỉ</label>
                    <input type="text" class="form-control" name="diaChi" placeholder="Nhập địa chỉ...">
                </div>
                <div class="col-md-6">
                    <label class="form-label">Số điện thoại</label>
                    <input type="text" class="form-control" name="soDienThoai" placeholder="Nhập sdt...">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label class="form-label">Cửa hàng</label>
                    <select name="cuaHang" class="form-select">
                        <option value="vi">Việt Nam</option>
                        <option value="us">Mỹ</option>
                    </select>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Chức vụ</label>
                    <select name="chucVu" class="form-select">
                        <option value="nv">Nhân viên</option>
                        <option value="ql">Quản lý</option>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label class="form-label">Mật khẩu</label>
                    <input type="password" class="form-control" name="matKhau" placeholder="Nhập mật khẩu...">
                </div>
                <div class="col-md-6">
                    <label class="form-label">Trạng thái</label>
                    <select name="trangThai" class="form-select">
                        <option >0</option>
                        <option >1</option>
                    </select>
<%--                    <div>--%>
<%--                        <div class="form-check form-check-inline">--%>
<%--                            <input class="form-check-input" type="radio" name="trangThai"--%>
<%--                                   value="tr">--%>
<%--                            <label class="form-check-label">--%>
<%--                                0--%>
<%--                            </label>--%>
<%--                        </div>--%>
<%--                        <div class="form-check form-check-inline">--%>
<%--                            <input class="form-check-input" type="radio" name="trangThai"--%>
<%--                                   value="false">--%>
<%--                            <label class="form-check-label">--%>
<%--                                1--%>
<%--                            </label>--%>
<%--                        </div>--%>
<%--                    </div>--%>
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
    .row {
        margin-top: 15px;
    }
</style>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
