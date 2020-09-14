package controllers.REST;

import org.springframework.web.bind.annotation.PostMapping;
import repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.UserService;

@RestController
@RequestMapping(path = "/test")
public class TestREST {
    private UserService userService;

    @Autowired
    public void setUserRepository(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<String> getTestEntity() {
        return new ResponseEntity<>(userService.getAllUsers().toString(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addRandomUser() {
        userService.addUser();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
