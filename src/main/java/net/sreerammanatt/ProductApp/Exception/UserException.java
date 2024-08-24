package net.sreerammanatt.ProductApp.Exception;

import lombok.Data;
import net.sreerammanatt.ProductApp.Enums.Exceptions;

@Data
public class UserException extends RuntimeException {
    private Exceptions exceptions;

    public UserException(Exceptions e) {
        super(e.getMessage());
        this.exceptions = e;

    }
}
