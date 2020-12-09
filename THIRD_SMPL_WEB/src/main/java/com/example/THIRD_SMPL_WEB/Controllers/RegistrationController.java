package com.example.THIRD_SMPL_WEB.Controllers;

import com.example.THIRD_SMPL_WEB.domain.Role;
import com.example.THIRD_SMPL_WEB.domain.User;
import com.example.THIRD_SMPL_WEB.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration(){

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if(userFromDb != null){
            model.put("messages_to_page", "user exists!");
            return "registration";
        }

        user.setActive(true);
        user.setFilms("");
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        return "redirect:/login";
    }
}
