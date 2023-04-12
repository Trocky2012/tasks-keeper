package com.starengtech.tasksKeeper.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException (Long id) {
		super("Resource not found. ID "+id);
	}
	public ResourceNotFoundException (String pssd) {
		super("Password not found. PSSD "+pssd);
	}

}
