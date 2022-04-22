package cl.alvaro.pruebasalida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.alvaro.pruebasalida.model.Film;
import cl.alvaro.pruebasalida.service.FilmService;

@RestController
@RequestMapping("/film")
public class FilmController {
    
    @Autowired
    FilmService filmService;

    @GetMapping("/all")
    public List<Film> getAll(){
        return filmService.getAll();
    }
    @GetMapping("")
    public List<Film> getFilterList(@RequestParam(value = "category", required = false) String category,
    @RequestParam(value = "title", required = false) String title){
        return filmService.filter(category, title);
    }
}
