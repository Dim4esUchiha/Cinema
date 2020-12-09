package com.example.THIRD_SMPL_WEB.repos;

import com.example.THIRD_SMPL_WEB.domain.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmRepo extends CrudRepository<Film, Long> {

    List<Film> findAll();
    Film findByFilmName(String filmName);
    //List<Film> findByFilmName(String filmName);
    Film findByFilmNameAndFilmGenre(String filmName, String filmGenre);
    List<Film> findByFilmGenre(String filmGenre);
}
