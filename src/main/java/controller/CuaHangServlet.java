package controller;

import entity.ChucVu;
import entity.CuaHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.CuaHangRepository;
import utils.Validate;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/cuahang/index",
        "/cuahang/create",
        "/cuahang/edit",
        "/cuahang/update",
        "/cuahang/store",
        "/cuahang/delete",

})
public class CuaHangServlet extends HttpServlet {
    CuaHangRepository cuaHangRepository = new CuaHangRepository();
    private String error;
    private String errorMa;
    private String errorTen;
    private String errorDiaChi;
    private String errorThanhPho;
    private String errorQuocGia;
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
        request.setAttribute("checkDiaChi", errorDiaChi);
        request.setAttribute("checkThanhPho", errorThanhPho);
        request.setAttribute("checkQuocGia", errorQuocGia);
        request.setAttribute("view", "/views/cuahang/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("trungMa", error);
        request.setAttribute("danhSachCH", this.cuaHangRepository.findAll());
        request.setAttribute("view", "/views/cuahang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        CuaHang ch = this.cuaHangRepository.findByMa(ma);
        this.cuaHangRepository.delete(ch);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/cuahang/index");
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        CuaHang ch = this.cuaHangRepository.findByMa(ma);
        request.setAttribute("checkTen", errorTen);
        request.setAttribute("trungDiaChi", errorDiaChi);
        request.setAttribute("checkThanhPho", errorThanhPho);
        request.setAttribute("checkQuocGia", errorQuocGia);
        request.setAttribute("ch", ch);
        request.setAttribute("view", "/views/cuahang/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("store")) {
            this.store(req, resp);
        } else if (uri.contains("update")) {
            this.update(req, resp);
        } else {
            resp.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/cuahang/index");

        }
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CuaHang ch = new CuaHang();
        try {
            BeanUtils.populate(ch, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        errorTen = Validate.checkValues(ch.getTen(), "Tên");
        errorMa = Validate.checkValues(ch.getMa(), "Mã");
        errorDiaChi = Validate.checkValues(ch.getDiaChi(), "Địa chỉ");
        errorThanhPho = Validate.checkValues(ch.getThanhPho(), "Thành phố");
        errorQuocGia = Validate.checkValues(ch.getQuocGia(), "Quốc gia");
        CuaHang check = cuaHangRepository.findByMa(ch.getMa());
        if (check != null) {
            error = "Mã đã tồn tại!";
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/cuahang/create");
            return;
        } else {
            error = "";
        }
        if (!errorTen.isEmpty() || !errorMa.isEmpty()|| !errorDiaChi.isEmpty()|| !errorQuocGia.isEmpty()|| !errorThanhPho.isEmpty()) {
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/cuahang/create");
            return;
        }
        this.cuaHangRepository.insert(ch);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/cuahang/index");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        CuaHang ch = this.cuaHangRepository.findByMa(ma);
        try {
            BeanUtils.populate(ch, request.getParameterMap());

        } catch (Exception e) {
            e.printStackTrace();
        }
        errorTen = Validate.checkValues(ch.getTen(), "Tên");
        errorDiaChi = Validate.checkValues(ch.getDiaChi(), "Địa chỉ");
        errorThanhPho = Validate.checkValues(ch.getThanhPho(), "Thành phố");
        errorQuocGia = Validate.checkValues(ch.getQuocGia(), "Quốc gia");
        if (!errorTen.isEmpty()||!errorDiaChi.isEmpty()||!errorThanhPho.isEmpty()||!errorQuocGia.isEmpty()) {
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/cuahang/edit?ma=" + ch.getMa());
            return;
        }
        this.cuaHangRepository.update(ch);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/cuahang/index");
    }
}
