package com.capgemini.wallet.exception;

public class InsufficientBalanceException extends RuntimeException{

	public InsufficientBalanceException(String msg) {
		super(msg);
	}

	public InsufficientBalanceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsufficientBalanceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public InsufficientBalanceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public InsufficientBalanceException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
}
