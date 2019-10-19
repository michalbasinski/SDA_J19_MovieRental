package pl.sda.movieRental;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {
    List<Movie> movieList = new ArrayList<>();

    public MovieRepository() {
        movieList.add(new Movie(1, "Szczeki", MovieType.HORROR, "Steven Spielberg"));
        movieList.add(new Movie(2, "DeadPool", MovieType.ACTION, "Tim Miller"));
        movieList.add(new Movie(3, "Gwiezdne wojny czesc 3 - Zemsta Sithow", MovieType.SCI_FI, "George Lucas"));
        movieList.add(new Movie(4, "Shazam", MovieType.ACTION, "David F. Sandberg"));
        movieList.add(new Movie(5, "Aquaman", MovieType.ACTION, "James Wan"));
        movieList.add(new Movie(6, "Szeregowiec Ryan", MovieType.DRAMA, "Steven Spielberg"));
        movieList.add(new Movie(7, "Kraina lodu", MovieType.KIDS, "Jenniffer Lee"));
        movieList.add(new Movie(8, "Killer", MovieType.COMEDY, "Juliusz Machulski"));
        movieList.add(new Movie(9, "Killer-ow 2-ch", MovieType.COMEDY, "Juliusz Machulski"));
        movieList.add(new Movie(10, "Ciekawy przypadek Benjamina Buttona", MovieType.FANTASY, "David Fincher"));
        movieList.add(new Movie(11, "Siedem", MovieType.THRILLER, "David Fincher"));
        movieList.add(new Movie(12, "Polityka", MovieType.FEATURE, "Patryk Vega"));
    }

    public void save (Movie movie) {
    }
}
