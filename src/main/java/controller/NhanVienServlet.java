package controller;

import entity.ChucVu;
import entity.CuaHang;
import entity.NhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;
import repositories.ChucVuRepository;
import repositories.CuaHangRepository;
import repositories.NhanVienRepository;
import utils.Validate;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;


@WebServlet({
        "/nhanvien/index",
        "/nhanvien/create",
        "/nhanvien/edit",
        "/nhanvien/update",
        "/nhanvien/store",
        "/nhanvien/delete",
})
public class NhanVienServlet extends HttpServlet {
    private final NhanVienRepository nhanVienRepository = new NhanVienRepository();
    private final CuaHangRepository cuaHangRepository = new CuaHangRepository();
    private final ChucVuRepository chucVuRepository = new ChucVuRepository();

    private String error;
    private String errorMa;
    private String errorTen;
    private String errorHo;
    private String errorTenDem;
    private String errorNgaySinh;
    private String errorDiaChi;
    private String errorMatKhau;
    private String errorSDT;
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
        request.setAttribute("trungMa", error);
        request.setAttribute("checkMa", errorMa);
        request.setAttribute("checkTen", errorTen);
        request.setAttribute("checkHo", errorHo);
        request.setAttribute("checkTenDem", errorTenDem);
        request.setAttribute("checkNgaySinh", errorNgaySinh);
        request.setAttribute("checkMatKhau", errorMatKhau);
        request.setAttribute("checkDiaChi", errorDiaChi);
        request.setAttribute("checkSDT", errorSDT);
        request.setAttribute("danhSachCH",this.cuaHangRepository.findAll());
        request.setAttribute("danhSachCV",this.chucVuRepository.findAll());
        request.setAttribute("view","/views/nhanvien/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("trungMa", error);
        request.setAttribute("danhSachNV", this.nhanVienRepository.findAll());
        request.setAttribute("view", "/views/nhanvien/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSachCH",this.cuaHangRepository.findAll());
        request.setAttribute("danhSachCV",this.chucVuRepository.findAll());
        String ma = request.getParameter("ma");
        NhanVien nv = this.nhanVienRepository.findByMa(ma);
        request.setAttribute("checkTen", errorTen);
        request.setAttribute("checkHo", errorHo);
        request.setAttribute("checkTenDem", errorTenDem);
        request.setAttribute("checkNgaySinh", errorNgaySinh);
        request.setAttribute("checkMatKhau", errorMatKhau);
        request.setAttribute("checkDiaChi", errorDiaChi);
        request.setAttribute("checkSDT", errorSDT);
        request.setAttribute("nv", nv);
        request.setAttribute("view", "/views/nhanvien/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien nv = this.nhanVienRepository.findByMa(ma);
        this.nhanVienRepository.delete(nv);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/nhanvien/index");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("store")) {
            this.store(req, resp);
        } else if (uri.contains("update")) {
            this.update(req, resp);
        } else {
            resp.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/nhanvien/index");
        }
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NhanVien nv = new NhanVien();
        try {
//
//            DateTimeConverter converter = new DateConverter(new Date());
//            converter.setPattern("MM/dd/yyyy");
//            ConvertUtils.register(converter,Date.class);
            BeanUtils.populate(nv, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String maCV  = request.getParameter("idCV");
        String maCH  = request.getParameter("idCH");
        UUID idCV  = UUID.fromString(maCV);
        UUID idCH = UUID.fromString(maCH);
        ChucVu chucVu = this.chucVuRepository.findById(idCV);
        CuaHang cuaHang = this.cuaHangRepository.findById(idCH);
        nv.setChucVu(chucVu);
        nv.setCuaHang(cuaHang);
        errorTen = Validate.checkValues(nv.getTen(), "Tên");
        errorMa = Validate.checkValues(nv.getMa(), "Mã");
        errorTenDem = Validate.checkValues(nv.getTenDem(), "Tên đệm");
        errorNgaySinh = Validate.checkValues(nv.getNgaySinh(), "Ngày sinh");
        errorDiaChi = Validate.checkValues(nv.getDiaChi(), "Địa chỉ");
        errorHo = Validate.checkValues(nv.getHo(), "Họ");
        errorMatKhau = Validate.checkValues(nv.getMatKhau(), "Mật khẩu");
        errorSDT = Validate.checkValues(nv.getSoDienThoai(), "Số điện thoại");
        NhanVien check = nhanVienRepository.findByMa(nv.getMa());
        if (check != null) {
            error = "Mã đã tồn tại!";
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/nhanvien/create");
            return;
        } else {
            error = "";
        }
        if (!errorTen.isEmpty() || !errorMa.isEmpty()|| !errorHo.isEmpty()|| !errorTenDem.isEmpty()|| !errorDiaChi.isEmpty()|| !errorNgaySinh.isEmpty()|| !errorSDT.isEmpty()|| !errorMatKhau.isEmpty()) {
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/nhanvien/create");
            return;
        }
        this.nhanVienRepository.insert(nv);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/nhanvien/index");

    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien nv = this.nhanVienRepository.findByMa(ma);
        try {

//            DateTimeConverter converter = new DateConverter(new Date());
//            converter.setPattern("MM/dd/yyyy");
//            ConvertUtils.register(converter,Date.class);
            BeanUtils.populate(nv, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String maCV  = request.getParameter("idCV");
        String maCH  = request.getParameter("idCH");
        UUID idCV  = UUID.fromString(maCV);
        UUID idCH = UUID.fromString(maCH);
        ChucVu chucVu = this.chucVuRepository.findById(idCV);
        CuaHang cuaHang = this.cuaHangRepository.findById(idCH);
        nv.setChucVu(chucVu);
        nv.setCuaHang(cuaHang);
        errorTen = Validate.checkValues(nv.getTen(), "Tên");
        errorTenDem = Validate.checkValues(nv.getTenDem(), "Tên đệm");
        errorNgaySinh = Validate.checkValues(nv.getNgaySinh(), "Ngày sinh");
        errorDiaChi = Validate.checkValues(nv.getDiaChi(), "Địa chỉ");
        errorHo = Validate.checkValues(nv.getHo(), "Họ");
        errorMatKhau = Validate.checkValues(nv.getMatKhau(), "Mật khẩu");
        errorSDT = Validate.checkValues(nv.getSoDienThoai(), "Số điện thoại");
        if (!errorTen.isEmpty() ||!errorHo.isEmpty()|| !errorTenDem.isEmpty()|| !errorDiaChi.isEmpty()|| !errorNgaySinh.isEmpty()|| !errorSDT.isEmpty()|| !errorMatKhau.isEmpty()) {
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/nhanvien/edit?ma="+nv.getMa());
            return;
        }
        nhanVienRepository.update(nv);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/nhanvien/index");
    }
}
