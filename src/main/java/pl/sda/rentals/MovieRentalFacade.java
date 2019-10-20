package pl.sda.rentals;

import lombok.AllArgsConstructor;
import pl.sda.movies.model.Movie;
import pl.sda.points.model.Points;
import pl.sda.points.PointsFacade;
import pl.sda.pricing.PricingFacade;
import pl.sda.pricing.RentalPrice;

@AllArgsConstructor
public class MovieRentalFacade {
    private PointsFacade pointsFacade;
    private PricingFacade pricingFacade;

    public RentalSummary rent(Rental rental) {
        Points points = pointsFacade.movieWasRented(rental);
        RentalPrice rentalPrice = pricingFacade.movieWasRented(rental);

        return new RentalSummary(rentalPrice, points);
    }

    public Movie findMovie() {
        return null;
    }
}
