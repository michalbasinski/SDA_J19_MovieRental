package pl.sda.points.calculators;

import pl.sda.rentals.Rental;

public interface PointsCalculator {
    Integer getPointsToAdd(Rental rental);
}
