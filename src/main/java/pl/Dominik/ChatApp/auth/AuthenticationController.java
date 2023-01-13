package pl.Dominik.ChatApp.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.Dominik.ChatApp.user.UserRepository;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials="true")
public class AuthenticationController {

    private final AuthenticationService service;
    private final UserRepository repository;

    public AuthenticationController(AuthenticationService service, UserRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody RegisterRequest request) {
        try {
            return ResponseEntity.ok(service.register(request));
        }catch (ResponseStatusException e){
            return ResponseEntity.badRequest().body(e.getReason());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate (
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }



    }

