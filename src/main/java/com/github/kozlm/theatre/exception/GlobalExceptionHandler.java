package com.github.kozlm.theatre.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.sql.SQLException;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<Object> handleSQLException(HttpServletRequest request, SQLException e){
        ExceptionResponse response = new ExceptionResponse(
                "SQL Exception occurred: " + e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                LocalDateTime.now(),
                request.getRequestURI(),
                e
        );
        return new ResponseEntity<>(
                response,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleBadRequest(HttpServletRequest request, MethodArgumentNotValidException e){
        ExceptionResponse response = new ExceptionResponse(
                "Invalid request: " + e.getMessage(),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now(),
                request.getRequestURI(),
                e
        );
        return new ResponseEntity<>(
                response,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(
            HttpServletRequest request,
            IllegalArgumentException e
    ){
        ExceptionResponse response = new ExceptionResponse(
                "Illegal argument: " + e.getMessage(),
                HttpStatus.NOT_FOUND,
                LocalDateTime.now(),
                request.getRequestURI(),
                e
        );
        return new ResponseEntity<>(
                response,
                HttpStatus.NOT_FOUND);
    }

    // todo JWT exceptions
}
