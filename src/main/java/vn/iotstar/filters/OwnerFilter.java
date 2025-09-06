package vn.iotstar.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.Users;
import vn.iotstar.services.CategoryService;
import vn.iotstar.services.impl.CategoryServiceImpl;

import java.io.IOException;

public class OwnerFilter implements Filter {
    private final CategoryService categoryService = new CategoryServiceImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        Users user = (Users) req.getSession().getAttribute("account");
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = categoryService.findById(id);
        if (category == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        if (user.getRoleid() != 3) {
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
