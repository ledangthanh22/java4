package controller;
import entity.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repositories.NhanVienRepository;
import java.io.IOException;

    @WebServlet("/login")
    public class LoginServlet extends HttpServlet {
        private NhanVienRepository nhanVienRepository = new NhanVienRepository();
        @Override
        protected void doGet(
                HttpServletRequest request,
                HttpServletResponse response
        ) throws ServletException, IOException {
            request.getRequestDispatcher("/views/login.jsp")
                    .forward(request, response);
        }

        @Override
        protected void doPost(
                HttpServletRequest request,
                HttpServletResponse response
        ) throws ServletException, IOException {
            String ma = request.getParameter("ma");
            String matKhau = request.getParameter("matKhau");
            NhanVien nv = this.nhanVienRepository.login(ma, matKhau);
            HttpSession session = request.getSession();
         if (nv == null) {
                session.setAttribute("errorMessage", "Tài khoản hoặc mật khẩu không đúng!");
                response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/login");
            } else {
                session.setAttribute("nv", nv);
                response.sendRedirect("/SOF3011_IT17311_thanhldph22749_war_exploded/admin");
            }
        }
    }

