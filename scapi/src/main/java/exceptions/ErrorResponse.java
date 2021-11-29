package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ErrorResponse extends RuntimeException
{
    public ErrorResponse(String exception) 
    {
        super(exception);
    }
}