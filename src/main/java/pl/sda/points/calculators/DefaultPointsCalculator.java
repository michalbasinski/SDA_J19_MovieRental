package pl.sda.points.calculators;

import pl.sda.rentals.Rental;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DefaultPointsCalculator implements PointsCalculator {

    @Override
    public Integer getPointsToAdd(Rental rental) {
        LocalDate rentDate = rental.getRentDate();
        LocalDate returnDate = rental.getReturnDate();

        long days = rentDate.until(returnDate, ChronoUnit.DAYS);
        return days <= 2 ? 3 : 1;
    }
}