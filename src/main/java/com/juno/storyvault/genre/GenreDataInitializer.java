package com.juno.storyvault.genre;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenreDataInitializer implements CommandLineRunner {

    private final GenreRepository genreRepository;

    public GenreDataInitializer(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public void run(String... args) {

        List<String> genres = List.of(
                "Fantasy",
                "Romantasy",
                "Romance",
                "Contemporary Fiction",
                "Historical Fiction",
                "Science Fiction",
                "Mystery",
                "Thriller",
                "Horror",
                "Young Adult",
                "Literary Fiction",
                "Non-Fiction"
        );

        for (String genreName : genres) {
            if (!genreRepository.existsByNameIgnoreCase(genreName)) {
                genreRepository.save(new Genre(genreName));
            }
        }
    }
}
