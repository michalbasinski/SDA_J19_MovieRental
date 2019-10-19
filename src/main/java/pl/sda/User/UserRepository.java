package pl.sda.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {

   
    private List<User> userslist = new ArrayList<>();

    public UserRepository() {

        userslist.add(new User(0L, "Jan", "Nowak", 3));
        userslist.add(new User(1L, "Marek", "Kowalski", 10));
        userslist.add(new User(2L, "Aleksandra", "Adamiak", 5));
        userslist.add(new User(3L, "Tomasz", "Kaczmarek", 11));
        userslist.add(new User(4L, "Agnieszka", "Wiśniewska", 4));
        userslist.add(new User(5L, "Jan", "Nowak", 3));
        userslist.add(new User(6L, "Mateusz", "Kowalski", 1));
        userslist.add(new User(7L, "Magda", "Nowak", 24));
        userslist.add(new User(8L, "Stefan", "Kaczmarek", 18));
        userslist.add(new User(9L, "Andrzej", "Duda", 8));
    }


    public User save(Movie movie) {
        return user;
    }

    public void delete(User user) {
    }



    public User update(User user) {
        return user;
    }

    public User findById(Long id) {
        return userslist.stream().filter(x->id.equals(x.getId())).findFirst().get();

    }

}


