package ra.projectmodule4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.projectmodule4.model.User;
import ra.projectmodule4.service.impl.UserService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/myprofile")
public class MyProfileController {
    @Autowired
    private UserService userService;

    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, Model model) {
        User userEdit = userService.findById(userId);
        if (userEdit != null) {
            model.addAttribute("userEdit", userEdit);

        } else {

        }
        return "edit";
    }

    @PostMapping("/edit/{userId}")
    public String doUpdate(@ModelAttribute("userEdit") User userUpdate, Model model, HttpSession session) {
        User user = (User) session.getAttribute("userlogin");
        userUpdate.setId(user.getId());
        userService.save(userUpdate);
        session.setAttribute("userlogin", userUpdate);
        model.addAttribute("updateSuccess", true);
        return "redirect:/myprofile";
    }
}
