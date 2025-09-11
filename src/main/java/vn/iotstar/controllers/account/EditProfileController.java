package vn.iotstar.controllers.account;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.entity.Users;
import vn.iotstar.services.UserService;
import vn.iotstar.services.impl.UserServiceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

@WebServlet(urlPatterns = {"/profile-edit"})
@MultipartConfig(fileSizeThreshold = 2*1024*1024, maxFileSize = 10*1024*1024, maxRequestSize = 20*1024*1024)
public class EditProfileController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        Users account = (session != null) ? (Users) session.getAttribute("account") : null;
        if (account == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        Users fresh = userService.get(account.getUsername());
        req.setAttribute("user", fresh != null ? fresh : account);
        req.getRequestDispatcher("/views/account/profile-edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession(false);
        Users account = (session != null) ? (Users) session.getAttribute("account") : null;
        if (account == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        Users user = userService.get(account.getUsername());
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/profile");
            return;
        }

        String fullname = req.getParameter("fullname");
        String phone    = req.getParameter("phone");
        String email    = req.getParameter("email");
        Part imagePart  = req.getPart("image");

        if (fullname != null) user.setFullname(fullname.trim());
        if (phone != null)    user.setPhone(phone.trim());
        if (email != null)    user.setEmail(email.trim());

        if (imagePart != null && imagePart.getSize() > 0) {
            String submitted = imagePart.getSubmittedFileName();
            String ext = "";
            int dot = submitted.lastIndexOf('.');
            if (dot >= 0) ext = submitted.substring(dot).toLowerCase();

            String newName = "avatar-" + UUID.randomUUID() + ext;

            String uploadDir = req.getServletContext().getRealPath("/uploads/avatars");
            File dir = new File(uploadDir);
            if (!dir.exists()) Files.createDirectories(dir.toPath());

            File saveFile = new File(dir, newName);
            imagePart.write(saveFile.getAbsolutePath());

            user.setAvatar("/uploads/avatars/" + newName);
        }

        userService.update(user);

        session.setAttribute("account", user);

        resp.sendRedirect(req.getContextPath() + "/profile");
    }
}
