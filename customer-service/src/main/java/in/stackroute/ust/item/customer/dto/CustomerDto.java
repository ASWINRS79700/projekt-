package in.stackroute.ust.item.customer.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public record CustomerDto(
        int id,

        @NotBlank @NotEmpty @Email String email, @NotBlank @NotEmpty String name
        ) {
//    public CustomerDto {
//    if (name == null) {
//        throw new IllegalArgumentException("Name cannot be null");
//    } else if (null==String.valueOf(id)) {
//        throw new IllegalArgumentException("id cannot be null");
//
//    } else if (email==null) {
//        throw new IllegalArgumentException("email cannot be null");
//
//    }
//    }
}
