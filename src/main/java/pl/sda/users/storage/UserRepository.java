package pl.sda.users.storage;

import pl.sda.users.model.User;

public interface UserRepository {
    User findUserByName(String name);

    User saveUser(User user);
}
