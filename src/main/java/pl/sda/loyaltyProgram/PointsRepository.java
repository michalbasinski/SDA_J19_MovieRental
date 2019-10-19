package pl.sda.loyaltyProgram;

import lombok.Data;

import java.util.List;

@Data
public class PointsRepository {

    private Points points;
    private List<Points> pointsList;
    private Points currentPointId;

    public Points find(Points pointId) {
        for (Points point : pointsList) {
            if (point.equals(pointId)) {
                currentPointId = pointId;
            } else {
                System.out.println("Points not found");
                return null;
            }
        }
        return currentPointId;
    }

    public Points save(Points points) {
        return points;
    }
}
