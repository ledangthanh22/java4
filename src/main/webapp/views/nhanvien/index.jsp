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
<div class="row  mt-4 ">
    <div class="col-2">
        <a class="btn btn-primary mb-2" style="background-color: #6610f2" href="/SOF3011_IT17311_thanhldph22749_war_exploded/nhanvien/create" role="button"> Thêm mới</a>
    </div>
    <div class="col-9">
        <h4 style="margin-left: 170px; color: red" class="  mb-3" >Thông tin nhân viên</h4>
    </div>

</div>
    <c:if test="${ f:length(danhSachNV) == 0 }">
        <h3 class="alert alert-warning">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${ f:length(danhSachNV) != 0 }">
        <table class="table table-hover" style="font-size: 13px">
            <thead>
            <tr>
                <th scope="col">Mã</th>
                <th scope="col">Họ</th>
                <th scope="col">Tên đệm</th>
                <th scope="col">Tên</th>
                <th scope="col">Giới tính</th>
                <th scope="col">Ngày sinh</th>
                <th scope="col">Địa chỉ</th>
                <th scope="col">Số điện thoại</th>
                <th scope="col">Cửa hàng</th>
                <th scope="col">Chức vụ</th>
                <th scope="col">Mật khẩu</th>
                <th scope="col">Trạng thái</th>
                <th scope="col"></th>
                <th scope="col"></th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ danhSachNV }" var="nv">
                <tr>
                    <td>${nv.ma}</td>
                    <td>${nv.ho}</td>
                    <td>${nv.tenDem}</td>
                    <td>${nv.ten}</td>
                    <td>${nv.gioiTinh == true ?"Nam":"Nữ"}</td>
                    <td>${nv.ngaySinh}</td>
                    <td>${nv.diaChi}</td>
                    <td>${nv.soDienThoai}</td>
                    <td>${nv.cuaHang.ten}</td>
                    <td>${nv.chucVu.ten}</td>
                    <td>${nv.matKhau}</td>
                    <td>${nv.trangThai == 0? "Đã nghỉ":"Đang làm"}</td>
                    <td ><a href="/SOF3011_IT17311_thanhldph22749_war_exploded/nhanvien/edit?ma=${nv.ma}" ><i style="color: red;" class="far fa-edit"></i></a></td>
                    <td ><a href="/SOF3011_IT17311_thanhldph22749_war_exploded/nhanvien/delete?ma=${nv.ma}" ><i style="color: red;" class="fas fa-trash-alt"></i></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </c:if>
</div>



