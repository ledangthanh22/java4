package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import view_model.NSXViewModel;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/nsx/index",
        "/nsx/create",
        "/nsx/edit",
        "/nsx/update",
        "/nsx/store",
        "/nsx/delete",

})
public class NSXServlet extends HttpServlet {
    ArrayList<NSXViewModel> listNSX = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.create(req, resp);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/nsx/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.store(req, resp);
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        NSXViewModel nsxvm = new NSXViewModel(ma, ten);
        listNSX.add(nsxvm);

    }
}
