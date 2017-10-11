package com.quiz.feesreportgenerator.domain;

import java.util.Date;

public class Transaction implements Comparable<Transaction>{

	private String transactionId;
	private String TransactionType;
	private Date transactionDate;
	private String marketValue;
	private String priority;
	private Client client;
	private double transactionFees;

	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionType() {
		return TransactionType;
	}
	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(String marketValue) {
		this.marketValue = marketValue;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@Override
	public int compareTo(Transaction other) {
		
		return this.transactionDate.compareTo(other.getTransactionDate());
	}
	public double getTransactionFees() {
		return transactionFees;
	}
	public void setTransactionFees(double transactionFees) {
		this.transactionFees = transactionFees;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", TransactionType=" + TransactionType
				+ ", transactionDate=" + transactionDate + ", marketValue=" + marketValue + ", priority=" + priority
				+ ", client=" + client + ", transactionFees=" + transactionFees + "]";
	}
	
	
	
	
	
}
