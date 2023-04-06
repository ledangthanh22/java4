package controller;

import entity.ChucVu;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;
import repositories.ChucVuRepository;
import utils.Validate;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/chucvu/index",
        "/chucvu/create",
        "/chucvu/edit",
        "/chucvu/update",
        "/chucvu/store",
        "/chucvu/delete",

})
public class ChucVuServlet extends HttpServlet {

    ChucVuRepository chucVuRepository = new ChucVuRepository();
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
        request.setAttribute("view", "/views/chucvu/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("trungMa", error);
        request.setAttribute("danhSachCVu", this.chucVuRepository.findAll());
        request.setAttribute("view", "/views/chucvu/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChucVu cv = this.chucVuRepository.findByMa(ma);
        this.chucVuRepository.delete(cv);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/chucvu/index");
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChucVu cv = this.chucVuRepository.findByMa(ma);
        request.setAttribute("checkTen", errorTen);
        request.setAttribute("cv", cv);
        request.setAttribute("view", "/views/chucvu/edit.jsp");
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
            resp.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/chucvu/index");
        }
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChucVu cv = new ChucVu();
        try {

            BeanUtils.populate(cv, request.getParameterMap());
//            this.chucVuRepository.insert(cv);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        errorTen = Validate.checkValues(cv.getTen(), "Tên");
        errorMa = Validate.checkValues(cv.getMa(), "Mã");
        ChucVu check = chucVuRepository.findByMa(cv.getMa());
        if (check != null) {
            error = "Mã đã tồn tại!";
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/chucvu/create");
            return;
        } else {
            error = "";
        }
        if (!errorTen.isEmpty() || !errorMa.isEmpty()) {
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/chucvu/create");
            return;
        }
        this.chucVuRepository.insert(cv);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/chucvu/index");

    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChucVu cv = this.chucVuRepository.findByMa(ma);
        try {
            BeanUtils.populate(cv, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        errorTen = Validate.checkValues(cv.getTen(), "Tên");
        if (!errorTen.isEmpty()) {
            response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/chucvu/edit?ma=" + cv.getMa());
            return;
        }
        this.chucVuRepository.update(cv);
        response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/chucvu/index");
    }

}
