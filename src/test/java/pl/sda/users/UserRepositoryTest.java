package pl.sda.users;

import org.junit.Assert;
import org.junit.Test;
import pl.sda.users.model.User;
import pl.sda.users.storage.InMemoryUserRepository;
import pl.sda.users.storage.UserRepository;

import static org.junit.Assert.*;

public class UserRepositoryTest {

    private UserRepository userRepository = new InMemoryUserRepository();

    @Test
    public void findUserByName() {
        //given
        final String name = "Kowalski";
        final Long expectedId = 0L;

        //when
        User result = userRepository.findUserByName(name);

        //then
        Assert.assertEquals(expectedId, result.getId());
    }

    @Test
    public void saveUser() {
        //given
        final User userToSave = new User(null, "Lewandowski");
        final Long expectedId = 3L;

        //when
        User savedUser = userRepository.saveUser(userToSave);

        //then
        assertEquals(expectedId, savedUser.getId());
    }
}