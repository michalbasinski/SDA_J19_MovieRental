package pl.sda.movieRental;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Movie {

    private int id;
    private String movieName;
    private MovieType movieType;
    private String director;

}
