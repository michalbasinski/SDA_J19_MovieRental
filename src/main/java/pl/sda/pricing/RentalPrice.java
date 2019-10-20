package pl.sda.pricing;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class RentalPrice {
    private Double value;
    private Currency currency;
}
