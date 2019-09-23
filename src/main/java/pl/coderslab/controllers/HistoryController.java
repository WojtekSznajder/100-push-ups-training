package pl.coderslab.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.UserDao;
import pl.coderslab.entity.Pushups;
import pl.coderslab.entity.User;
import pl.coderslab.entity.UserHistoryPushUps;
import pl.coderslab.repository.UserRepo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRepo userRepo;



    @GetMapping("")
    public String historySchedule(Model model, HttpServletRequest request) {
        if (userDao.checkLogin(request.getCookies())) {
            User currentUser = userRepo.findByLogin(userDao.getLoginFromCookies(request.getCookies()));
            List<Object> history = userDao.getHistorySchedule(currentUser);
            model.addAttribute("history", history);

            return "history";
        } else {
            return "error";
        }
    }
}
