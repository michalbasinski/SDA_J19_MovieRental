package pl.sda.facades.Movie;
import com.itextpdf.text.DocumentException;
import pl.sda.converter.SDAFileWriter;
import pl.sda.converter.csv.CSVWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieRepository {

    private SDAFileWriter writer = new CSVWriter();
    private MovieReader movieReader = new MovieReader();
    private String MSG = "Brak filmu o podanym id";

    private List<Movie> movies = new ArrayList<>();
    private MovieSaveAdapter movieSaveAdapter = new MovieSaveAdapter();
    private String filePath = "C:\\Users\\48691\\SDA_J19_MovieRental3\\src\\main\\resources\\movies.csv";

    public List<Movie> setUpMovies() {
        movies = movieReader.readMovieDB(filePath);
//        movies.add(new Movie("Tytuł A", "Rezyser Piotr", 2015, 1, 15));
//        movies.add(new Movie("Tytuł B", "Rezyser Piotr", 2016, 2,11));
//        movies.add(new Movie("Tytuł C", "Rezyser Michal", 2017, 3,15));
//        movies.add(new Movie("Tytuł D", "Rezyser Marcin", 2019, 4, 20));
//        movies.add(new Movie("Tytuł E", "Rezyser Rysiu", 2011, 5, 22));
//        movies.add(new Movie("Tytuł F", "Rezyser Filip", 2012, 6,14));
//        movies.add(new Movie("Tytuł G", "Rezyser Kuba", 2013, 7,15));
//        movies.add(new Movie("Tytuł H", "Rezyser Stachu", 2012, 8,12));
//        movies.add(new Movie("Tytuł I", "Rezyser Piotr", 2011, 9,22));
        return this.movies;
    }

    void save(Movie movie) {
        this.movies.add(movie);
        List<Map<String, Object>> moviesIntoMap = movieSaveAdapter.movieListToMap(movies);
        try {
            writer.write(moviesIntoMap, filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    void delete(Movie movie) {
        this.movies.remove(movie);
        List<Map<String, Object>> moviesIntoMap = movieSaveAdapter.movieListToMap(this.movies);
        try {
            writer.write(moviesIntoMap, filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    Movie findMovieById(Integer id) {
        return movies.stream().filter(m -> (m.getId().equals(id)))
                .findFirst().orElseThrow(() -> new IllegalArgumentException(MSG));
    }

    Movie searchMovieRepository(MovieSearchParameters movieSearchParameters) {
        Movie movie = null;
        switch (movieSearchParameters) {
            case BYTITLE:
                movie = searchByTitle();
                break;
            case BYMAKEYEAR:
                movie = searchByMakeYear();
                break;
            case BYDIRECTOR:
                movie = searchByDirector();
                break;
        }
        return movie;
    }

    private Movie searchByTitle() {
        String title = "Szklana pulapka";
        List<Movie> collect = movies.stream().filter(movie -> movie.getTitle().toUpperCase().equals(title.toUpperCase())).collect(Collectors.toList());
        Movie movie = collect.get(0);
        return movie;
    }

    private Movie searchByMakeYear() {
        String makeYear = "1993";
        List<Movie> collect = movies.stream().filter(movie -> movie.getMakeYear().toString().equals(makeYear)).collect(Collectors.toList());
        Movie movie = collect.get(0);
        return movie;
    }

    private Movie searchByDirector() {
        String director = "Rezyser ksawery";
        List<Movie> collect = movies.stream().filter(movie -> movie.getDirector().toUpperCase().equals(director.toUpperCase())).collect(Collectors.toList());
        Movie movie = collect.get(0);
        return movie;
    }

    public void update(String id, String newPrice) throws FileNotFoundException, DocumentException {
        Movie movieById = findMovieById(Integer.valueOf(id));
        movieById.setPrice(Integer.valueOf(newPrice));
        List<Map<String, Object>> maps = movieSaveAdapter.movieListToMap(movies);
        writer.write(maps, filePath);
    }
}

//    void update(Movie movieById, String newPrice) throws FileNotFoundException, DocumentException {
//


//        Movie movieToUpdate = movies.stream().filter(movie -> movie.getId().toString().equals(movieById.getId().toString()))
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException(MSG));
//        movieToUpdate.setPrice(Integer.valueOf(newPrice));
//        List<Map<String, Object>> updatedMovies = movieSaveAdapter.movieListToMap(movies);
//        writer.write(updatedMovies, filePath);


