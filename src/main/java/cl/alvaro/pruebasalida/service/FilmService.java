package cl.alvaro.pruebasalida.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.alvaro.pruebasalida.model.Film;
import cl.alvaro.pruebasalida.repository.FilmRepository;

@Service
public class FilmService {
    
    @Autowired
    FilmRepository filmRepository;

    public List<Film> getAll(){
        return filmRepository.findAll();
    }

    public List<Film> filter(String category, String title ) {

        List<Film> films = filmRepository.findAll();
        List<Predicate<Film>> predicates = new ArrayList<Predicate<Film>>();
        if (category != null && !category.equals("")) {
            predicates.add(film -> film.getCategories().get(0).getName().equals(category));
        }
        if (title != null && !title.equals("")) {
            predicates.add(film -> film.getTitle().contains(title));
        }

        if (predicates.size() != 0) {
            Predicate<Film> predicateFilm = predicates.get(0);
            for (int i = 1; i < predicates.size(); i++) {
                predicateFilm = predicateFilm.and(predicates.get(i));
            }
            List<Film> filteredStock = films.stream()
                    .filter(predicateFilm)
                    .collect(Collectors.toList());

            
            return filteredStock;
        } else {
            films =filmRepository.findAll();
            return films;
        }
    }
}
