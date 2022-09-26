package com.duocuc.turismoreal.exception;

import java.time.LocalDateTime;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ServiceException - Clase que contiene los atributos de error que se desea retornar
 */
public class ServiceException extends RuntimeException {

    private String code;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    private HashMap<String, String> errors;

    public ServiceException(String code, String message) {
		super(message);
		this.code = code;
		this.timestamp = LocalDateTime.now();

	}
	
	public ServiceException(String code, String message, HashMap<String,String> errors) {
		super(message);
		this.code = code;
		this.timestamp = LocalDateTime.now();
		this.errors = errors;

	}
	
	public String getCode() {
		return code;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public HashMap<String, String> getErrors() {
		return errors;
	}
    
}
