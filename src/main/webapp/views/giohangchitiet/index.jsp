
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<div class="container">
    <h3 class="mt-5">Giỏ hàng</h3>
    <c:if test="${ f:length(danhSachGioHangCT) == 0}">
        <h3 class="text-center mt-5"><i  style="font-size: 30px; color: black" class="fas fa-cart-plus"></i> <br>
            Không có sản phẩm nào trong giỏ hàng</h3>
    </c:if>
    <c:if test="${f:length(danhSachGioHangCT)!= 0}">
        <table class="table table-hover" style="font-size: 13px">
            <thead>
            <tr >
                <th scope="col">STT</th>
                <th scope="col">Tên sản phẩm</th>
                <th scope="col">Số lượng</th>
                <th scope="col">Giá</th>
                <th scope="col">Giảm giá</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${danhSachGioHangCT}" var="ghct">
                <tr>
                    <th scope="col">1</th>
                    <td>${ghct.tenSanPham}</td>
                    <td><input type="number" value="${ghct.soLuong}"></td>
                    <td>${ghct.giaBan}</td>
                    <td>${ghct.giamGia}%</td>
                    <td><a href="/SOF3011_IT17311_thanhldph22749_war_exploded/giohangchitiet/delete?tenSanPham=${ghct.tenSanPham}"><i style="color: red;" class="fas fa-trash-alt"></i></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

</div>

