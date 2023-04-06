
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="/SOF3011_IT17311_thanhldph22749_war_exploded/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
          integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous" />
</head>
<body>
<%--<div class="container-fluid">--%>
<%--<nav class="navbar navbar-expand-lg">--%>
<%--    <div class="container-fluid">--%>
<%--        <a class="navbar-brand" href="#"><img src="../img/logo.png.webp" alt="" style="width: 120px;"></a>--%>
<%--        <div class="collapse navbar-collapse" id="navbarSupportedContent">--%>
<%--            <ul class="navbar-nav me-auto mb-2 mb-lg-0">--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link active" aria-current="page" href="/SOF3011_IT17311_thanhldph22749_war_exploded/banhang/index"><i class="fas fa-home" style="font-size: 20px;"></i>Trang chủ</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" href="">Giới thiệu</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" href="#!/lien-he">Liên hệ</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" href="#!/dang-ky">Đăng ký</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item dropdown">--%>
<%--                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"--%>
<%--                       aria-expanded="false">--%>
<%--                        Tài khoản--%>
<%--                    </a>--%>
<%--                    <ul class="dropdown-menu">--%>
<%--                        <li><a class="dropdown-item" href="#">Đăng nhập</a></li>--%>
<%--                        <li><a class="dropdown-item" href="#">Quên mật khẩu</a></li>--%>
<%--                        <li>--%>
<%--                            <hr class="dropdown-divider">--%>
<%--                        </li>--%>
<%--                        <li><a class="dropdown-item" href="#">Đăng xuất</a></li>--%>
<%--                        <li><a class="dropdown-item" href="#">Đổi mật khẩu</a></li>--%>
<%--                        <li><a class="dropdown-item" href="#">Cập nhật hồ sơ</a></li>--%>
<%--                    </ul>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--            <a style="text-decoration: none; margin-right: 20px" href="/SOF3011_IT17311_thanhldph22749_war_exploded/giohangchitiet/index"><i  style="font-size: 30px; color: #6610f2" class="fas fa-cart-plus"></i></a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>

<div class="row container-fluid" style="height: 600px" >
    <div class="col-2" style="color: #fcfcfc;background-color: #100f0f;">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0" style="margin-left: 30px">
            <li class="nav-item mt-2" style="color: red; font-weight: bold"><a class="nav-link"  href="/SOF3011_IT17311_thanhldph22749_war_exploded/layoutbh"><i class="fas fa-home" style="font-size: 20px;"></i>Home</a></li>
            <li class="nav-item mt-3"><a class="nav-link " href="/SOF3011_IT17311_thanhldph22749_war_exploded/sanpham/index">Sản phẩm</a></li>
            <li class="nav-item"><a class="nav-link " href="/SOF3011_IT17311_thanhldph22749_war_exploded/mausac/index">Màu sắc</a></li>
            <li class="nav-item"><a class="nav-link " href="/SOF3011_IT17311_thanhldph22749_war_exploded/dongsp/index">Dòng sản phẩm</a></li>
            <li class="nav-item"><a class="nav-link " href="/SOF3011_IT17311_thanhldph22749_war_exploded/nsx/index">Nhà sản xuất</a></li>
            <li class="nav-item"><a class="nav-link " href="/SOF3011_IT17311_thanhldph22749_war_exploded/nhanvien/index">Nhân viên</a></li>
            <li class="nav-item"><a class="nav-link " href="/SOF3011_IT17311_thanhldph22749_war_exploded/cuahang/index">Cửa hàng</a></li>
            <li class="nav-item"><a class="nav-link " href="/SOF3011_IT17311_thanhldph22749_war_exploded/khachhang/index">Khách hàng</a></li>
            <li class="nav-item"><a class="nav-link " href="/SOF3011_IT17311_thanhldph22749_war_exploded/chucvu/index">Chức vụ</a></li>
            <li class="nav-item"><a class="nav-link " href="/SOF3011_IT17311_thanhldph22749_war_exploded/sanphamct/index">Chi tiết sản phẩm</a></li>
        </ul>
    </div>
    <div class="col-10">
        <div class="row">
            <jsp:include page="${view}"/>
        </div>

    </div>
</div>
<!-- End of .container -->
<%--<footer class="site-footer">--%>
<%--    <div class="container">--%>
<%--        <div class="row">--%>
<%--            <div class="col-sm-12 col-md-3">--%>
<%--                <h6><img src="../img/logo-2023.png" alt="" width="150px"></h6>--%>
<%--                <p class="text-justify">Điện thoại: 036.995.8572 <br>--%>
<%--                    Email: thanhldph22749@fpt.edu.vn <br>--%>
<%--                    Địa chỉ: Số 32 Ngõ 91, Cầu Diẽn, Quận Bắc Từ Liêm, TP. Hà Nội </p>--%>
<%--            </div>--%>
<%--            <div class="col-xs-6 col-md-2">--%>
<%--                <h6>SẢN PHẨM<Map></Map></h6>--%>
<%--                <ul class="footer-links">--%>
<%--                    <li><a href="">Game Nester</a></li>--%>
<%--                    <li><a href="">Game CSS Diner</a></li>--%>
<%--                    <li><a href="">Game CSS Selectors--%>
<%--                    </a></li>--%>
<%--                    <li><a href="">Game Froggy</a></li>--%>
<%--                    <li><a href="">Game Froggy Pro</a></li>--%>
<%--                    <li><a href="">Game Scoops</a></li>--%>
<%--                </ul>--%>
<%--            </div>--%>
<%--            <div class="col-xs-6 col-md-2">--%>
<%--                <h6>THỂ LOẠI</h6>--%>
<%--                <ul class="footer-links">--%>
<%--                    <li><a href="">C</a></li>--%>
<%--                    <li><a href="">UI Design</a></li>--%>
<%--                    <li><a href="">PHP</a></li>--%>
<%--                    <li><a href="">Java</a></li>--%>
<%--                    <li><a href="">Android</a></li>--%>
<%--                    <li><a href="">Templates</a></li>--%>
<%--                </ul>--%>
<%--            </div>--%>

<%--            <div class="col-xs-6 col-md-2">--%>
<%--                <h6>CÔNG CỤ</h6>--%>
<%--                <ul class="footer-links">--%>
<%--                    <li><a href="">Tạo CV xin việc</a></li>--%>
<%--                    <li><a href="">Rút gọn liên kết</a></li>--%>
<%--                    <li><a href="">Clip-path maker</a></li>--%>
<%--                    <li><a href="">Snippet generatory</a></li>--%>
<%--                    <li><a href="">Cảnh báo sờ tay lên mặt</a></li>--%>
<%--                </ul>--%>
<%--            </div>--%>
<%--            <div class="col-xs-6 col-md-3">--%>
<%--                <h6>CÔNG TY CỔ PHẦN CÔNG NGHỆ GIÁO DỤC </h6>--%>
<%--                <ul class="footer-links">--%>
<%--                    <li><a href="">Mã số thuế: 0109922901</a></li>--%>
<%--                    <li><a href="">Ngày thành lập: 08/02/2023</a></li>--%>
<%--                    <li><a href="">Lĩnh vực: Công nghệ, giáo dục, lập trình.--%>
<%--                        F8 xây dựng và phát triển những sản phẩm mang lại giá trị cho cộng đồng.</a></li>--%>
<%--                </ul>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <hr>--%>
<%--    </div>--%>
<%--    <div class="container">--%>
<%--        <div class="row">--%>
<%--            <div class="col-md-8 col-sm-6 col-xs-12">--%>
<%--                <p class="copyright-text"> © Lê Đăng Thành. Cao đẳng FPT Polytechnic--%>
<%--                </p>--%>
<%--            </div>--%>

<%--            <div class="col-md-4 col-sm-6 col-xs-12">--%>
<%--                <ul class="social-icons " >--%>
<%--                    <li><a class="facebook" href="https://www.facebook.com/"><i style="margin-top: 11px" class="fab fa-facebook "></i></a></li>--%>
<%--                    <li><a class="twitter" href="#"><i style="margin-top: 11px" class="fab fa-twitter "></i></a></li>--%>
<%--                    <li><a class="dribbble" href="#"><i style="margin-top: 11px" class="fab fa-instagram "></i></a></li>--%>
<%--                    <li><a class="linkedin" href="#"><i style="margin-top: 11px" class="fab fa-youtube "></i></a></li>--%>
<%--                </ul>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</footer>--%>
<%--</div>--%>
<script src="/SOF3011_IT17311_thanhldph22749_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>

