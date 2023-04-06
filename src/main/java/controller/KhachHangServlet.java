package controller;

import entity.KhachHang;
import entity.NhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.KhachHangRepository;
import utils.Validate;

import java.io.IOException;

@WebServlet({
        "/khachhang/index",    // GET
        "/khachhang/create",   // GET
        "/khachhang/edit",     // GET
        "/khachhang/delete",   // GET
        "/khachhang/store",    // POST
        "/khachhang/update",   // POST
})
public class KhachHangServlet extends HttpServlet {
    private KhachHangRepository khachHangRepository = new KhachHangRepository();

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
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
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

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("trungMa", error);
        request.setAttribute("checkMa", errorMa);
        request.setAttribute("checkTen", errorTen);
        request.setAttribute("checkHo", errorHo);
        request.setAttribute("checkTenDem", errorTenDem);
        request.setAttribute("checkNgaySinh", errorNgaySinh);
        request.setAttribute("checkMatKhau", errorMatKhau);
        request.setAttribute("checkDiaChi", errorDiaChi);
        request.setAttribute("checkSDT", errorSDT);
        request.setAttribute("view", "/views/khachhang/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);

    }

    protected void index(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("trungMa", error);
        request.setAttribute("danhSachKH", this.khachHangRepository.findAll());
        request.setAttribute("view", "/views/khachhang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void edit(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        KhachHang kh = this.khachHangRepository.findByMa(ma);
        request.setAttribute("checkTen", errorTen);
        request.setAttribute("checkHo", errorHo);
        request.setAttribute("checkTenDem", errorTenDem);
        request.setAttribute("checkNgaySinh", errorNgaySinh);
        request.setAttribute("checkMatKhau", errorMatKhau);
        request.setAttribute("checkDiaChi", errorDiaChi);
        request.setAttribute("checkSDT", errorSDT);
        request.setAttribute("kh", kh);
        request.setAttribute("view", "/views/khachhang/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void delete(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        KhachHang kh = this.khachHangRepository.findByMa(ma);
        this.khachHangRepository.delete(kh);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/khachhang/index");
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/khachhang/index");

        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        KhachHang kh = new KhachHang();
        try {
            BeanUtils.populate(kh, request.getParameterMap());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        errorTen = Validate.checkValues(kh.getTen(), "Tên");
        errorMa = Validate.checkValues(kh.getMa(), "Mã");
        errorTenDem = Validate.checkValues(kh.getTenDem(), "Tên đệm");
        errorNgaySinh = Validate.checkValues(kh.getNgaySinh(), "Ngày sinh");
        errorDiaChi = Validate.checkValues(kh.getDiaChi(), "Địa chỉ");
        errorHo = Validate.checkValues(kh.getHo(), "Họ");
        errorMatKhau = Validate.checkValues(kh.getMatKhau(), "Mật khẩu");
        errorSDT = Validate.checkValues(kh.getSoDienThoai(), "Số điện thoại");
        KhachHang check = khachHangRepository.findByMa(kh.getMa());
        if (check != null) {
            error = "Mã đã tồn tại!";
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/khachhang/create");
            return;
        } else {
            error = "";
        }
        if (!errorTen.isEmpty() || !errorMa.isEmpty() || !errorHo.isEmpty() || !errorTenDem.isEmpty() || !errorDiaChi.isEmpty() || !errorNgaySinh.isEmpty() || !errorSDT.isEmpty() || !errorMatKhau.isEmpty()) {
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/khachhang/create");
            return;
        }
        this.khachHangRepository.insert(kh);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/khachhang/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        KhachHang kh = this.khachHangRepository.findByMa(ma);
        try {

            BeanUtils.populate(kh, request.getParameterMap());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        errorTen = Validate.checkValues(kh.getTen(), "Tên");
        errorTenDem = Validate.checkValues(kh.getTenDem(), "Tên đệm");
        errorNgaySinh = Validate.checkValues(kh.getNgaySinh(), "Ngày sinh");
        errorDiaChi = Validate.checkValues(kh.getDiaChi(), "Địa chỉ");
        errorHo = Validate.checkValues(kh.getHo(), "Họ");
        errorMatKhau = Validate.checkValues(kh.getMatKhau(), "Mật khẩu");
        errorSDT = Validate.checkValues(kh.getSoDienThoai(), "Số điện thoại");
        if (!errorTen.isEmpty() || !errorHo.isEmpty() || !errorTenDem.isEmpty() || !errorDiaChi.isEmpty() || !errorNgaySinh.isEmpty() || !errorSDT.isEmpty() || !errorMatKhau.isEmpty()) {
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/khachhang/edit?ma=" + kh.getMa());
            return;
        }
        this.khachHangRepository.update(kh);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/khachhang/index");
    }
}
