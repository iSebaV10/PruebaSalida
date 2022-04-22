package cl.alvaro.pruebasalida.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.alvaro.pruebasalida.model.*;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
    boolean existsByName(String name);
    Category findByName(String name);

}
