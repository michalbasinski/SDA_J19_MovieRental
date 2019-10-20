package pl.sda.movies.storage;

import pl.sda.movies.model.Movie;

public interface MovieRepository {
    Movie save(Movie movie);

    Movie findMovieByName(String name);
}
