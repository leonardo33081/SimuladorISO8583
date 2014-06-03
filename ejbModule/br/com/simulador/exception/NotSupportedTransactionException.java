package br.com.simulador.exception;

public class NotSupportedTransactionException extends Exception {

	private static final long serialVersionUID = -4895536667352508018L;
	
	
	public NotSupportedTransactionException(String message) {
		super("Erro:" + message);
	}
	

}
