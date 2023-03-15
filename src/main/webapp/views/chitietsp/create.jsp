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
    <title>Chi Tiet SP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <div class="col-10 offset-1">
        <form action="" method="post">
            <h3 class="text-center my-4 text-danger">Quản lý chi tiết sản phẩm</h3>
            <div class="row mt-3">
                <div class="col-md-6">
                    <label class="form-label">Sản phẩm</label>
                    <select class="form-select" name="tenSanPham">
                        <option value="asm">Áo sơ mi</option>
                        <option value="qj">Quần jen</option>

                    </select>
                </div>
                <div class="col-md-6">
                    <label class="form-label">NSX</label>
                    <select class="form-select" name="tenNSX">
                        <option value="vn">Việt Nam</option>
                        <option value="tl">Thái Lan</option>
                    </select>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-md-6">
                    <label class="form-label">Màu sắc</label>
                    <select class="form-select" name="tenMauSac">
                        <option value="d">Đỏ</option>
                        <option value="x">Xanh</option>
                    </select>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Dòng sản phẩm</label>
                    <select class="form-select" name="tenDongSP">
                        <option value="a">Áo</option>
                        <option value="q">Quần</option>
                    </select>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-md-6 ">
                    <label class="form-label">Năm bảo hành</label>
                    <input type="text" name="namBH" class="form-control" placeholder="Nhập năm bảo hành...">
                </div>
                <div class="col-md-6">
                    <label class="form-label">Số lượng tồn</label>
                    <input type="text" name="soLuongTon" class="form-control" placeholder="Nhập số lượng...">
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-md-6 ">
                    <label class="form-label">Giá nhập</label>
                    <input type="text" name="giaNhap" class="form-control" placeholder="Nhập giá nhập...">
                </div>
                <div class="col-md-6">
                    <label class="form-label">Giá bán</label>
                    <input type="text" name="giaBan" class="form-control" placeholder="Nhập bán...">
                </div>
            </div>
            <div class="col-md-12">
                <label class="form-label" >Mô tả</label>
                <textarea name="moTa" class="form-control" placeholder="Nhập mô tả..."></textarea>
            </div>

        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
