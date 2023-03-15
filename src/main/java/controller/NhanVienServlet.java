package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import view_model.NhanVienViewModel;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/nhanvien/index",
        "/nhanvien/create",
        "/nhanvien/edit",
        "/nhanvien/update",
        "/nhanvien/store",
        "/nhanvien/delete",
})
public class NhanVienServlet extends HttpServlet {
    ArrayList<NhanVienViewModel> listNV = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.create(req, resp);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/views/nhanvien/create.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.store(req, resp);
    }
    protected void store(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        String ma = request.getParameter("ma");
        String ho = request.getParameter("ho");
        String tenDem = request.getParameter("tenDem");
        String ten = request.getParameter("ten");
        String gioiTinh = request.getParameter("gioiTinh");
        String ngaySinh = request.getParameter("ngaySinh");
        String diaChi = request.getParameter("diaChi");
        String soDienThoai = request.getParameter("soDienThoai");
        String cuaHang = request.getParameter("cuaHang");
        String chucVu = request.getParameter("chucVu");
        String matKhau = request.getParameter("matKhau");
        int trangThai = Integer.parseInt(request.getParameter("trangThai"));
        NhanVienViewModel nvvm = new NhanVienViewModel(ma,ho,tenDem,ten,gioiTinh,ngaySinh,diaChi,soDienThoai,cuaHang,chucVu,matKhau,trangThai);
        listNV.add(nvvm);
    }
}
