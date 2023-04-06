
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<div class="container">
        <form action="/SOF3011_IT17311_thanhldph22749_war_exploded/sanphamct/store" method="post">
            <h3 class="text-center my-4 text-danger">Quản lý chi tiết sản phẩm</h3>
            <div class="row mt-3">
                <div class="col-md-6">
                    <label class="form-label">Sản phẩm</label>
                    <select class="form-select" name="idSanPham">
                        <c:forEach items="${danhSachSP}" var="sp">
                            <option value="${sp.id}">${sp.ten}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-6">
                    <label class="form-label">NSX</label>
                    <select class="form-select" name="idNSX">
                        <c:forEach items="${danhSachNSX}" var="nsx">
                            <option value="${nsx.id}">${nsx.ten}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-md-6">
                    <label class="form-label">Màu sắc</label>
                    <select class="form-select" name="idMauSac">
                        <c:forEach items="${danhSachMS}" var="ms">
                            <option value="${ms.id}">${ms.ten}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Dòng sản phẩm</label>
                    <select class="form-select" name="idDongSP">
                        <c:forEach items="${danhSachDSP}" var="dsp">
                            <option value="${dsp.id}">${dsp.ten}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-md-6 ">
                    <label class="form-label">Năm bảo hành</label>
                    <input type="text" name="namBH" class="form-control" placeholder="Nhập năm bảo hành...">
                    <span style="color:red;font-size: 16px">${checkNamBH}</span>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Số lượng tồn</label>
                    <input type="text" name="soLuongTon" class="form-control" placeholder="Nhập số lượng...">
                    <span style="color:red;font-size: 16px">${checkSoLuongTon}</span>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-md-6 ">
                    <label class="form-label">Giá nhập</label>
                    <input type="text" name="giaNhap" class="form-control" placeholder="Nhập giá nhập...">
                    <span style="color:red;font-size: 16px">${checkGiaNhap}</span>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Giá bán</label>
                    <input type="text" name="giaBan" class="form-control" placeholder="Nhập bán...">
                    <span style="color:red;font-size: 16px">${checkGiaBan}</span>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-md-6">
                    <label class="form-label">Ảnh</label>
                    <input type="text" name="anh" class="form-control" placeholder="Nhập img...">
                    <span style="color:red;font-size: 16px">${checkAnh}</span>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Mô tả</label>
                    <textarea name="moTa" class="form-control" placeholder="Nhập mô tả..."></textarea>
                    <span style="color:red;font-size: 16px">${checkMoTa}</span>
                </div>
            </div>

            <div class="row mt-3">
                <div class="col-6">
                    <button class="btn btn-primary" style="background-color: #6610f2">Thêm mới</button>
                </div>
                <div class="col-6"></div>
            </div>
        </form>
</div>

