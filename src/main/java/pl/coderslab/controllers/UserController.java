package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.coderslab.dao.UserDao;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {


    private UserDao userDao;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private UserRepo userRepo;

    @Autowired
    public UserController(UserDao userDao, PasswordEncoder passwordEncoder, UserRepo userRepo) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.userRepo = userRepo;
    }

    // wyświetlenie formularza register
    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("register", new User());
        return "register";
    }

    // zapis do bazy danych
    @RequestMapping("/register")
    public String registerSave(@ModelAttribute User user) {
        String pass = passwordEncoder.encode(user.getPassword());
        user.setPassword(pass);
        userDao.save(user);
        return "redirect:log";
    }

    // wyświetlenie logowania
    @GetMapping("/log")
    public String logForm(Model model) {
        model.addAttribute("log", new User());
        return "log";
    }

    //  logowanie
    @RequestMapping("/log")
    public String logIn(@ModelAttribute User user, HttpServletResponse response) {
        User codedPass = userRepo.findByLogin(user.getLogin());
        if (passwordEncoder.matches(user.getPassword(), codedPass.getPassword())) {
            Cookie cookie = new Cookie("user", user.getLogin());
            cookie.setPath("/");
            response.addCookie(cookie);
            return "redirect:/menu";
        } else {
            return "error";
        }
    }



}



