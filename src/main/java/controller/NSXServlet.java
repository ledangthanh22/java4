package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import view_model.ChucVuViewModel;
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
        request.getRequestDispatcher("/views/nsx/create.jsp").forward(request, response);
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.listNSX.add(new NSXViewModel("n1","viean"));
        request.setAttribute("danhSachNSX",this.listNSX);
        request.getRequestDispatcher("/views/nsx/index.jsp").forward(request, response);
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
