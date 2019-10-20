package pl.sda.points;

import org.junit.Test;
import pl.sda.movies.model.Movie;
import pl.sda.points.model.Points;
import pl.sda.points.storage.InMemoryPointsRepository;
import pl.sda.rentals.Rental;
import pl.sda.users.model.User;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class PointsFacadeTest {
    private PointsFacade pointsFacade = new PointsFacade(new InMemoryPointsRepository());

    @Test
    public void pointsWereCalculatedSuccessfullyForExistingUser() {
        //given
        final User user = new User(1L, "Kowalski");
        final Movie movie = new Movie(1L, "Test", 100, LocalDate.of(1999, 1, 1));
        final Rental rental = new Rental(user, movie,
                LocalDate.of(2019, 10, 10),
                LocalDate.of(2019, 10, 19));
        final Integer expectedPoints = 11;

        //when
        Points points = pointsFacade.movieWasRented(rental);

        //then
        assertEquals(expectedPoints, points.getPoints());
    }

    @Test
    public void pointsWereCalculatedSuccessfullyForNewUser() {
        //given
        final User user = new User(5L, "Kowalski");
        final Movie movie = new Movie(1L, "Test", 100, LocalDate.of(1999, 1, 1));
        final Rental rental = new Rental(user, movie,
                LocalDate.of(2019, 10, 10),
                LocalDate.of(2019, 10, 19));
        final Integer expectedPoints = 1;

        //when
        Points points = pointsFacade.movieWasRented(rental);

        //then
        assertEquals(expectedPoints, points.getPoints());
    }
}