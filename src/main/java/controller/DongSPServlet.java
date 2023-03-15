package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import view_model.ChucVuViewModel;
import view_model.DongSPViewModel;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/dongsp/index",
        "/dongsp/create",
        "/dongsp/edit",
        "/dongsp/update",
        "/dongsp/store",
        "/dongsp/delete",
})
public class DongSPServlet extends HttpServlet {
    ArrayList<DongSPViewModel> listDSP = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.create(req, resp);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/dongsp/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.store(req, resp);
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        DongSPViewModel dsp = new DongSPViewModel(ma, ten);
        listDSP.add(dsp);
    }
}
