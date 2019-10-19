package pl.sda.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {

    private Long id;
    private String name;
    private String lastName;
    private int numberOfRentedMovies;
}

