package pl.coderslab.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.HistoryServiceDao;
import pl.coderslab.dao.PushUpsDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.entity.Pushups;
import pl.coderslab.entity.User;
import pl.coderslab.entity.UserHistoryPushUps;
import pl.coderslab.repository.UserHistoryPushUpsRepo;
import pl.coderslab.repository.UserRepo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/pushUps")
public class PushUpsController {


    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private HistoryServiceDao historyServiceDao;
    @Autowired
    private PushUpsDao pushUpsDao;
    @Autowired
    private UserHistoryPushUpsRepo userHistoryPushUpsRepo;

    // wyświetlenie formularza formPushups
    @GetMapping("/test")
    public String formPUshUps(Model model, HttpServletRequest request) {
        if (userDao.checkLogin(request.getCookies())) {
            model.addAttribute("pushups", new User());
            return "pushups";
        } else {
            return "error";
        }
    }

    //  pobranie testu pushups i zapis do bazy
    @RequestMapping("/test")
    public String pushupsTestSave(@ModelAttribute User user, Model model, HttpServletRequest request) {
        if (userDao.checkLogin(request.getCookies())) {
            User currentUser = userRepo.findByLogin(userDao.getLoginFromCookies(request.getCookies()));

            currentUser.setPushUpsRep(user.getPushUpsRep());
            userDao.update(currentUser);
            return "redirect:/pushUps/schedule";
        } else {
            return "error";
        }
    }


    // wyświetlenie planu treningowego
    @GetMapping("/schedule")
    public String pushUpsSchedule(Model model, HttpServletRequest request) {
        if (userDao.checkLogin(request.getCookies())) {
            User currentUser = userRepo.findByLogin(userDao.getLoginFromCookies(request.getCookies()));
            List<UserHistoryPushUps> training = userHistoryPushUpsRepo.findAllByUsers(currentUser);
            List<Pushups> trainingSchedule = userDao.getTrainingSchedulePushUps(currentUser);
            List<Pushups> trainingsFinal = removeDoneTrainings(training, trainingSchedule);
            model.addAttribute("trainings", training);
            model.addAttribute("pushups", trainingsFinal);
            model.addAttribute("user", currentUser);
            model.addAttribute("userhistorypushup", new UserHistoryPushUps());
            return "pushupsSchedule";
        } else {
            return "error";
        }
    }

    @PostMapping("/schedule")
    public String pushUpsHistory(@RequestParam String pushups, @RequestParam String users, HttpServletRequest request) {
        if (userDao.checkLogin(request.getCookies())) {
            User currentUser = userRepo.findById(Long.parseLong(users));
            Pushups currentPushUps = pushUpsDao.findById(Long.parseLong(pushups));
            UserHistoryPushUps userHistoryPushUps = new UserHistoryPushUps();
            userHistoryPushUps.setUsers(currentUser);
            userHistoryPushUps.setPushups(currentPushUps);
            historyServiceDao.save(userHistoryPushUps);
            return "redirect:/pushUps/schedule";
        } else {
            return "error";
        }
    }

    public List<Pushups> removeDoneTrainings(List<UserHistoryPushUps> doneTrainings, List<Pushups> training) {
        List<Pushups> resultTrainings = new ArrayList<>(training);

        int index = 0;
        if (doneTrainings.size() == 0) {
            return training;
        } else {
            for (UserHistoryPushUps dt : doneTrainings) {

                for (Pushups t : training) {

                    if (t.getId() == dt.getPushups().getId()) {
                        resultTrainings.remove(t);
                    }
                    index++;
                }
            }
        }
        return resultTrainings;
    }
}
