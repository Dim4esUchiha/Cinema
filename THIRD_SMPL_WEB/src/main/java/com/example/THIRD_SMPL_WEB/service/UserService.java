package com.example.THIRD_SMPL_WEB.service;

import com.example.THIRD_SMPL_WEB.domain.Role;
import com.example.THIRD_SMPL_WEB.domain.User;
import com.example.THIRD_SMPL_WEB.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public void saveUser(User user, String username, Map<String, String> form) {
        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for(String key : form.keySet()){
            if(roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepo.save(user);
    }



    public void updateProfile(User user, String password, String username) {
       if(!StringUtils.isEmpty(password)){
           user.setPassword(password);
       }
       if(!StringUtils.isEmpty(username)){
           user.setUsername(username);
       }
       userRepo.save(user);
    }

    public void saveUserFilms(User user, String filmName){
        String filmString = user.getFilms();
        if(!filmString.contains(filmName)){
            filmString += filmName + '$';
            user.setFilms(filmString);
        }
        userRepo.save(user);
    }

    public void saveCancelFilm(User user, String filmName){
        String allFilms = user.getFilms();
        List<String> filmList = new ArrayList<String>();

        for(String retValue : allFilms.split("\\$")){
            if(!retValue.equals("")){
                filmList.add(retValue);
            }
        }

        String newSpecialString = "";

        for(int i = 0; i < filmList.size();++i){
            String el = filmList.get(i);
            if(!el.equals(filmName)){
                newSpecialString += el + '$';
            }
        }

        user.setFilms(newSpecialString);
        userRepo.save(user);
    }


}
