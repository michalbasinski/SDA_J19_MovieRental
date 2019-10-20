package pl.sda.pricing;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RentalPrice {
    private Double value;
    private Currency currency;
}
