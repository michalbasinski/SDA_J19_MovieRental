package pl.sda.pricing.calculators;

import lombok.AllArgsConstructor;
import pl.sda.pricing.Currency;
import pl.sda.pricing.RentalPrice;
import pl.sda.rentals.Rental;
import pl.sda.time.TimeRepository;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class DefaultPriceCalculator implements PriceCalculator {

    private static final double PRICE_PER_DAY = 2.0D;

    private TimeRepository timeRepository;

    @Override
    public RentalPrice getRentPrice(Rental rental) {
        final LocalDate rentDate = rental.getRentDate();
        final LocalDate returnDate = rental.getReturnDate();
        final long rentDurationInDays = rentDate.until(returnDate, ChronoUnit.DAYS);
        final Period daysFromPremiere = rental.getMovie().getReleaseDate().until(timeRepository.getCurrentDate());

        Double multiplier = daysFromPremiere.getYears() * 365 <= 365 ? 2D : 1D;

        Double value = multiplier * (rentDurationInDays * PRICE_PER_DAY);
        return new RentalPrice(value, Currency.PLN);
    }
}