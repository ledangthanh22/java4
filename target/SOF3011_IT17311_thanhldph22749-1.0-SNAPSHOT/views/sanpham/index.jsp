<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 3/15/2023
  Time: 7:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<div class="container">
    <div class="col-10 offset-1">
        <div class="row  mt-4 ">
            <div class="col-3">
                <a class="btn btn-primary mb-2" style="background-color: #6610f2" href="/SOF3011_IT17311_thanhldph22749_war_exploded/sanpham/create" role="button"> Thêm mới</a>
            </div>
            <div class="col-9">
                <h4 style="margin-left: 65px; color: red" class="  mb-3" >Thông tin sản phẩm</h4>
            </div>

        </div>
        <c:if test="${ f:length(danhSachSPham) == 0 }">
            <h3 class="alert alert-warning">Không có dữ liệu</h3>
        </c:if>
        <c:if test="${ f:length(danhSachSPham) != 0 }">
            <table class="table table-hover" style="font-size: 13px">
                <thead>
                <tr>
                    <th scope="col">Mã</th>
                    <th scope="col">Tên</th>
                    <th scope="col">Sửa</th>
                    <th scope="col">Xóa</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${danhSachSPham}" var="sp">
                    <tr>
                        <td>${sp.ma}</td>
                        <td>${sp.ten}</td>
                        <td ><a href="/SOF3011_IT17311_thanhldph22749_war_exploded/sanpham/edit?ma=${sp.ma}" ><i style="color: red;" class="far fa-edit"></i></a></td>
                        <td ><a href="/SOF3011_IT17311_thanhldph22749_war_exploded/sanpham/delete?ma=${sp.ma}"><i style="color: red;" class="fas fa-trash-alt"></i></a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </c:if>
    </div>
</div>

