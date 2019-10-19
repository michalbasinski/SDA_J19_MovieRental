package pl.sda.loyaltyProgram;

public class PointsRepository {

    private Points points;

    public PointsRepository(Points points) {
        this.points = points;
    }

    public Points save(Points points) {
        return points;
    }
}
