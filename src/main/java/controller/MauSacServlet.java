package controller;

import entity.ChucVu;
import entity.MauSac;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.MauSacRepository;
import utils.Validate;
import view_model.MauSacViewModel;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/mausac/index",
        "/mausac/create",
        "/mausac/edit",
        "/mausac/update",
        "/mausac/store",
        "/mausac/delete",

})
public class MauSacServlet extends HttpServlet {
    MauSacRepository mauSacRepository = new MauSacRepository();
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
        request.setAttribute("view", "/views/mausac/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("trungMa", error);
        request.setAttribute("danhSachMS", this.mauSacRepository.findAll());
        request.setAttribute("view", "/views/mausac/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSac ms = this.mauSacRepository.findByMa(ma);
        this.mauSacRepository.delete(ms);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/mausac/index");
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSac ms = this.mauSacRepository.findByMa(ma);
        request.setAttribute("checkTen", errorTen);
        request.setAttribute("ms", ms);
        request.setAttribute("view", "/views/mausac/edit.jsp");
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
            resp.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/mausac/index");
        }
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MauSac ms = new MauSac();
        try {
            BeanUtils.populate(ms, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        errorTen = Validate.checkValues(ms.getTen(), "Tên");
        errorMa = Validate.checkValues(ms.getMa(), "Mã");
        MauSac check = mauSacRepository.findByMa(ms.getMa());
        if (check != null) {
            error = "Mã đã tồn tại!";
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/mausac/create");
            return;
        } else {
            error = "";
        }
        if (!errorTen.isEmpty() || !errorMa.isEmpty()) {
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/mausac/create");
            return;
        }
        this.mauSacRepository.insert(ms);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/mausac/index");

    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSac ms = this.mauSacRepository.findByMa(ma);
        try {
            BeanUtils.populate(ms, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        errorTen = Validate.checkValues(ms.getTen(), "Tên");
        if (!errorTen.isEmpty()) {
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/mausac/edit?ma=" + ms.getMa());
            return;
        }
        this.mauSacRepository.update(ms);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/mausac/index");

    }
}
