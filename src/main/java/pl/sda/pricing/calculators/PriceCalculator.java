package pl.sda.pricing.calculators;

import pl.sda.pricing.RentalPrice;
import pl.sda.rentals.Rental;

public interface PriceCalculator {
    RentalPrice getRentPrice(Rental rental);
}
