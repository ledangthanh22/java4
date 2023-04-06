package controller;

import entity.ChucVu;
import entity.DongSP;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.DongSPRepository;
import utils.Validate;
import view_model.DongSPViewModel;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


@WebServlet({
        "/dongsp/index",
        "/dongsp/create",
        "/dongsp/edit",
        "/dongsp/update",
        "/dongsp/store",
        "/dongsp/delete",
})
public class DongSPServlet extends HttpServlet {
    DongSPRepository dongSPRepository = new DongSPRepository();
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
        request.setAttribute("view", "/views/dongsp/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("trungMa", error);
        request.setAttribute("danhSachDSP", this.dongSPRepository.findAll());
        request.setAttribute("view", "/views/dongsp/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        DongSP dsp = this.dongSPRepository.findByMa(ma);
        this.dongSPRepository.delete(dsp);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/dongsp/index");
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        DongSP dsp = this.dongSPRepository.findByMa(ma);
        request.setAttribute("checkTen", errorTen);
        request.setAttribute("dsp", dsp);
        request.setAttribute("view", "/views/dongsp/edit.jsp");
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
            resp.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/dongsp/index");
        }
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DongSP dsp = new DongSP();
        try {
            BeanUtils.populate(dsp, request.getParameterMap());
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        errorTen = Validate.checkValues(dsp.getTen(), "Tên");
        errorMa = Validate.checkValues(dsp.getMa(), "Mã");
        DongSP check = dongSPRepository.findByMa(dsp.getMa());
        if (check != null) {
            error = "Mã đã tồn tại!";
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/dongsp/create");
            return;
        } else {
            error = "";
        }
        if (!errorTen.isEmpty() || !errorMa.isEmpty()) {
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/dongsp/create");
            return;
        }
        this.dongSPRepository.insert(dsp);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/dongsp/index");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        DongSP dsp = this.dongSPRepository.findByMa(ma);
        try {
            BeanUtils.populate(dsp, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        errorTen = Validate.checkValues(dsp.getTen(), "Tên");
        if (!errorTen.isEmpty()) {
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/dongsp/edit?ma=" + dsp.getMa());
            return;
        }
        this.dongSPRepository.update(dsp);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/dongsp/index");
    }
}
