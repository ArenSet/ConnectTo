package am.hitech.connectTo.util.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@Component
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Data
    @AllArgsConstructor
    private static class ExceptionBody {
        private int status;
        private HttpStatus.Series series;
        private String error;
        private Date timestamp;
    }

    @ExceptionHandler(Exception.class)
    public void handleBadRequest(Exception e){
        System.out.println(e.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFound(NotFoundException e){
        return new ResponseEntity<>(new ExceptionBody(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.series(),
                e.getMessage(), new Date()), HttpStatus.NOT_FOUND);
    }


}
