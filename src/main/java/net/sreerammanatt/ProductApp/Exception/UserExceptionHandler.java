package net.sreerammanatt.ProductApp.Exception;


import lombok.extern.slf4j.Slf4j;
import net.sreerammanatt.ProductApp.Constants.ExceptionConstants;
import net.sreerammanatt.ProductApp.Enums.Exceptions;
import net.sreerammanatt.ProductApp.Utils.ExceptionUtils;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice()
@Slf4j
public class UserExceptionHandler {


    @ExceptionHandler(value = UserException.class)
    ResponseEntity<UserExceptionDto> processUserException(UserException e) {
        Exceptions exception =
                ExceptionUtils.
                        deCodeExceptionWithNumber(e.getExceptions()
                                .getExceptionNumber());
        UserExceptionDto exceptionDto = UserExceptionDto.builder()
                .message(exception.getMessage())
                .reason(Collections.singletonList(exception.getReason()))
                .httpStatus(exception.getStatus())
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        return new ResponseEntity<UserExceptionDto>(exceptionDto, exception.getStatus());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<UserExceptionDto> processInvalidArgument
            (MethodArgumentNotValidException e) {
        List<String> issues = e.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        UserExceptionDto exceptionDto = UserExceptionDto.builder()
                .message(ExceptionConstants.METHOD_VALIDATION_FAILED)
                .reason(issues)
                .httpStatus(HttpStatus.BAD_REQUEST)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();

        return new ResponseEntity<UserExceptionDto>(exceptionDto, HttpStatus.BAD_REQUEST);

    }
}
