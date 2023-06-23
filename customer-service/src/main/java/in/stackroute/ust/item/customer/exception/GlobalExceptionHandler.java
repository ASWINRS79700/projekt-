package in.stackroute.ust.item.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomerAlreadyExixt.class)

    public ResponseEntity<String> customerAlready(CustomerAlreadyExixt customerAlreadyExixt){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(customerAlreadyExixt.getMessage());
    }
    @ExceptionHandler(CustomerNotFound.class)
    public ResponseEntity<String> customerNot(CustomerNotFound customerNotFound){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customerNotFound.getMessage());
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> customerNot(IllegalArgumentException illegalArgumentException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(illegalArgumentException.getMessage());
    }
}
