package net.sreerammanatt.ProductApp.Exception;


import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class UserExceptionDto {
    String message;

    HttpStatus httpStatus;

    List<String> reason;

    Timestamp timestamp;
}
