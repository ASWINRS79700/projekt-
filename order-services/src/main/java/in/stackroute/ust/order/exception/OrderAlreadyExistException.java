package in.stackroute.ust.order.exception;

public class OrderAlreadyExistException extends RuntimeException{
    public OrderAlreadyExistException(String s){
        super(s);
    }
}
