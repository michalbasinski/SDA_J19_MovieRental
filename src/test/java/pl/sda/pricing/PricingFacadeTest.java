package pl.sda.pricing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.sda.movies.model.Movie;
import pl.sda.pricing.calculators.DefaultPriceCalculator;
import pl.sda.pricing.calculators.PriceCalculator;
import pl.sda.rentals.Rental;
import pl.sda.time.TimeRepository;
import pl.sda.users.model.User;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PricingFacadeTest {

    @Mock
    private TimeRepository timeRepository;

    @InjectMocks
    private PriceCalculator priceCalculator = new DefaultPriceCalculator(timeRepository);

    private PricingFacade pricingFacade = new PricingFacade(priceCalculator);

    @Test
    public void shouldReturn10PLNWhenOldMovieWasRentedFor5Days() {
        //given
        final User user = new User(1L, "Kowalski");
        final Movie movie = new Movie(0L, "Test", 150, LocalDate.of(2000, 01, 01));
        final LocalDate rentalDate = LocalDate.of(2019, 10, 10);
        final LocalDate returnDate = LocalDate.of(2019, 10, 15);
        final Rental rental = new Rental(user, movie, rentalDate, returnDate);
        final RentalPrice expectedPrice = new RentalPrice(10.00, Currency.PLN);
        when(timeRepository.getCurrentDate()).thenReturn(LocalDate.of(2019, 10, 15));


        //when
        RentalPrice rentalPrice = pricingFacade.movieWasRented(rental);

        //then
        assertEquals(expectedPrice, rentalPrice);
    }

    @Test
    public void shouldReturn20PLNWhenNewMovieWasRentedFor5Days() {
        //given
        final User user = new User(1L, "Kowalski");
        final Movie movie = new Movie(0L, "Test", 150, LocalDate.of(2019, 01, 01));
        final LocalDate rentalDate = LocalDate.of(2019, 10, 10);
        final LocalDate returnDate = LocalDate.of(2019, 10, 15);
        final Rental rental = new Rental(user, movie, rentalDate, returnDate);
        final RentalPrice expectedPrice = new RentalPrice(20.00, Currency.PLN);
        when(timeRepository.getCurrentDate()).thenReturn(LocalDate.of(2019, 10, 15));


        //when
        RentalPrice rentalPrice = pricingFacade.movieWasRented(rental);

        //then
        assertEquals(expectedPrice, rentalPrice);
    }
}