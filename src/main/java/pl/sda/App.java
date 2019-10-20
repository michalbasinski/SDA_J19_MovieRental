package pl.sda;

import pl.sda.movies.model.Movie;
import pl.sda.points.calculators.DefaultPointsCalculator;
import pl.sda.points.PointsFacade;
import pl.sda.points.storage.InMemoryPointsRepository;
import pl.sda.pricing.calculators.DefaultPriceCalculator;
import pl.sda.rentals.Rental;
import pl.sda.pricing.PricingFacade;
import pl.sda.rentals.MovieRentalFacade;
import pl.sda.rentals.RentalSummary;
import pl.sda.time.TimeRepository;
import pl.sda.users.model.User;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        MovieRentalFacade facade = initFacade();

        User user = new User(1L, "Kowalski");
        Movie movie = new Movie(0L, "Test", 150, LocalDate.of(2019, 1, 1));
        Rental rental = new Rental(user, movie,
                LocalDate.of(2019, 10, 10),
                LocalDate.of(2019, 10, 20));

        RentalSummary summary = facade.rent(rental);
        System.out.println("Koszt: " + summary.getPrice().getValue() + " " + summary.getPrice().getCurrency());
        System.out.println(user.getName() + " posiada aktualnie " + summary.getCurrentPoints().getPoints() + " punktów");
    }

    private static MovieRentalFacade initFacade() {

        PricingFacade pricingFacade = new PricingFacade(new DefaultPriceCalculator(new TimeRepository()));

        PointsFacade pointsFacade = new PointsFacade(new InMemoryPointsRepository(), new DefaultPointsCalculator());

        return new MovieRentalFacade(pointsFacade, pricingFacade);

    }
}
