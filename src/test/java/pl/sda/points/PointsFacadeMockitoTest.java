package pl.sda.points;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.sda.movies.model.Movie;
import pl.sda.points.calculators.DefaultPointsCalculator;
import pl.sda.points.model.Points;
import pl.sda.points.storage.PointsRepository;
import pl.sda.rentals.Rental;
import pl.sda.users.model.User;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PointsFacadeMockitoTest {

    @Mock
    private PointsRepository pointsRepository;

    @InjectMocks
    private PointsFacade pointsFacade = new PointsFacade(pointsRepository, new DefaultPointsCalculator());

    @Captor
    ArgumentCaptor<Points> pointsCaptor;

    @Test
    public void pointsWereCalculatedSuccessfullyForExistingUser() {
        //given
        final User user = new User(1L, "Kowalski");

        final Movie movie = new Movie(1L, "Test", 100, LocalDate.of(1999, 1, 1));
        final Rental rental = new Rental(user, movie,
                LocalDate.of(2019, 10, 10),
                LocalDate.of(2019, 10, 19));
        final Integer expectedPoints = 11;
        when(pointsRepository.findUserPoints(1L)).thenReturn(Optional.of(new Points(0L, 1L, 10)));

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

        when(pointsRepository.findUserPoints(5L)).thenReturn(Optional.empty());

        //when
        Points points = pointsFacade.movieWasRented(rental);

        //then
        // pointsRepository jest mockowane, można przechwycić argument wpadający do mocka za pomocą tzw. captora
        // więcej informacji: https://examples.javacodegeeks.com/core-java/mockito/mockito-captor-example/
        verify(pointsRepository, times(1)).save(pointsCaptor.capture());
        assertEquals(expectedPoints, pointsCaptor.getValue().getPoints());
    }
}
