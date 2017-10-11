package com.quiz.feesreportgenerator.domain;

public enum TransactionType {
	BUY("BUY"), SELL("SELL"), WITHDRAW("WITHDRAW"), DEPOSIT("DEPOSIT");
	String type;

	private TransactionType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
