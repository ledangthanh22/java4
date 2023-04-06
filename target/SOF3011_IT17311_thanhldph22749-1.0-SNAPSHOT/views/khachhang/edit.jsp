
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
        <form action="/SOF3011_IT17311_thanhldph22749_war_exploded/khachhang/update?ma=${kh.ma}" method="post" >
            <h4 class="my-3 text-danger text-center">Cập nhật khách hàng</h4>
            <div class="row mt-3">
                <div class="col-md-6">
                    <label class="form-label">Mã</label>
                    <input type="text" class="form-control" name="ma" placeholder="Nhập mã..." value="${kh.ma}" disabled>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Họ</label>
                    <input type="text" class="form-control" name="ho" placeholder="Nhập họ..." value="${kh.ho}">
                    <span style="color:red;font-size: 16px">${checkHo}</span>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-md-6">
                    <label class="form-label">Tên đệm</label>
                    <input type="text" class="form-control" name="tenDem" placeholder="Nhập tên đệm..." value="${kh.tenDem}">
                    <span style="color:red;font-size: 16px">${checkTenDem}</span>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Tên</label>
                    <input type="text" class="form-control" name="ten" placeholder="Nhập tên..." value="${kh.ten}">
                    <span style="color:red;font-size: 16px">${checkTen}</span>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-md-6">
                    <label class="form-label">Ngày sinh</label>
                    <input type="date" class="form-control" name="ngaySinh" placeholder="Nhập ngày sinh..." value="${kh.ngaySinh}">
                    <span style="color:red;font-size: 16px">${checkNgaySinh}</span>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Số điện thoại </label>
                    <input type="text" class="form-control" name="soDienThoai" placeholder="Nhập sdt..." value="${kh.soDienThoai}">
                    <span style="color:red;font-size: 16px">${checkSDT}</span>
                </div>
            </div>

            <div class="row mt-3">
                <div class="col-md-6">
                    <label class="form-label">Địa chỉ</label>
                    <input type="text" class="form-control" name="diaChi" placeholder="Nhập địa chỉ..." value="${kh.diaChi}">
                    <span style="color:red;font-size: 16px">${checkDiaChi}</span>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Mật khẩu</label>
                    <input type="password" class="form-control" name="matKhau" placeholder="Nhập mật khẩu..." value="${kh.matKhau}">
                    <span style="color:red;font-size: 16px">${checkMatKhau}</span>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-md-6">
                    <label class="form-label">Quốc gia</label>
                    <select name="quocGia" class="form-select">
                        <option value="Việt Nam" ${ kh.quocGia == "Việt Nam" ? "selected" : "" }>Việt Nam</option>
                        <option value="Mỹ" ${ kh.quocGia == "Mỹ" ? "selected" : "" }>Mỹ</option>
                    </select>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Thành phố</label>
                    <select name="thanhPho" class="form-select">
                        <option value="Thái Nguyên"  ${ kh.thanhPho == "Thái Nguyên" ? "selected" : "" }>Thái Nguyên</option>
                        <option value="Bắc Ninh"  ${ kh.thanhPho == "Bắc Ninh" ? "selected" : "" }>Bắc Ninh</option>
                    </select>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <button class="btn btn-primary" style="background-color: #6610f2">Cập nhật</button>
                </div>
                <div class="col-6"></div>
            </div>
        </form>
    </div>
</div>

