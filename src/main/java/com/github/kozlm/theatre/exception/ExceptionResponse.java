package com.github.kozlm.theatre.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

public record ExceptionResponse(
        String message,
        HttpStatus status,
        LocalDateTime timestamp,
        String path,
        Throwable throwable
) {
}
