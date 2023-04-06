package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositories.SanPhamCTRepository;
import repositories.GioHangChiTietRepository;
import view_model.GioHangChiTietViewModel;

import java.io.IOException;

@WebServlet({
        "/giohangchitiet/index",
        "/giohangchitiet/delete",
        "/giohangchitiet/store",


})
public class GioHangChiTietServlet extends HttpServlet {
    GioHangChiTietRepository gioHangChiTietRepository = new GioHangChiTietRepository();
    SanPhamCTRepository chiTietSPRepository = new SanPhamCTRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("delete")){
            this.delete(req, resp);
        }else {
            this.index(req,resp);
        }

    }
    protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setAttribute("danhSachGioHangCT",this.gioHangChiTietRepository.findAll());
        req.setAttribute("view","/views/giohangchitiet/index.jsp");
        req.getRequestDispatcher("/views/layoutbh.jsp").forward(req,resp);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String tenSanPham = request.getParameter("tenSanPham");
        GioHangChiTietViewModel ghct = this.gioHangChiTietRepository.findByTen(tenSanPham);
        this.gioHangChiTietRepository.delete(ghct);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/giohangchitiet/index");
    }
        protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        String tenSanPham = request.getParameter("tenSanPham");
//        int soLuong = Integer.parseInt(request.getParameter("1"));
//        double donGia = Double.parseDouble(request.getParameter("giaBan"));
//        int giamGia = Integer.parseInt(request.getPbharameter("20"));
//        GioHangChiTietViewModel cvvm = new GioHangChiTietViewModel(tenSanPham,soLuong,donGia,giamGia);
//        this.gioHangChiTietRepository.insert(cvvm);
//        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/chucvu/index");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.store(req, resp);
    }
}
