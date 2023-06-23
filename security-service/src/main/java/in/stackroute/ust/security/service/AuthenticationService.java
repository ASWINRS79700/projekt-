package in.stackroute.ust.security.service;

import in.stackroute.ust.security.controller.dto.AuthenticationRequest;
import in.stackroute.ust.security.controller.dto.AuthenticationResponse;
import in.stackroute.ust.security.controller.dto.RegisterRequest;

public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
