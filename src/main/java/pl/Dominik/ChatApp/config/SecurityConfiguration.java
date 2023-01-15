package pl.Dominik.ChatApp.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

//    @Autowired
//    @Qualifier("customAuthenticationEntryPoint")
//    AuthenticationEntryPoint authEntryPoint;

@Autowired
private JwtAuthenticationEntryPoint unauthorizedHandler;



    public SecurityConfiguration(JwtAuthenticationFilter jwtAuthFilter, AuthenticationProvider authenticationProvider) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.authenticationProvider = authenticationProvider;


    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
//
                .csrf()
                .disable()
                .authorizeHttpRequests()
//                .requestMatchers("/api/v1/auth/**")
                .requestMatchers("/**")
                .permitAll();
//                .anyRequest()
//                .authenticated()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
//                .and()
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


}
//@Component
//class CustomAccessDeniedHandler implements AccessDeniedHandler {
//
//    @Override
//    public void handle(HttpServletRequest request, HttpServletResponse response,
//                       AccessDeniedException exc) throws IOException {
//        response.addHeader("access_denied_reason", "not_authorized");
//        response.sendError(405, "Access Denied");
////        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"ndqiew");
//    }
//}

//@Component
//class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response,
//                         AuthenticationException authException) throws IOException {
//        response.addHeader("access_denied_reason", "authentication_required");
//        response.sendError(402, authException.getMessage());
//         = new ResponseEntity<>(authException.getMessage(),HttpStatus.BAD_REQUEST);
//    }
//}