package br.dev.ferreiras.Exception;

public class NegocioException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7125468459054448304L;
	
	public NegocioException(String message) {
		super(message);
	}

}
