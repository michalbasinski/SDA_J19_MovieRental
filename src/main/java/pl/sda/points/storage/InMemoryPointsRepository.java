package pl.sda.points.storage;

import pl.sda.points.model.Points;
import pl.sda.points.model.PointsNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryPointsRepository implements PointsRepository {
    private List<Points> userPoints = new ArrayList<>();

    private Long nextId;

    public InMemoryPointsRepository() {
        userPoints.add(new Points(1L, 1L, 10));
        nextId = Long.valueOf(userPoints.size());
    }

    @Override
    public Optional<Points> findUserPoints(Long userId) {
        return userPoints.stream().filter(userPoints -> userId.equals(userPoints.getUserId())).findFirst();
    }

    @Override
    public Points save(Points points) {
        points.setId(nextId++);
        userPoints.add(points);
        return points;
    }

    @Override
    public Points update(Points points) {
        Points pointsToUpdate = userPoints.stream()
                .filter(x -> points.getId().equals(x.getId()))
                .findFirst()
                .orElseThrow(() -> new PointsNotFoundException("Nie znaleziono punktów"));
        pointsToUpdate.setId(points.getId());
        pointsToUpdate.setPoints(points.getPoints());
        return pointsToUpdate;
    }
}
