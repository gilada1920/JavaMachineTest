package com.NimapCrud.task.CustomException;

public class ObjectNotFoundException extends RuntimeException {
	
	public ObjectNotFoundException(String message) {
		super(message);
	}
}
