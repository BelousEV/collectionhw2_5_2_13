package sky.pro.collectionhw2_5.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (code = HttpStatus.BAD_REQUEST)

public class EmployeeAlreadyAddedException extends RuntimeException{

}
