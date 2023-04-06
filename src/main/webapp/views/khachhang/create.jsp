<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 3/11/2023
  Time: 10:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
        <form action="/SOF3011_IT17311_thanhldph22749_war_exploded/khachhang/store" method="post" >
            <h4 class="my-3 text-danger text-center">Quản lý khách hàng</h4>
            <div class="row mt-3">
                <div class="col-md-6">
                    <label class="form-label">Mã</label>
                    <input type="text" class="form-control" name="ma" placeholder="Nhập mã...">
                    <span style="color:red;font-size: 16px">${trungMa}</span>
                    <span style="color:red;font-size: 16px">${checkMa}</span>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Họ</label>
                    <input type="text" class="form-control" name="ho" placeholder="Nhập họ...">
                    <span style="color:red;font-size: 16px">${checkHo}</span>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-md-6">
                    <label class="form-label">Tên đệm</label>
                    <input type="text" class="form-control" name="tenDem" placeholder="Nhập tên đệm...">
                    <span style="color:red;font-size: 16px">${checkTenDem}</span>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Tên</label>
                    <input type="text" class="form-control" name="ten" placeholder="Nhập tên...">
                    <span style="color:red;font-size: 16px">${checkTen}</span>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-md-6">
                    <label class="form-label">Ngày sinh</label>
                    <input type="date" class="form-control" name="ngaySinh" placeholder="Nhập ngày sinh...">
                    <span style="color:red;font-size: 16px">${checkNgaySinh}</span>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Số điện thoại </label>
                    <input type="text" class="form-control" name="soDienThoai" placeholder="Nhập sdt...">
                    <span style="color:red;font-size: 16px">${checkSDT}</span>
                </div>
            </div>

            <div class="row mt-3">
                <div class="col-md-6">
                    <label class="form-label">Địa chỉ</label>
                    <input type="text" class="form-control" name="diaChi" placeholder="Nhập địa chỉ...">
                    <span style="color:red;font-size: 16px">${checkDiaChi}</span>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Mật khẩu</label>
                    <input type="password" class="form-control" name="matKhau" placeholder="Nhập mật khẩu...">
                    <span style="color:red;font-size: 16px">${checkMatKhau}</span>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-md-6">
                    <label class="form-label">Quốc gia</label>
                    <select name="quocGia" class="form-select">
                        <option value="Việt Nam">Việt Nam</option>
                        <option value="Mỹ">Mỹ</option>
                    </select>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Thành phố</label>
                    <select name="thanhPho" class="form-select">
                        <option value="Thái Nguyên">Thái Nguyên</option>
                        <option value="Bắc Ninh">Bắc Ninh</option>
                    </select>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <button class="btn btn-primary" style="background-color: #6610f2">Thêm mới</button>
                </div>
                <div class="col-6"></div>
            </div>
        </form>
</div>

