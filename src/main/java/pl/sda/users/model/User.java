package pl.sda.users.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class User {
    @Setter
    private Long id;
    private String name;
}
