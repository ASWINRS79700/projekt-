package in.stackroute.ust.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public record CustomerDto(int id, String email,String name) {
}
