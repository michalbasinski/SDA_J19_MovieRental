package pl.sda.movies.model;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(String msg) {
        super(msg);
    }
}
