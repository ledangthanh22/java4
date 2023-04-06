
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<div class="container">
    <div class="row  mt-4 ">
        <div class="col-3">
            <a class="btn btn-primary mb-2" style="background-color: #6610f2" href="/SOF3011_IT17311_thanhldph22749_war_exploded/sanphamct/create" role="button"> Thêm mới</a>
        </div>
        <div class="col-9">
            <h4 style="margin-left: 65px; color: red" class="  mb-3" >Thông tin sản phẩm chi tiết</h4>
        </div>
    </div>
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
                <th scope="col">Ảnh</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${danhSachSPCT}" var="spct">
                <tr>
                    <td>${spct.sanPham.ten}</td>
                    <td>${spct.nSX.ten}</td>
                    <td>${spct.mauSac.ten}</td>
                    <td>${spct.dongSP.ten}</td>
                    <td>${spct.namBH}</td>
                    <td>${spct.soLuongTon}</td>
                    <td>${spct.giaNhap}</td>
                    <td>${spct.giaBan}</td>
                    <td>${spct.moTa}</td>
                    <td>${spct.anh}</td>
                    <td><a href="/SOF3011_IT17311_thanhldph22749_war_exploded/sanphamct/edit?id=${spct.id}" ><i style="color: red;" class="far fa-edit"></i></a></td>
                    <td><a href="/SOF3011_IT17311_thanhldph22749_war_exploded/sanphamct/delete?id=${spct.id}"><i style="color: red;" class="fas fa-trash-alt"></i></a></td>
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
