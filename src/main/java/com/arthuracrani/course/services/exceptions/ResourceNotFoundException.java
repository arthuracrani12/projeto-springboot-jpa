package com.arthuracrani.course.services.exceptions;

//extends runtimeexception pois é uma excessão que o compilador não obriga a tratar
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	//construtor do objeto que tentei procurar e não encontrei
	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id " + id);
	}
}