package in.stackroute.ust.security.service;

import in.stackroute.ust.security.controller.dto.AuthenticationRequest;
import in.stackroute.ust.security.controller.dto.AuthenticationResponse;
import in.stackroute.ust.security.controller.dto.RegisterRequest;
import in.stackroute.ust.security.domain.Role;
import in.stackroute.ust.security.domain.User;
import in.stackroute.ust.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class AutheticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        log.warn("register");
        var user = User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(request.role().equalsIgnoreCase("user") ? Role.USER : Role.ADMIN)
                .build();
        userRepository.save(user);
        var token = jwtService.generateToken(Map.of("roles", user.getRole()), user);
        return new AuthenticationResponse(token,user);
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        log.warn("autheticate");
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        var user = userRepository.findByEmail(request.email()).orElseThrow();
        var authorities = user.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority).collect(Collectors.joining(""));
        return new AuthenticationResponse(jwtService.generateToken(Map.of("roles", authorities),user),user);
    }

    @Override
    public String getNameById(int id) {
        return userRepository.findById(id).get().getFirstName();
    }
}
