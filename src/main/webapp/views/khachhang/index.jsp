<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 3/14/2023
  Time: 12:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<div class="container">
    <div class="row  mt-4 ">
        <div class="col-2">
            <a class="btn btn-primary mb-2" style="background-color: #6610f2" href="/SOF3011_IT17311_thanhldph22749_war_exploded/khachhang/create" role="button"> Thêm mới</a>
        </div>
        <div class="col-9">
            <h4 style="margin-left: 170px; color: red" class="  mb-3" >Thông tin khách hàng</h4>
        </div>

    </div>

    <c:if test="${ f:length(danhSachKH) == 0 }">
        <h3 class="alert alert-warning">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${ f:length(danhSachKH) != 0 }">
        <table class="table table-hover table-light" style="font-size: 13px;">
            <thead>
            <tr>
                <th scope="col">Mã</th>
                <th scope="col">Họ</th>
                <th scope="col">Tên đệm</th>
                <th scope="col">Tên</th>
                <th scope="col">Ngày sinh</th>
                <th scope="col">Số điện thoại</th>
                <th scope="col">Địa chỉ</th>
                <th scope="col">Mật khẩu</th>
                <th scope="col">Quốc gia</th>
                <th scope="col">Thành phố</th>
                <th scope="col"></th>
                <th scope="col"></th>


            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ danhSachKH }" var="kh">
            <tr >
                <td>${kh.ma}</td>
                <td>${kh.ho}</td>
                <td>${kh.tenDem}</td>
                <td>${kh.ten}</td>
                <td>${kh.ngaySinh}</td>
                <td>${kh.soDienThoai}</td>
                <td>${kh.diaChi}</td>
                <td>${kh.matKhau}</td>
                <td>${kh.quocGia}</td>
                <td>${kh.thanhPho}</td>
                <td ><a href="/SOF3011_IT17311_thanhldph22749_war_exploded/khachhang/edit?ma=${kh.ma}"><i style="color: #0b5ed7;" class="far fa-edit"></i></a></td>
                <td ><a href="/SOF3011_IT17311_thanhldph22749_war_exploded/khachhang/delete?ma=${kh.ma}"><i style="color: red;" class="fas fa-trash-alt"></i></a></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>

    </c:if>
</div>

