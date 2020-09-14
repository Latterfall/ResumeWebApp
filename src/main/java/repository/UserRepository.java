package repository;

import model.User;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository {
    void addUser(User user);
    List<User> getAllUsers();
}
