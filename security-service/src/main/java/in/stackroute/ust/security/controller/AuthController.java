package in.stackroute.ust.security.controller;

import in.stackroute.ust.security.controller.dto.AuthenticationRequest;
import in.stackroute.ust.security.controller.dto.AuthenticationResponse;
import in.stackroute.ust.security.controller.dto.RegisterRequest;
import in.stackroute.ust.security.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.getNameById(id));
    }
}
