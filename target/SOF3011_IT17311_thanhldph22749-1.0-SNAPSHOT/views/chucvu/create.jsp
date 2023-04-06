<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 3/13/2023
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="col-10 offset-1">
        <form action="/SOF3011_IT17311_thanhldph22749_war_exploded/chucvu/store" method="post">
            <h4 class="text-center my-4 text-danger">Quản lý chức vụ</h4>
            <div class="col-md-12 ">
                <label class="form-label">Mã</label>
                <input type="text" name="ma" class="form-control" placeholder="Nhập mã...">
                <span style="color:red;font-size: 16px">${trungMa}</span>
                <span style="color:red;font-size: 16px">${checkMa}</span>
            </div>
            <div class="col-md-12 mt-3">
                <label class="form-label">Tên</label>
                <input type="text" name="ten" class="form-control" placeholder="Nhập tên...">
                <span style="color:red;font-size: 16px">${checkTen}</span>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <button class="btn btn-primary" style="background-color: #6610f2">Thêm mới</button>
                </div>
                <div class="col-6"></div>
            </div>
        </form>
    </div>
</div>

