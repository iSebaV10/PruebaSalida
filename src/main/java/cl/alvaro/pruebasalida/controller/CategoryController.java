package cl.alvaro.pruebasalida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.alvaro.pruebasalida.model.Category;
import cl.alvaro.pruebasalida.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
    
    @Autowired
    CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryService.getAll();
    }
}
