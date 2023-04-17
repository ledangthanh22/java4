<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <c:forEach items="${danhSachSP}" var="sp">
<%--        <div class="col-md-3 mt-3">--%>
<%--            <div class="card">--%>
<%--                <a href=""><img class="card-img-top" src="/SOF3011_IT17311_thanhldph22749_war_exploded/img/${sp.anh} " height="250" alt="Title"></a>--%>
<%--                <div class="card-body">--%>
<%--                    <h4 class="card-title" ><a style="text-decoration: none;   color: rgb(25, 24, 24);font-weight: 600;font-size: 1rem;" href="/SOF3011_IT17311_thanhldph22749_war_exploded/detail?id=${sp.id}">${sp.sanPham.ten}</a></h4>--%>
<%--                    <span class="card-gia">${sp.giaBan}đ</span>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
        <div class="col-md-3 my-3">
            <div class="card w-100">
                <img class="card-img-top" src="/SOF3011_IT17311_thanhldph22749_war_exploded/img/${sp.anh}"
                     alt="Card image cap">
                <div class="card-body">
                    <h6 class="card-title">${sp.sanPham.ten}</h6>
                    <p class="price">${sp.giaBan  }đ</p>index
<%--                    <h6 class="category">Category: <%=p.getCategory() %></h6>--%>
                    <div class="mt-3 d-flex justify-content-between">
                        <a class="btn btn-dark" href="/SOF3011_IT17311_thanhldph22749_war_exploded/giohangchitiet/">Add to Cart</a> <a
                            class="btn btn-primary" href="">Buy Now</a>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
