package controller;

import entity.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.*;
import utils.Validate;

import java.io.IOException;
import java.util.UUID;

@WebServlet({
        "/sanphamct/index",
        "/sanphamct/create",
        "/sanphamct/edit",
        "/sanphamct/update",
        "/sanphamct/store",
        "/sanphamct/delete",

})
public class SanPhamCTServlet extends HttpServlet {
    private final SanPhamCTRepository sanPhamCTRepository = new SanPhamCTRepository();
    private final MauSacRepository mauSacRepository = new MauSacRepository();
    private final SanPhamRepository sanPhamRepository = new SanPhamRepository();
    private final NSXRepository nsxRepository = new NSXRepository();
    private final DongSPRepository dongSPRepository = new DongSPRepository();

    private String errorNamBH;
    private String errorMoTa;
    private String errorSoLuongTon;
    private String errorGiaNhap;
    private String errorGiaBan;
    private String errorAnh;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("create")) {
            this.create(req, resp);
        } else if (uri.contains("edit")) {
            this.edit(req, resp);
        } else if (uri.contains("delete")) {
            this.delete(req, resp);
        } else {
            this.index(req, resp);
        }
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("checkNamBH", errorNamBH);
        request.setAttribute("checkMoTa", errorMoTa);
        request.setAttribute("checkSoLuongTon", errorSoLuongTon);
        request.setAttribute("checkGiaNhap", errorGiaNhap);
        request.setAttribute("checkGiaBan", errorGiaBan);
        request.setAttribute("checkAnh", errorAnh);

        request.setAttribute("view", "/views/sanphamct/create.jsp");
        request.setAttribute("danhSachMS", this.mauSacRepository.findAll());
        request.setAttribute("danhSachSP", this.sanPhamRepository.findAll());
        request.setAttribute("danhSachDSP", this.dongSPRepository.findAll());
        request.setAttribute("danhSachNSX", this.nsxRepository.findAll());
        request.setAttribute("danhSachMS", this.mauSacRepository.findAll());
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSachSPCT", this.sanPhamCTRepository.findAll());
        request.setAttribute("view", "/views/sanphamct/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SanPhamCT spct = this.sanPhamCTRepository.findById(id);
        this.sanPhamCTRepository.delete(spct);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/sanphamct/index");
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("checkNamBH", errorNamBH);
        request.setAttribute("checkMoTa", errorMoTa);
        request.setAttribute("checkSoLuongTon", errorSoLuongTon);
        request.setAttribute("checkGiaNhap", errorGiaNhap);
        request.setAttribute("checkGiaBan", errorGiaBan);
        request.setAttribute("checkAnh", errorAnh);

        request.setAttribute("danhSachMS", this.mauSacRepository.findAll());
        request.setAttribute("danhSachSP", this.sanPhamRepository.findAll());
        request.setAttribute("danhSachDSP", this.dongSPRepository.findAll());
        request.setAttribute("danhSachNSX", this.nsxRepository.findAll());
        String id = request.getParameter("id");
        SanPhamCT spct = this.sanPhamCTRepository.findById(id);
        request.setAttribute("spct", spct);
        request.setAttribute("view", "/views/sanphamct/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("store")) {
            this.store(req, resp);
        } else if (uri.contains("update")) {
            this.update(req, resp);
        } else {
            resp.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/sanphamct/index");
        }
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SanPhamCT spct = new SanPhamCT();
        try {
            BeanUtils.populate(spct, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String idMauSac = request.getParameter("idMauSac");
        String idSanPham = request.getParameter("idSanPham");
        String idNSX = request.getParameter("idNSX");
        String idDongSP = request.getParameter("idDongSP");
        UUID idMS = UUID.fromString(idMauSac);
        UUID idSP = UUID.fromString(idSanPham);
        UUID idNsx2 = UUID.fromString(idNSX);
        UUID idDongSP2 = UUID.fromString(idDongSP);
        MauSac ms = this.mauSacRepository.findById(idMS);
        SanPham sp = this.sanPhamRepository.findById(idSP);
        NSX nsx = this.nsxRepository.findById(idNsx2);
        DongSP dsp = this.dongSPRepository.findById(idDongSP2);
        spct.setMauSac(ms);
        spct.setSanPham(sp);
        spct.setnSX(nsx);
        spct.setDongSP(dsp);

        errorMoTa = Validate.checkValues(spct.getMoTa(),"Mô tả");
        errorNamBH = Validate.checkValues(spct.getNamBH(),"Năm bảo hành");
        errorSoLuongTon = Validate.checkValues(spct.getMoTa(),"Số lượng tồn");
        errorGiaNhap = Validate.checkValues(spct.getMoTa(),"Giá nhập");
        errorGiaBan = Validate.checkValues(spct.getMoTa(),"Giá bán");
        errorAnh = Validate.checkValues(spct.getAnh(),"Img");


        if (!errorNamBH.isEmpty()||!errorMoTa.isEmpty()||!errorSoLuongTon.isEmpty()||!errorGiaNhap.isEmpty()||!errorGiaBan.isEmpty()||!errorAnh.isEmpty()){
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/sanphamct/create");
            return;
        }
        this.sanPhamCTRepository.insert(spct);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/sanphamct/index");
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SanPhamCT spct = this.sanPhamCTRepository.findById(id);
        try {
            BeanUtils.populate(spct, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String idMauSac = request.getParameter("idMauSac");
        String idSanPham = request.getParameter("idSanPham");
        String idNSX = request.getParameter("idNSX");
        String idDongSP = request.getParameter("idDongSP");
        UUID idMS = UUID.fromString(idMauSac);
        UUID idSP = UUID.fromString(idSanPham);
        UUID idNsx2 = UUID.fromString(idNSX);
        UUID idDongSP2 = UUID.fromString(idDongSP);
        MauSac ms = this.mauSacRepository.findById(idMS);
        SanPham sp = this.sanPhamRepository.findById(idSP);
        NSX nsx = this.nsxRepository.findById(idNsx2);
        DongSP dsp = this.dongSPRepository.findById(idDongSP2);
        spct.setMauSac(ms);
        spct.setSanPham(sp);
        spct.setnSX(nsx);
        spct.setDongSP(dsp);
        errorNamBH = Validate.checkValues(spct.getNamBH(),"Năm bảo hành");
        errorMoTa = Validate.checkValues(spct.getMoTa(),"Mô tả");
        errorSoLuongTon = Validate.checkValues(spct.getMoTa(),"Số lượng tồn");
        errorGiaNhap = Validate.checkValues(spct.getMoTa(),"Giá nhập");
        errorGiaBan = Validate.checkValues(spct.getMoTa(),"Giá bán");
        errorAnh = Validate.checkValues(spct.getAnh(),"Img");


        if (!errorNamBH.isEmpty()||!errorMoTa.isEmpty()||!errorSoLuongTon.isEmpty()||!errorGiaNhap.isEmpty()||!errorGiaBan.isEmpty()||!errorAnh.isEmpty()){
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/sanphamct/create");
            return;
        }
        this.sanPhamCTRepository.update(spct);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/sanphamct/index");
    }
}
