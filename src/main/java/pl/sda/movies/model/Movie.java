package pl.sda.movies.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie {
    private Long id;
    private String title;
    private int time;
    private LocalDate releaseDate;
}
