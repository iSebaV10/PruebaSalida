package cl.alvaro.pruebasalida.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.alvaro.pruebasalida.model.*;

public interface FilmRepository extends JpaRepository<Film, Integer> {

    boolean existsByTitle(String title);

    Film findByTitle(String title);

}
