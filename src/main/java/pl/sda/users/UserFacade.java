package pl.sda.users;

import lombok.AllArgsConstructor;
import pl.sda.users.model.User;
import pl.sda.users.storage.UserRepository;

@AllArgsConstructor
public class UserFacade {

    private UserRepository userRepository;

    public User findUser(String name) {
        return userRepository.findUserByName(name);
    }
}
