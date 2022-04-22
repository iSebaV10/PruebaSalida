package cl.alvaro.pruebasalida.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.alvaro.pruebasalida.model.Category;
import cl.alvaro.pruebasalida.repository.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

}
