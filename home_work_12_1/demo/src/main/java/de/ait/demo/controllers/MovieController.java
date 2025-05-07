package de.ait.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    @RequestMapping(value = "/films", method = RequestMethod.GET)
    public List<Movie> getFilms() {
// возвращаем 10 случайных фильмов
        List<Movie> films = new ArrayList<>();
       int value = (int) (Math.random() * 89);
        for (int i = 0; i < 10; i++) {
            films.add(MovieDB.movieArray[value + i]);
        }

        return films;
    };
}
