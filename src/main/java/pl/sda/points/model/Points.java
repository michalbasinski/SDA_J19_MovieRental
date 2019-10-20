package pl.sda.points.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Points {
    @Setter
    private Long id;
    private Long userId;

    @Setter
    private Integer points;

    public Points pointsWereAdded(Integer pointsToAdd) {
        points += pointsToAdd;
        return this;
    }
}
