package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import view_model.ChucVuViewModel;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/chucvu/index",
        "/chucvu/create",
        "/chucvu/edit",
        "/chucvu/update",
        "/chucvu/store",
        "/chucvu/delete",

})
public class ChucVuServlet extends HttpServlet {
    ArrayList<ChucVuViewModel> listCV = new ArrayList<>();

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
        request.getRequestDispatcher("/views/chucvu/create.jsp").forward(request, response);
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.listCV.add(new ChucVuViewModel("Cv1","Nhan vien"));
        request.setAttribute("danhSachCVu",this.listCV);
        request.getRequestDispatcher("/views/chucvu/index.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.store(req, resp);
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        ChucVuViewModel cvvm = new ChucVuViewModel(ma, ten);
        listCV.add(cvvm);
    }
}
