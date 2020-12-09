package com.example.THIRD_SMPL_WEB.Controllers;

import com.example.THIRD_SMPL_WEB.domain.Film;
import com.example.THIRD_SMPL_WEB.domain.User;
import com.example.THIRD_SMPL_WEB.repos.FilmRepo;
import com.example.THIRD_SMPL_WEB.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private FilmRepo filmRepo;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model,@AuthenticationPrincipal User user) {
        if(user == null){
            model.put("username","Guest");
        }else{
            model.put("username",user.getUsername());
        }
        return "greeting";
    }

    @GetMapping("/main")
    public String main(
            @RequestParam(required = false) String genreFilter,
            @RequestParam(required = false) String nameFilter,
            Map<String, Object> model)
    {
        Iterable<Film> films;
        List<Film> listFilms = new ArrayList<>();
        if(nameFilter != null && !nameFilter.isEmpty() && genreFilter != null && !genreFilter.equals("Choose...")){
            Film namedFilm;
            namedFilm = filmRepo.findByFilmNameAndFilmGenre(nameFilter, genreFilter);
            listFilms.add(namedFilm);
            model.put("films_to_page",listFilms);
            return "main";
        }else if(nameFilter != null && !nameFilter.isEmpty()){
            Film filmByName;
            filmByName = filmRepo.findByFilmName(nameFilter);
            listFilms.add(filmByName);
            model.put("films_to_page",listFilms);
            return "main";
        } else if(genreFilter!=null && !genreFilter.equals("Choose...")){
            films = filmRepo.findByFilmGenre(genreFilter);
        } else{
            films = filmRepo.findAll();
        }

        model.put("films_to_page",films);
        return "main";
    }

    @GetMapping("/addFilms")
    public String addFilmPage(){
        return "addFilms";
    }

    @PostMapping("/addFilms")
    public String addFilms(
            @RequestParam String filmName,
            @RequestParam String filmGenre,
            @RequestParam String filmDescription
    )
    {
        Film film = new Film(filmName, filmGenre, filmDescription);
        filmRepo.save(film);

        return "addFilms";
    }





 /*   @GetMapping("infoAboutFilm/{filmInfoName}/{filmGenre}")
    public String showInfo(@AuthenticationPrincipal User user,
                           @PathVariable(name = "filmInfoName") String filmName,
                           @PathVariable(name="filmGenre") String filmGenre,
                           Map<String,Object> model
    )
    {
        Film buyFilm = filmRepo.findByFilmNameAndFilmGenre(filmName,filmGenre);
        user.addFilm(buyFilm.getFilmName());
        model.put("infoAboutFilmec",buyFilm);
        return "infoAboutFilm";
    }



    @GetMapping("/user-myFilms/{user}")
    public String userMessages(
            @AuthenticationPrincipal User currentUser,
            @PathVariable(name = "user") User user,
            Map<String, Object> model
    )
    {
        String allUserFilms = user.getFilms();
        List<String> filmsList = new ArrayList<String>();
        for(String retvalue : allUserFilms.split("$")){
            filmsList.add(retvalue);
        }
        List<Film> films = new ArrayList<>();
        for(String s : filmsList){
            films.add(filmRepo.findByFilmName(s));
        }
        model.put("films_to_page",films);
        return "userFilms";
    }*/
}
