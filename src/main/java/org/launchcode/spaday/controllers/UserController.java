package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("add")
    public String displayAddUserForm() {
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        model.addAttribute("user", user);
        model.addAttribute("verify", verify);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        UserData.add(user);

        if (user.getPassword().equals(verify)) {
            model.addAttribute("users", UserData.getAll());
            return "user/index";
        } else {
            model.addAttribute("error", "Passwords do not match");
            return "user/add";
        }
    }

    @GetMapping("details{userId}")
    public String displayUserDetails(Model model, @PathVariable int userId) {
        User userToDisplay = UserData.getById(userId);
        model.addAttribute("user", userToDisplay);
        String title = "Username: " + userToDisplay.getUsername() + " Email: " + userToDisplay.getEmail();
        model.addAttribute("title", title);
        return "user/details";

    }

}
