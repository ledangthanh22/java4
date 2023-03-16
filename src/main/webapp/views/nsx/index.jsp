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
<html>
<head>
    <title>NSX</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="col-6 offset-3">
        <h3 class="text-center my-3 text-danger">Thông tin nhà sản xuất</h3>
        <c:if test="${ f:length(danhSachNSX) == 0 }">
            <h3 class="alert alert-warning">Không có dữ liệu</h3>
        </c:if>
        <c:if test="${ f:length(danhSachNSX) != 0 }">
            <table class="table table-hover" style="font-size: 13px">
                <thead>
                <tr>
                    <th scope="col">Mã</th>
                    <th scope="col">Tên</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${danhSachNSX}" var="nsx">
                    <tr>
                        <th>${nsx.ma}</th>
                        <th>${nsx.ten}</th>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </c:if>
    </div>
</div>
<style>

</style>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
