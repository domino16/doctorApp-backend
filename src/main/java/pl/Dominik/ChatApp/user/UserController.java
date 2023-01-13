package pl.Dominik.ChatApp.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials="true")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/visit/{email}")
    public ResponseEntity<User> addVisit(@PathVariable String email, @RequestBody Visits visit){
    User user = userRepository.findByEmail(email).orElseThrow();
    user.getVisits().add(visit);
    userRepository.save(user);
    return ResponseEntity.ok(user);
    }

    @GetMapping("/visit/{email}")
    public ResponseEntity<List<Visits>> readUserVisits(@PathVariable String email ){
        User user = userRepository.findByEmail(email).orElseThrow();
    return ResponseEntity.ok(user.visits);
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<User> getUser(@PathVariable String email){
        User user = userRepository.findByEmail(email).orElseThrow();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> user = userRepository.findAll();
        return ResponseEntity.ok(user);
    }

    @PatchMapping("/setvisitnotification/{email}")
    public ResponseEntity<User> updateVisitNotification(@PathVariable String email,@RequestBody int number){
        User user = userRepository.findByEmail(email).orElseThrow();
        user.setVisitNotificationsNumber(number);
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }



}
