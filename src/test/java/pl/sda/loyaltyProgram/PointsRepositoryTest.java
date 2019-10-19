package pl.sda.loyaltyProgram;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PointsRepositoryTest {

    private List<Points> pointsList;
    private Points points;

    @Test
    public void shouldReturnFoundPoints() {
        //given
        PointsRepository pointsRepository = new PointsRepository();
        pointsList.add(0, points);
        pointsList.add(1, points);
        pointsList.add(2, points);
        pointsList.add(3, points);

        //when
        Points expected = pointsRepository.find(this.points);

        //then


    }
}