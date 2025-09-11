package vn.iotstar.controllers.account;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.entity.Users;
import vn.iotstar.services.UserService;
import vn.iotstar.services.impl.UserServiceImpl;

import java.io.IOException;

@WebServlet(urlPatterns = {"/profile"})
@MultipartConfig(
        fileSizeThreshold = 2 * 1024 * 1024,
        maxFileSize = 10 * 1024 * 1024,
        maxRequestSize = 20 * 1024 * 1024
)
public class ProfileController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("account") == null) {
            response.sendRedirect(request.getContextPath() + "login");
            return;
        }
        Users account = (Users) session.getAttribute("account");
        Users fresh = account;
        try {
            Users user = userService.get(account.getUsername());
            if (user != null) {
                fresh = user;
            }
        } catch (Exception e) {
        }
        request.setAttribute("user", fresh);
        request.getRequestDispatcher("/views/account/profile.jsp").forward(request, response);
    }
}
