package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@EnableTransactionManagement
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser() {
        User user = new User();
        userRepository.addUser(user);
    }

    public String getAllUsers() {
        List<User> allUsers = userRepository.getAllUsers();
        ObjectMapper objectMapper = new ObjectMapper();
        String allUsersAsJSONString = null;
        try {
            allUsersAsJSONString = objectMapper.writeValueAsString(allUsers);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return allUsersAsJSONString;
    }
}
