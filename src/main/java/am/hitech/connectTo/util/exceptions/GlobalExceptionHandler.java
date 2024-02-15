package am.hitech.connectTo.util.exceptions;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Component
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public void handleBadRequest(Exception e){
        System.out.println(e.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public void handleNotFound(NotFoundException e){
        System.out.println(e.getMessage());
    }
}
