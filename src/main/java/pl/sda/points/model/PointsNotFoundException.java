package pl.sda.points.model;

public class PointsNotFoundException extends RuntimeException {
    public PointsNotFoundException(String msg) {
        super(msg);
    }
}
