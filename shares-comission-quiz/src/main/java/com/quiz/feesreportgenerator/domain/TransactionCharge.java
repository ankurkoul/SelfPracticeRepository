package com.quiz.feesreportgenerator.domain;

public enum TransactionCharge {
	TEN(10), FIVE_HUNDREAD(500), FIFTY(50), HUNDREAD(100);

	double value;

	private TransactionCharge(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}
}
