package pl.sda.points.storage;

import pl.sda.points.model.Points;

import java.util.Optional;

public interface PointsRepository {
    Optional<Points> findUserPoints(Long userId);

    Points save(Points points);

    Points update(Points points);
}
