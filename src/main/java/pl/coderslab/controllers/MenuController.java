package pl.coderslab.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.UserDao;
import pl.coderslab.entity.Pushups;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepo;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRepo userRepo;


    @GetMapping("")
    public String menuForm(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String cookieName = "user";
        for (Cookie c : cookies) {
            if (cookieName.equals(c.getName())) {
                return "menu";

            }
        }
        return "error";


    }

    @RequestMapping("")
    @ResponseBody
    public String logOut(HttpServletRequest request, HttpServletResponse response) {


        Cookie[] cookies = request.getCookies();
        String cookieName = "user";
        for (Cookie c : cookies) {
            if (cookieName.equals((c.getName()))) {
                c.setMaxAge(0);
                response.addCookie(c);

                return "wylogowano";
            }

        } return "menu";
        }


}