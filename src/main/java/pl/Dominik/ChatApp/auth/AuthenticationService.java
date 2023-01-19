package pl.Dominik.ChatApp.auth;


import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.Dominik.ChatApp.config.JwtService;
import pl.Dominik.ChatApp.user.User;
import pl.Dominik.ChatApp.user.UserRepository;

@Service
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(RegisterRequest request) {

        if(repository.findByEmail(request.getEmail()).isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "EMAIL_EXISTS");
        }
        User user = new User(request.getEmail(), passwordEncoder.encode(request.getPassword()),request.getFirstName(),request.getLastName(),request.getPhotoUrl(), request.isDoctor(),request.getVisitNotificationsNumber());
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken, request.getEmail(),"3600");

    }

    public AuthenticationResponse authenticate(AuthenticationRequest request)throws ResponseStatusException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = repository.findByEmail(request.getEmail())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"users not found"));
        var jwtToken = jwtService.generateToken(user);

        AuthenticationResponse response = new AuthenticationResponse(jwtToken, request.getEmail(),"3600");
        return response;
    }
}
