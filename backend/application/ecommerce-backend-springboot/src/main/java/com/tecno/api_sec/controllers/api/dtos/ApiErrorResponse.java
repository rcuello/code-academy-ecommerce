package com.tecno.api_sec.controllers.api.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * DTO que representa una respuesta de error de la API.
 * Contiene información detallada sobre el error, como el mensaje, el código HTTP,
 * los detalles del error y la fecha y hora en que ocurrió el error.
 */
public class ApiErrorResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Mensaje de error descriptivo.
     */
    private String message;

    /**
     * Código de estado HTTP asociado al error.
     */
    private int httpStatus;

    /**
     * Detalles del error, como la traza de la pila (stack trace).
     */
    private String errorDetails;

    /**
     * Fecha y hora en que ocurrió el error.
     */
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime timestamp;

    private String url;
    private String method;

    // Getters y Setters

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}