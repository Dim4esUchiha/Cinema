package com.example.THIRD_SMPL_WEB.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String filmName;
    private String filmGenre;
    private String filmDescription;


    public Film(){
    }

    public Film(String filmName, String filmGenre, String filmDescription) {
        this.filmName = filmName;
        this.filmGenre = filmGenre;
        this.filmDescription = filmDescription;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmGenre() {
        return filmGenre;
    }

    public void setFilmGenre(String filmGenre) {
        this.filmGenre = filmGenre;
    }

    public String getFilmDescription() {
        return filmDescription;
    }

    public void setFilmDescription(String filmDescription) {
        this.filmDescription = filmDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

