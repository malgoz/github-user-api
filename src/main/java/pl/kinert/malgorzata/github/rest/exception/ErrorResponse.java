package pl.kinert.malgorzata.github.rest.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ErrorResponse {
    private String message;
    private int statusCode;
}
