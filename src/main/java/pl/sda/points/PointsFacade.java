package pl.sda.points;

import lombok.AllArgsConstructor;
import pl.sda.points.model.Points;
import pl.sda.points.storage.PointsRepository;
import pl.sda.rentals.Rental;
import pl.sda.users.model.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@AllArgsConstructor
public class PointsFacade {
    private PointsRepository pointsRepository;

    public Points movieWasRented(Rental rental) {
        Integer pointsToAdd = getPointsToAdd(rental);
        return addPoints(rental.getUser(), pointsToAdd);
    }

    private Integer getPointsToAdd(Rental rental) {
        LocalDate rentDate = rental.getRentDate();
        LocalDate returnDate = rental.getReturnDate();

        long days = rentDate.until(returnDate, ChronoUnit.DAYS);
        return days <= 2 ? 3 : 1;
    }

    private Points addPoints(User user, Integer pointsToAdd) {
        Optional<Points> currentUserPoints = pointsRepository.findUserPoints(user.getId());

        Points entryForUser;
        if (currentUserPoints.isPresent()) {
            entryForUser = currentUserPoints.get();
            entryForUser.pointsWereAdded(pointsToAdd);
            pointsRepository.update(entryForUser);

        } else {
            entryForUser = new Points(null, user.getId(), pointsToAdd);
            entryForUser = pointsRepository.save(entryForUser);
        }

        return entryForUser;
    }
}
