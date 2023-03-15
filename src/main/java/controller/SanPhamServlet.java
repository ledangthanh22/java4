package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import view_model.SanPhamViewModel;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/sanpham/index",
        "/sanpham/create",
        "/sanpham/edit",
        "/sanpham/update",
        "/sanpham/store",
        "/sanpham/delete",

})
public class SanPhamServlet extends HttpServlet {
    ArrayList<SanPhamViewModel> listSP = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.create(req, resp);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/sanpham/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.store(req, resp);
    }
    protected void store(HttpServletRequest request, HttpServletResponse response)throws  ServletException, IOException{
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        SanPhamViewModel spvm =new SanPhamViewModel(ma,ten);
        listSP.add(spvm);
    }
}
