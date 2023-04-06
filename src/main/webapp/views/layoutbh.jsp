
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>title</title>
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="/SOF3011_IT17311_thanhldph22749_war_exploded/css/style.css">
    <link rel="stylesheet" href="/SOF3011_IT17311_thanhldph22749_war_exploded/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
          integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous" />
</head>
<body>
<div class="container-fluid">
    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid">
            <a class="navbar-brand" href="#"><img src="/SOF3011_IT17311_thanhldph22749_war_exploded/img/logo.png.webp" alt="" style="width: 120px;"></a>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/SOF3011_IT17311_thanhldph22749_war_exploded/banhang/index"><i class="fas fa-home" style="font-size: 20px;"></i>Trang chủ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="">Giới thiệu</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#!/lien-he">Liên hệ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/SOF3011_IT17311_thanhldph22749_war_exploded/login">
                            Product Management</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                           aria-expanded="false">
                            Tài khoản
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">Đăng nhập</a></li>
                            <li><a class="dropdown-item" href="#">Quên mật khẩu</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="#">Đăng xuất</a></li>
                            <li><a class="dropdown-item" href="#">Đổi mật khẩu</a></li>
                            <li><a class="dropdown-item" href="#">Cập nhật hồ sơ</a></li>
                        </ul>
                    </li>
                </ul>
                <a style="text-decoration: none; margin-right: 20px" href="/SOF3011_IT17311_thanhldph22749_war_exploded/giohangchitiet/index"><i  style="font-size: 30px; color: #6610f2" class="fas fa-cart-plus"></i></a>
            </div>
        </div>
    </nav>
    <header>
        <div id="carouselExampleIndicators" class="carousel slide">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
                        aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                        aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                        aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="/SOF3011_IT17311_thanhldph22749_war_exploded/img/banner2.png" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="/SOF3011_IT17311_thanhldph22749_war_exploded/img/banner2.png" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="/SOF3011_IT17311_thanhldph22749_war_exploded/img/banner2.png" class="d-block w-100" alt="...">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </header>
    <main class="container">
            <jsp:include page="${view}"/>
    </main>

    <!-- End of .container -->
    <footer class="site-footer mt-5">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 col-md-3">
                    <h6><img src="/SOF3011_IT17311_thanhldph22749_war_exploded/img/logo.png.webp" alt="" width="150px"></h6>
                    <p class="text-justify">Điện thoại: 036.995.8572 <br>
                        Email: thanhldph22749@fpt.edu.vn <br>
                        Địa chỉ: Số 32 Ngõ 91, Cầu Diẽn, Quận Bắc Từ Liêm, TP. Hà Nội </p>
                </div>
                <div class="col-xs-6 col-md-2">
                    <h6>SẢN PHẨM<Map></Map></h6>
                    <ul class="footer-links">
                        <li><a href="">Game Nester</a></li>
                        <li><a href="">Game CSS Diner</a></li>
                        <li><a href="">Game CSS Selectors
                        </a></li>
                        <li><a href="">Game Froggy</a></li>
                        <li><a href="">Game Froggy Pro</a></li>
                        <li><a href="">Game Scoops</a></li>
                    </ul>
                </div>
                <div class="col-xs-6 col-md-2">
                    <h6>THỂ LOẠI</h6>
                    <ul class="footer-links">
                        <li><a href="">C</a></li>
                        <li><a href="">UI Design</a></li>
                        <li><a href="">PHP</a></li>
                        <li><a href="">Java</a></li>
                        <li><a href="">Android</a></li>
                        <li><a href="">Templates</a></li>
                    </ul>
                </div>

                <div class="col-xs-6 col-md-2">
                    <h6>CÔNG CỤ</h6>
                    <ul class="footer-links">
                        <li><a href="">Tạo CV xin việc</a></li>
                        <li><a href="">Rút gọn liên kết</a></li>
                        <li><a href="">Clip-path maker</a></li>
                        <li><a href="">Snippet generatory</a></li>
                        <li><a href="">Cảnh báo sờ tay lên mặt</a></li>
                    </ul>
                </div>
                <div class="col-xs-6 col-md-3">
                    <h6>CÔNG TY CỔ PHẦN CÔNG NGHỆ GIÁO DỤC </h6>
                    <ul class="footer-links">
                        <li><a href="">Mã số thuế: 0109922901</a></li>
                        <li><a href="">Ngày thành lập: 08/02/2023</a></li>
                        <li><a href="">Lĩnh vực: Công nghệ, giáo dục, lập trình.
                            F8 xây dựng và phát triển những sản phẩm mang lại giá trị cho cộng đồng.</a></li>
                    </ul>
                </div>
            </div>
            <hr>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-8 col-sm-6 col-xs-12">
                    <p class="copyright-text"> © Lê Đăng Thành. Cao đẳng FPT Polytechnic
                    </p>
                </div>

                <div class="col-md-4 col-sm-6 col-xs-12">
                    <ul class="social-icons " >
                        <li><a class="facebook" href="https://www.facebook.com/"><i style="margin-top: 11px" class="fab fa-facebook "></i></a></li>
                        <li><a class="twitter" href="#"><i style="margin-top: 11px" class="fab fa-twitter "></i></a></li>
                        <li><a class="dribbble" href="#"><i style="margin-top: 11px" class="fab fa-instagram "></i></a></li>
                        <li><a class="linkedin" href="#"><i style="margin-top: 11px" class="fab fa-youtube "></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>
</div>
<script src="/SOF3011_IT17311_thanhldph22749_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>

