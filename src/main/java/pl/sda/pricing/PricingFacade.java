package pl.sda.pricing;

import pl.sda.rentals.Rental;

import java.time.LocalDate;
import java.time.Period;

public class PricingFacade {
    public RentalPrice movieWasRented(Rental rental) {
        LocalDate rentDate = rental.getRentDate();
        LocalDate returnDate = rental.getReturnDate();
        Period time = rentDate.until(returnDate);

        Period daysFromPremiere = rental.getMovie().getReleaseDate().until(LocalDate.now());

        Double multiplier = daysFromPremiere.getYears() * 365 <= 365 ? 2D : 1D;

        Double value = multiplier * (time.getDays() * 2.0D);
        return new RentalPrice(value, Currency.PLN);
    }
}
