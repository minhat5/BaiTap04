package vn.iotstar.controllers.category;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.Users;
import vn.iotstar.services.CategoryService;
import vn.iotstar.services.impl.CategoryServiceImpl;

import java.io.IOException;

@WebServlet(urlPatterns = {"/category/list", "/category/view", "/category/create", "/category/store", "/category/edit", "/category/update", "/category/delete"})
public class CategoryController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address = request.getServletPath();
        if ("/category/list".equals(address)) {
            Users user = (Users) request.getSession().getAttribute("account");
            if (user.getRoleid() == 2) {
                request.setAttribute("item", categoryService.findByUserId(user.getId()));
            } else {
                request.setAttribute("item", categoryService.findAll());
            }
            request.getRequestDispatcher("/views/category/category-list.jsp").forward(request, response);
        }
        if ("category/view".equals(address)) {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("item", categoryService.findById(id));
            request.getRequestDispatcher("/views/category/category-view.jsp").forward(request, response);
        }
        if ("/category/create".equals(address)) {
            request.getRequestDispatcher("/views/category/category-form.jsp").forward(request, response);
        }
        if ("/category/edit".equals(address)) {
            request.getRequestDispatcher("/views/category/category-form.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address = request.getServletPath();
        Users user = (Users) request.getSession().getAttribute("account");

        if ("/category/store".equals(address)) {
            Category category = new Category();
            category.setCate_name(request.getParameter("cate_name"));
            category.setUser(user);
            categoryService.insert(category);
            response.sendRedirect(request.getContextPath() + "/category/list");
            return;
        }
        if ("/category/delete".equals(address)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Category category = categoryService.findById(id);
            categoryService.delete(category);
            response.sendRedirect(request.getContextPath() + "/category/list");
            return;
        }
        if ("/category/update".equals(address)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Category category = categoryService.findById(id);
            category.setCate_name(request.getParameter("cate_name"));
            category.setDescription(request.getParameter("description"));
            categoryService.update(category);
            response.sendRedirect(request.getContextPath() + "/category/list");
            return;
        }
        response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
}
