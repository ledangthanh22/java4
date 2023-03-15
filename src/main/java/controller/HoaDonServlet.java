package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet({
        "/hoadon/index",
        "/hoadon/create",
        "/hoadon/edit",
        "/hoadon/update",
        "/hoadon/store",
        "/hoadon/delete",

})
public class HoaDonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.create(req, resp);
    }
    protected void create(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        request.getRequestDispatcher("/views/hoadon/create.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.store(req, resp);
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
//        Sr
    }
}
