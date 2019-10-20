package pl.sda.movies.storage;

import pl.sda.movies.model.Movie;
import pl.sda.movies.model.MovieNotFoundException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InMemoryMovieRepository implements MovieRepository {

    private List<Movie> movies;
    private Long nextId;

    public InMemoryMovieRepository() {
        movies = new ArrayList<>();
        movies.add(new Movie(0L, "Szeregowiec Ryan", 160, LocalDate.of(1998, 9, 10)));
        movies.add(new Movie(1L, "Imperium kontratakuje", 120, LocalDate.of(1980, 10, 10)));
        nextId = Long.valueOf(movies.size());
    }

    @Override
    public Movie save(Movie movie) {
        movie.setId(nextId++);
        movies.add(movie);
        return movie;
    }

    @Override
    public Movie findMovieByName(String name) {
        return movies.stream().filter(movie -> name.equals(movie.getTitle())).findFirst().orElseThrow(() -> new MovieNotFoundException("Movie was not found"));
    }
}
