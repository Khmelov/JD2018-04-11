package by.it.krivenkova.project.java.controller;

import by.it.krivenkova.project.java.beans.User;
import by.it.krivenkova.project.java.dao.Dao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CmdEditRoute extends Cmd{
    @Override
    Actions execute(HttpServletRequest req) throws SQLException {
        Dao dao = Dao.getDao();
        if (Util.isPost(req)) {
            Long id = Util.getLong(req, "id");
            String login = Util.getString(req, "login");
            String email = Util.getString(req, "email");
            String password = Util.getString(req, "password");
            String surname = Util.getString(req, "surname");
            String name = Util.getString(req, "name");
            String patronymic = Util.getString(req, "patronymic");
            Long rolesId = Util.getLong(req, "roles_id");
            User user = new User(id, login, password, surname, name, patronymic, email, rolesId);
            if (req.getParameter("Update") != null) {
                dao.user.update(user);
            } else if (req.getParameter("Delete") != null) {
                dao.user.delete(user);
            }
        }
        List<User> users = dao.user.getAll("");
        req.setAttribute("users", users);
      /*  List<Role> roles = dao.role.getAll("");
        req.setAttribute("roles", roles);*/
        return null;
    }

    /* @Override
    Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
     /*   User user = Util.getUserFromSession(req);
        if (user != null) {
            if (Util.isPost(req)) {
                if (req.getParameter("Update") != null || req.getParameter("Delete") != null) {
                    Dao dao = Dao.getInstance();
                    int id = Integer.parseInt(req.getParameter("id"));
                    Product ourProduct = dao.product.read(id);
                    String name = req.getParameter("name");
                    String description = req.getParameter("description");
                    double price = Double.parseDouble(req.getParameter("price"));
                    int users_id = ourProduct.getUsers_id();
                    Product editProduct = new Product(id, name, description, price, users_id);
                    if (req.getParameter("Update") != null) {
                        dao.product.update(editProduct);
                        return Actions.EDITPRODUCT.command;
                    } else if (req.getParameter("Delete") != null) {
                        dao.product.delete(editProduct);
                        return Actions.EDITPRODUCT.command;
                    }
                }
            } else {
                String login = user.getLogin();
                String pass = user.getPassword();
                Cookie cookie = new Cookie(login, pass);
                cookie.setMaxAge(60);
                resp.addCookie(cookie);
                List<Product> listGoods = DAO.getInstance().product.getAll("");
                req.getSession().setAttribute("listGoods", listGoods);
            }*/
      /*      return null;
        }*/
     /*   return Actions.LOGIN.command;
    }*/
}
