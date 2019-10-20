package pl.sda.rentals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.sda.movies.model.Movie;
import pl.sda.users.model.User;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class Rental {
    private User user;
    private Movie movie;
    private LocalDate rentDate;
    private LocalDate returnDate;
}
