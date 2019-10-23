package pl.sda.facades.Movie;

import com.itextpdf.text.DocumentException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class MovieFacade {

    MovieRepository movieRepository = new MovieRepository();

    public List<Movie> getMovieDB (){
        List<Movie> movies = movieRepository.setUpMovies();
        return movies;
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void removeMovie(String id) {
        Movie movieById = movieRepository.findMovieById(Integer.valueOf(id));
        movieRepository.delete(movieById);
    }

    public Movie findMovie(MovieSearchParameters movieSearchParameters) {
        Movie movie = movieRepository.searchMovieRepository(movieSearchParameters);
        return movie;
    }

    public void update (String id, String newPrice) throws FileNotFoundException, DocumentException {
        movieRepository.update(id, newPrice);
    }
}
