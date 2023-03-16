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
        String uri = req.getRequestURI();
        if (uri.contains("create")) {
            this.create(req,resp);
//        }else if(uri.contains("edit")){
//            this.edit(req,resp);
//        }else if(uri.contains("delete")){
//            this.delete(req,resp);
        }
        else {
            this.index(req,resp);
        }
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/views/nhanvien/create.jsp").forward(request,response);
    }
    protected void index(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        this.listNV.add(new NhanVienViewModel("PH2","Le","Dang","Thanh","Nam","22/06/2002","Thai Nguyen","03769958572","DYjf","Nhan vien","yfuk",0));
        request.setAttribute("danhSachNV",this.listNV);
        request.getRequestDispatcher("/views/nhanvien/index.jsp").forward(request,response);
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
