package pl.sda.users.storage;

import pl.sda.users.model.User;
import pl.sda.users.model.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserRepository implements UserRepository {

    private List<User> users;

    private Long nextId;

    public InMemoryUserRepository() {
        this.users = new ArrayList<>();
        users.add(new User(0L, "Kowalski"));
        users.add(new User(1L, "Nowak"));
        users.add(new User(2L, "Kaczmarek"));
        nextId = Long.valueOf(users.size());
    }

    @Override
    public User findUserByName(String name) {
        return users.stream().filter(user -> name.equals(user.getName())).findFirst().orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public User saveUser(User user) {
        user.setId(nextId++);
        users.add(user);
        return user;
    }
}