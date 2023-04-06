package controller;

import entity.SanPhamCT;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositories.SanPhamCTRepository;

import java.io.IOException;

@WebServlet("/detail")
public class DetailsServlet extends HttpServlet {
    SanPhamCTRepository sanPhamCTRepository = new SanPhamCTRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        SanPhamCT sp = this.sanPhamCTRepository.findById(id);
        req.setAttribute("detail",sp);
        req.setAttribute("view", "/views/banhang/productDetails.jsp");
        req.getRequestDispatcher("/views/layoutbh.jsp").forward(req, resp);
    }
}
