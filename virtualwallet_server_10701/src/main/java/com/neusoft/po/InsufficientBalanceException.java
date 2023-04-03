package com.neusoft.po;

public class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(String massage) {
		super(massage);
	}

}
