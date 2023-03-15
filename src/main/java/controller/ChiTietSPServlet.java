package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import view_model.ChiTietSPViewModel;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/chitietsp/index",
        "/chitietsp/create",
        "/chitietsp/edit",
        "/chitietsp/update",
        "/chitietsp/store",
        "/chitietsp/delete",

})
public class ChiTietSPServlet extends HttpServlet {
    ArrayList<ChiTietSPViewModel> listCTSP = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.create(req, resp);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/chitietsp/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.store(req, resp);
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tenSanPham = request.getParameter("tenSanPham");
        String tenNSX = request.getParameter("tenNSX");
        String tenDongSP = request.getParameter("tenDongSP");
        String tenMauSac = request.getParameter("tenMauSac");
        int namBH = Integer.parseInt(request.getParameter("namBH"));
        int soLuongTon = Integer.parseInt(request.getParameter("soLuongTon"));
        double giaNhap = Double.parseDouble(request.getParameter("giaNhap"));
        double giaBan = Double.parseDouble(request.getParameter("giaBan"));
        String moTa = request.getParameter("moTa");

        ChiTietSPViewModel ctspvm = new ChiTietSPViewModel(tenSanPham,tenNSX,tenMauSac,tenDongSP,namBH,soLuongTon,giaNhap,giaBan,moTa);
        listCTSP.add(ctspvm);
    }
}
