
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<div class="container">
    <div class="col-10 offset-1">
        <div class="row  mt-4 ">
            <div class="col-3">
                <a class="btn btn-primary mb-2" style="background-color: #6610f2" href="/SOF3011_IT17311_thanhldph22749_war_exploded/dongsp/create" role="button"> Thêm mới</a>
            </div>
            <div class="col-9">
                <h4 style="margin-left: 65px; color: red" class="  mb-3" >Thông tin dòng sản phẩm</h4>
            </div>

        </div>
        <c:if test="${ f:length(danhSachDSP) == 0 }">
            <h3 class="alert alert-warning">Không có dữ liệu</h3>
        </c:if>
        <c:if test="${ f:length(danhSachDSP) != 0 }">
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
                <c:forEach items="${danhSachDSP}" var="dsp">
                    <tr>
                        <td>${dsp.ma}</td>
                        <td>${dsp.ten}</td>
                        <td ><a href="/SOF3011_IT17311_thanhldph22749_war_exploded/dongsp/edit?ma=${dsp.ma}" ><i style="color: red;" class="far fa-edit"></i></a></td>
                        <td ><a href="/SOF3011_IT17311_thanhldph22749_war_exploded/dongsp/delete?ma=${dsp.ma}"><i style="color: red;" class="fas fa-trash-alt"></i></a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </c:if>
    </div>
</div>

