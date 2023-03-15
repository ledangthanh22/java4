package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import view_model.CuaHangViewModel;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/cuahang/index",
        "/cuahang/create",
        "/cuahang/edit",
        "/cuahang/update",
        "/cuahang/store",
        "/cuahang/delete",

})
public class CuaHangServlet extends HttpServlet {
    ArrayList<CuaHangViewModel> listCH = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.create(req, resp);
    }
    protected  void create(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        request.getRequestDispatcher("/views/cuahang/create.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.store(req, resp);
    }
    protected void store(HttpServletRequest request , HttpServletResponse response)throws ServletException, IOException{
       String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        CuaHangViewModel chvm = new CuaHangViewModel(ma,ten, diaChi, thanhPho, quocGia);
        listCH.add(chvm);
    }
}
