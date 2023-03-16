package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import view_model.ChucVuViewModel;
import view_model.MauSacViewModel;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/mausac/index",
        "/mausac/create",
        "/mausac/edit",
        "/mausac/update",
        "/mausac/store",
        "/mausac/delete",

})
public class MauSacServlet extends HttpServlet {
    ArrayList<MauSacViewModel> listMS = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("create")){
            this.create(req,resp);
//        }else if(uri.contains("edit")){
//            this.edit(req,resp);
//        }else if (uri.contains("delete")){
//            this.delete(req,resp)
        }
        else {
            this.index(req,resp);
        }
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/mausac/create.jsp").forward(request, response);
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.listMS.add(new MauSacViewModel("M1","Do"));
        request.setAttribute("danhSachMS",this.listMS);
        request.getRequestDispatcher("/views/mausac/index.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.store(req, resp);
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        MauSacViewModel msvm = new MauSacViewModel(ma, ten);
        listMS.add(msvm);
    }
}
