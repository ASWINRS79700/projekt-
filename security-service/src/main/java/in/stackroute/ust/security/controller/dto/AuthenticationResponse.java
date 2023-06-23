package in.stackroute.ust.security.controller.dto;

import in.stackroute.ust.security.domain.User;

public record AuthenticationResponse(String token, User user) {
}
