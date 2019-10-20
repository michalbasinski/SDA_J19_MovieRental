package pl.sda.pricing;

import lombok.AllArgsConstructor;
import pl.sda.pricing.calculators.PriceCalculator;
import pl.sda.rentals.Rental;

@AllArgsConstructor
public class PricingFacade {

    private PriceCalculator priceCalculator;

    public RentalPrice movieWasRented(Rental rental) {
        return priceCalculator.getRentPrice(rental);
    }

}
