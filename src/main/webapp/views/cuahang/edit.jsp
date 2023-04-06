
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="col-8 offset-2">
        <form action="/SOF3011_IT17311_thanhldph22749_war_exploded/cuahang/update?ma=${ch.ma}" method="post" >
            <h4 class="text-center my-4 text-danger">Cập nhật cửa hàng</h4>
            <div class="col-md-12 ">
                <label class="form-label">Mã</label>
                <input type="text" name="ma" class="form-control" placeholder="Nhập mã..." value="${ch.ma}" disabled>
            </div>
            <div class="col-md-12 mt-3">
                <label class="form-label">Tên</label>
                <input type="text" name="ten" class="form-control" placeholder="Nhập tên..." value="${ch.ten}">
                <span style="color:red;font-size: 16px">${checkTen}</span>
            </div>
            <div class="col-md-12 mt-3">
                <label class="form-label">Địa chỉ</label>
                <input type="text" name="diaChi" class="form-control" placeholder="Nhập địa chỉ..." value="${ch.diaChi}" >
                <span style="color:red;font-size: 16px">${checkDiaChi}</span>
            </div>
            <div class="col-md-12 mt-3">
                <label class="form-label">Thành phố</label>
                <input type="text" name="thanhPho" class="form-control" placeholder="Nhập tên thành phố..." value="${ch.thanhPho}">
                <span style="color:red;font-size: 16px">${checkThanhPho}</span>
            </div>
            <div class="col-md-12 mt-3">
                <label class="form-label">Quốc gia</label>
                <input type="text" name="quocGia" class="form-control" placeholder="Nhập tên quốc gia..." value="${ch.quocGia}">
                <span style="color:red;font-size: 16px">${checkQuocGia}</span>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <button class="btn btn-primary" style="background-color: #6610f2">Cập nhật</button>
                </div>
                <div class="col-6"></div>
            </div>
        </form>
    </div>
</div>

