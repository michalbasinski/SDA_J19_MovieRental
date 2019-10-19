package pl.sda.User;

public class UserFacade {

    private  User user;

    public void create(User user){};
    public void delete(Long id){};
    public void update(User user){};
    public User find(String id,String name, String lastName, int numberOfRentedMovies){return user;}
}
