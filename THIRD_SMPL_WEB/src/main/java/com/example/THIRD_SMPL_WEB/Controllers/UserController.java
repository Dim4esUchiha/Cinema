package com.example.THIRD_SMPL_WEB.Controllers;

import com.example.THIRD_SMPL_WEB.domain.Film;
import com.example.THIRD_SMPL_WEB.domain.Role;
import com.example.THIRD_SMPL_WEB.domain.User;
import com.example.THIRD_SMPL_WEB.repos.FilmRepo;
import com.example.THIRD_SMPL_WEB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user") // при get запросе к текущему методу путь будет содержать User
//@PreAuthorize("hasAuthority('ADMIN')")// проверяет наличие прав у пользователя
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private FilmRepo filmRepo;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String userList(Model model){
        model.addAttribute("users",userService.findAll());
        return "userList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user",user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    //save method
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user)
    {
        userService.saveUser(user,username, form);

        return "redirect:/user";
    }

    @GetMapping("profile")
    public String getProfile(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("username", user.getUsername());
        model.addAttribute("password", user.getPassword());

        return "editProfile";
    }

    @PostMapping("profile") // user/profile
    public String updateProfile(
            @AuthenticationPrincipal User user,
            @RequestParam String password,
            @RequestParam String username
    )
    {
        userService.updateProfile(user, password, username);

        return "redirect:/user/profile";
    }

    @GetMapping("infoAboutFilm/{filmInfoName}/{filmGenre}")
    public String showInfo(@AuthenticationPrincipal User user,
                           @PathVariable(name = "filmInfoName") String filmName,
                           @PathVariable(name="filmGenre") String filmGenre,
                           Map<String,Object> model
    )
    {
        Film buyFilm = filmRepo.findByFilmNameAndFilmGenre(filmName,filmGenre);
        String filmN = buyFilm.getFilmName();

        userService.saveUserFilms(user,filmN);
        model.put("infoAboutFilmec",buyFilm);
        return "infoAboutFilm";
    }

    @GetMapping("/user-myFilms/{user}")
    public String userFilms(
            @AuthenticationPrincipal User currentUser,
            @PathVariable(name = "user") User user,
            Map<String, Object> model
    )
    {
        String allUserFilms = user.getFilms();
        List<String> filmsList = new ArrayList<String>();
        for(String retvalue : allUserFilms.split("\\$")){
            if(!retvalue.equals("")) {
                filmsList.add(retvalue);
            }
        }
        List<Film> films = new ArrayList<>();
        for(String s : filmsList){
            films.add(filmRepo.findByFilmName(s));
        }
        model.put("films_to_page",films);
        return "userFilms";
    }

    @GetMapping("/user-myFilmsCancel/{filmName}")
    public String cancelFilm(
            @AuthenticationPrincipal User currentUser,
            @PathVariable(name = "filmName") String filmName,
            Map<String, Object> model
    )
    {
        userService.saveCancelFilm(currentUser,filmName);

        Film cancelFilm = filmRepo.findByFilmName(filmName);

        model.put("cancelFilm",cancelFilm);

        return "cancelFilm";
    }

}
