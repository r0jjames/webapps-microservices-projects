package com.project.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @AllArgsConstructor
@Schema(
        name = "ErrorResponse",
        description = "Schema to hold error response information"
)
public class ErrorResponseDto {
    @Schema(
            description = "API path invoked by the client"
    )
    private String apiPath;

    @Schema(
            description = "Error code represents error happened"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "Error message represents error happened"
    )
    private String errorMsg;

    @Schema(
            description = "Time representing when the error happened"
    )
    private LocalDateTime errorTime;
}
