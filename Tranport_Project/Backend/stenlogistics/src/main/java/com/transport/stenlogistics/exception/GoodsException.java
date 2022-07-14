package com.transport.stenlogistics.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;


@Data
@Component
@NoArgsConstructor
public class GoodsException extends RuntimeException{
    private String date;
    private String errorCode;
    private String errorMessage;
    private String urlDescription;
    private String message;

    public GoodsException(String date, String errorCode, String errorMessage) {
        super(errorMessage);
        this.date = date;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.message = errorMessage;
    }

    public GoodsException(String date, String errorCode, String errorMessage, String urlDescription) {
        super(errorMessage);
        this.date = date;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.message = errorMessage;
        this.urlDescription = urlDescription;
    }
}
