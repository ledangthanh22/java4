package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import view_model.KhachHangViewModel;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/khachhang/index",    // GET
        "/khachhang/create",   // GET
        "/khachhang/edit",     // GET
        "/khachhang/delete",   // GET
        "/khachhang/store",    // POST
        "/khachhang/update",   // POST
})
public class KhachHangServlet extends HttpServlet {
    ArrayList<KhachHangViewModel> listKH = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("create")) {
            this.create(req, resp);
//        } else if (uri.contains("edit")) {
////            this.edit(req,resp);
//        } else if (uri.contains("delete")) {
////            this.delete(req,resp);
        }
        else {
            this.index(req, resp);
        }
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.getRequestDispatcher("/views/khachhang/create.jsp")
                .forward(request, response);

    }

    protected void index(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        this.listKH.add(new KhachHangViewModel("Ph32","Le","Dang","Thanh","22/06/2002","0369958572","Thai Nguyen","dusacb","VN","HN"));
        request.setAttribute("danhSachKH",this.listKH);
        request.getRequestDispatcher("/views/khachhang/index.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        this.store(request, response);
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ho = request.getParameter("ho");
        String tenDem = request.getParameter("ten");
        String ten = request.getParameter("ten");
        String ngaySinh = request.getParameter("ngaySinh");
        String soDienThoai = request.getParameter("soDienThoai");
        String matKhau = request.getParameter("matKhau");
        String diaChi = request.getParameter("diaChi");
        String quocGia = request.getParameter("quocGia");
        String thanhPho = request.getParameter("thanhPho");


        KhachHangViewModel khvm = new KhachHangViewModel(ma, ho, tenDem, ten, ngaySinh, soDienThoai, diaChi, matKhau, quocGia, thanhPho);
        listKH.add(khvm);
    }
}
