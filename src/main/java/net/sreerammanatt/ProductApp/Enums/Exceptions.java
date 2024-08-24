package net.sreerammanatt.ProductApp.Enums;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum Exceptions {
    DUPLICATE_MAIL(1,HttpStatus.BAD_REQUEST, "mail id already present", "please try with new mail"),
    USER_NOT_FOUND(2,HttpStatus.BAD_REQUEST, "user not found", "please verify user");
   private final Integer exceptionNumber;


    private final HttpStatus status;

    private final String reason;

    private final String Message;


    Exceptions(Integer exceptionNumber, HttpStatus status, String reason, String message) {
        this.exceptionNumber = exceptionNumber;
        this.status = status;
        this.reason = reason;
        this.Message = message;
    }


}
