package pl.sda.rentals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.sda.points.model.Points;
import pl.sda.pricing.RentalPrice;

@AllArgsConstructor
@Getter
public class RentalSummary {
    private RentalPrice price;
    private Points currentPoints;
}
