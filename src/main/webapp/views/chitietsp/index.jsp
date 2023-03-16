<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 3/15/2023
  Time: 7:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>San PhamCT</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3 class="text-center my-3 text-danger">Thông tin sản phẩm chi tiết</h3>
    <c:if test="${f:length(danhSachSPCT)==0}">
        <h3 class="alert alert-warning">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${f:length(danhSachSPCT)!=0}">
        <table class="table table-hover" style="font-size: 13px">
            <thead>
            <tr>
                <th scope="col">Sản phẩm</th>
                <th scope="col">NSX</th>
                <th scope="col">Màu sắc</th>
                <th scope="col">Dòng sản phẩm</th>
                <th scope="col">Năm bảo hành</th>
                <th scope="col">Số lượng tồn</th>
                <th scope="col">Giá nhập</th>
                <th scope="col">Giá bán</th>
                <th scope="col">Mô tả</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${danhSachSPCT}" var="spct">
                <tr>
                    <th>${spct.tenSanPham}</th>
                    <th>${spct.tenNSX}</th>
                    <th>${spct.tenMauSac}</th>
                    <th>${spct.tenDongSP}</th>
                    <th>${spct.namBH}</th>
                    <th>${spct.soLuongTon}</th>
                    <th>${spct.giaNhap}</th>
                    <th>${spct.giaBan}</th>
                    <th>${spct.moTa}</th>

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
