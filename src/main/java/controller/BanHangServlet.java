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
@WebServlet("/layoutbh")
public class BanHangServlet extends HttpServlet {
    SanPhamCTRepository chiTietSPRepository = new SanPhamCTRepository();
//    GioHangChiTietRepository gioHangChiTietRepository = new GioHangChiTietRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String uri = req.getRequestURI();
//        if(uri.contains("product")){
            this.product(req, resp);
//        }else if(uri.contains("productct")){
//            this.productct(req,resp);
////        }

    }
   protected void product(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSachSP",this.chiTietSPRepository.findAll());
        request.setAttribute("view","/views/banhang/product.jsp");
        request.getRequestDispatcher("/views/layoutbh.jsp").forward(request,response);
   }
//    protected void productct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("danhSachSP",this.chiTietSPRepository.findAll());
//        request.setAttribute("view","/views/banhang/sanphamct.jsp");
//        request.getRequestDispatcher("/views/layoutbh.jsp").forward(request,response);
//    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        this.store(req, resp);
    }
}
