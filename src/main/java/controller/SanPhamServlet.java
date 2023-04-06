package controller;

import entity.ChucVu;
import entity.SanPham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.SanPhamRepository;
import utils.Validate;
import view_model.SanPhamViewModel;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/sanpham/index",
        "/sanpham/create",
        "/sanpham/edit",
        "/sanpham/update",
        "/sanpham/store",
        "/sanpham/delete",
})
public class SanPhamServlet extends HttpServlet {
    SanPhamRepository sanPhamRepository = new SanPhamRepository();
    private String error;
    private String errorMa;
    private String errorTen;

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
        request.setAttribute("checkTen", errorTen);
        request.setAttribute("checkMa", errorMa);
        request.setAttribute("view", "/views/sanpham/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("trungMa", error);
        request.setAttribute("danhSachSPham", this.sanPhamRepository.findAll());
        request.setAttribute("view", "/views/sanpham/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham sp = this.sanPhamRepository.findByMa(ma);
        this.sanPhamRepository.delete(sp);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/sanpham/index");
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham sp = this.sanPhamRepository.findByMa(ma);
        request.setAttribute("checkTen", errorTen);
        request.setAttribute("sp", sp);
        request.setAttribute("view", "/views/sanpham/edit.jsp");
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
            resp.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/sanpham/index");
        }

    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SanPham sp = new SanPham();
        try {
            BeanUtils.populate(sp, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        errorTen = Validate.checkValues(sp.getTen(), "Tên");
        errorMa = Validate.checkValues(sp.getMa(), "Mã");
        SanPham check = sanPhamRepository.findByMa(sp.getMa());
        if (check != null) {
            error = "Mã đã tồn tại!";
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/sanpham/create");
            return;
        } else {
            error = "";
        }
        if (!errorTen.isEmpty() || !errorMa.isEmpty()) {
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/sanpham/create");
            return;
        }
        this.sanPhamRepository.insert(sp);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/sanpham/index");

    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham sp = this.sanPhamRepository.findByMa(ma);
        try {
            BeanUtils.populate(sp, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        errorTen = Validate.checkValues(sp.getTen(), "Tên");
        if (!errorTen.isEmpty()) {
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/sanpham/edit?ma=" + sp.getMa());
            return;
        }
        this.sanPhamRepository.update(sp);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/sanpham/index");
    }
}
