package controller;

import entity.ChucVu;
import entity.NSX;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.NSXRepository;
import utils.Validate;
import view_model.NSXViewModel;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/nsx/index",
        "/nsx/create",
        "/nsx/edit",
        "/nsx/update",
        "/nsx/store",
        "/nsx/delete",

})
public class NSXServlet extends HttpServlet {
    NSXRepository nsxRepository = new NSXRepository();
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
        request.setAttribute("view", "/views/nsx/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("trungMa", error);
        request.setAttribute("danhSachNSX", this.nsxRepository.findAll());
        request.setAttribute("view", "/views/nsx/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NSX nsx = this.nsxRepository.findByMa(ma);
        this.nsxRepository.delete(nsx);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/nsx/index");
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NSX nsx = this.nsxRepository.findByMa(ma);
        request.setAttribute("checkTen", errorTen);
        request.setAttribute("nsx", nsx);
        request.setAttribute("view", "/views/nsx/edit.jsp");
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
            resp.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/nsx/index");
        }
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NSX nsx = new NSX();
        try {
            BeanUtils.populate(nsx, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        errorTen = Validate.checkValues(nsx.getTen(), "Tên");
        errorMa = Validate.checkValues(nsx.getMa(), "Mã");
        NSX check = nsxRepository.findByMa(nsx.getMa());
        if (check != null) {
            error = "Mã đã tồn tại!";
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/nsx/create");
            return;
        } else {
            error = "";
        }
        if (!errorTen.isEmpty() || !errorMa.isEmpty()) {
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/nsx/create");
            return;
        }
        this.nsxRepository.insert(nsx);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/nsx/index");

    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NSX nsx = this.nsxRepository.findByMa(ma);
        try {
            BeanUtils.populate(nsx, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        errorTen = Validate.checkValues(nsx.getTen(), "Tên");
        if (!errorTen.isEmpty()) {
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/nsx/edit?ma=" + nsx.getMa());
            return;
        }
        this.nsxRepository.update(nsx);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/nsx/index");

    }
}
