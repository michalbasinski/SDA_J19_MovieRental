package pl.sda.facades.Movie;

import com.itextpdf.text.DocumentException;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.Assert.*;

public class MovieRepositoryTest {

    MovieRepository movieRepository = new MovieRepository();

    @Test
    public void setUpMoviesShouldLoadAListOfMoviesFromFile() {
        final List<Movie> movies;
        final int arraySize = 7;

        movies = movieRepository.setUpMovies();

        assertFalse(movies.isEmpty());
        assertEquals(movies.size(), arraySize);
    }

    @Test
    public void save() {
        //TODO w pliku widac, ze dziala-dodaje filmy
    }

    @Test
    public void delete() {
        //TODO w pliku widac, ze dziala-usuwa filmy
    }

    @Test
    public void findMovieByIdShouldFindMovieByIdInMovieRepository() {
        final List<Movie> movies = movieRepository.setUpMovies();
        final String id="4";
        final String title = "szklana pulapka";

        Movie movieById = movieRepository.findMovieById(4);

        assertEquals(movieById.getId().toString(), id);
        assertEquals(movieById.getTitle().toUpperCase(), title.toUpperCase());

    }

    @Test
    public void searchByTitleInMovieRepositoryShouldReturnSzklanaPulapkaMovie() {
        final String title="szklana pulapka";
        final List<Movie> movies = movieRepository.setUpMovies();

        Movie movie = movieRepository.searchMovieRepository(MovieSearchParameters.BYTITLE);

        assertEquals(title.toUpperCase(), movie.getTitle().toUpperCase());
    }
    @Test
    public void searchByMakeYearInMovieRepositoryShouldReturnMovieMadeIn1993() {
        final String makeYear="1993";
        final List<Movie> movies = movieRepository.setUpMovies();

        Movie movie = movieRepository.searchMovieRepository(MovieSearchParameters.BYMAKEYEAR);

        assertEquals(Integer.valueOf(makeYear), movie.getMakeYear());
    }
    @Test
    public void searchByDirectorInMovieRepositoryShouldReturnMovieDirectedByRezyserKsawery() {
        final String director="Rezyser Ksawery";
        final List<Movie> movies = movieRepository.setUpMovies();

        Movie movie = movieRepository.searchMovieRepository(MovieSearchParameters.BYDIRECTOR);

        assertEquals(director.toUpperCase(), movie.getDirector().toUpperCase());
    }

    @Test
    public void update() throws FileNotFoundException, DocumentException {
        final List<Movie> movies = movieRepository.setUpMovies();
        final Integer oldPrice= movies.get(6).getPrice();
        final String price="77";

        movieRepository.update("7", "77");

        Integer newPrice = movies.get(6).getPrice();

        assertNotEquals(oldPrice, newPrice);
        assertEquals(price,newPrice.toString());

    }
}