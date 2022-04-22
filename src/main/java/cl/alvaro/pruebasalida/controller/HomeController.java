package cl.alvaro.pruebasalida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.alvaro.pruebasalida.model.Category;
import cl.alvaro.pruebasalida.service.CategoryService;
import cl.alvaro.pruebasalida.service.FilmService;

@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    FilmService filmService;

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public String home(@RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "title", required = false) String title,
            Model model){

        List<Category> categories = categoryService.getAll();
        categories.sort((b1, b2) -> b1.getName().compareTo(b2.getName()));
        model.addAttribute("films", filmService.filter(category,title));
        model.addAttribute("categories" , categories);
        return "index.html";
    }
    
}
