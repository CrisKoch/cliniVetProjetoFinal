package com.kochmann.controller.exception;

public class AnimalNaoEncontradoException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AnimalNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	
}
