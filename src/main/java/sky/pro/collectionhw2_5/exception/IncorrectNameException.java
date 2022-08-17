package sky.pro.collectionhw2_5.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class IncorrectNameException extends RuntimeException{
}
