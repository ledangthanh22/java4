<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 3/13/2023
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cua Hang</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="col-8 offset-2">
        <form action="" method="post" action="/SOF3011_IT17311_thanhldph22749_war_exploded/cuahang/store">
            <h3 class="text-center my-4 text-danger">Quản lý cửa hàng</h3>
            <div class="col-md-12 ">
                <label class="form-label">Mã</label>
                <input type="text" name="ma" class="form-control" placeholder="Nhập mã...">
            </div>
            <div class="col-md-12 mt-3">
                <label class="form-label">Tên</label>
                <input type="text" name="ten" class="form-control" placeholder="Nhập tên...">
            </div>
            <div class="col-md-12 mt-3">
                <label class="form-label">Địa chỉ</label>
                <input type="text" name="diaChi" class="form-control" placeholder="Nhập địa chỉ...">
            </div>
            <div class="row mt-3">
                <div class="col-md-6">
                    <label class="form-label">Thành phố</label>
                    <select class="form-select" name="thanhPho">
                        <option value="vn">Thái Nguyên</option>
                        <option value="bn">Bắc Ninh</option>
                        <option value="hn">Hà Nội</option>
                    </select>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Quốc gia</label>
                    <select class="form-select" name="quocGia">
                        <option value="vn">Việt Nam</option>
                        <option value="tl">Thái Lan</option>
                        <option value="tq">Trung Quốc</option>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
