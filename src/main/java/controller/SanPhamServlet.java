package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import view_model.ChucVuViewModel;
import view_model.SanPhamViewModel;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/sanpham/index",
        "/sanpham/create",
        "/sanpham/edit",
        "/sanpham/update",
        "/sanpham/store",
        "/sanpham/delete",

})
public class SanPhamServlet extends HttpServlet {
    ArrayList<SanPhamViewModel> listSP = new ArrayList<>();
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
        request.getRequestDispatcher("/views/sanpham/create.jsp").forward(request, response);
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.listSP.add(new SanPhamViewModel("SP1","Ao so mi"));
        request.setAttribute("danhSachSPham",this.listSP);
        request.getRequestDispatcher("/views/sanpham/index.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.store(req, resp);
    }
    protected void store(HttpServletRequest request, HttpServletResponse response)throws  ServletException, IOException{
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        SanPhamViewModel spvm =new SanPhamViewModel(ma,ten);
        listSP.add(spvm);
    }
}
