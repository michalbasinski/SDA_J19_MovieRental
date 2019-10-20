package pl.sda.movies;

import lombok.AllArgsConstructor;
import pl.sda.movies.model.Movie;
import pl.sda.movies.storage.MovieRepository;

@AllArgsConstructor
public class MovieFacade {

    private MovieRepository movieRepository;

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }
}
