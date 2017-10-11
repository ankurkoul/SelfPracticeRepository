package com.quiz.feesreportgenerator.dao;

import java.util.List;

import com.quiz.feesreportgenerator.domain.Transaction;

public interface FeesCalcaluteAndReportGeneratorDAO {
  
	
	public Transaction calculateFees(Transaction transaction);
	public void generateReport(List<Transaction>transactionList) ;
	public List<Transaction>   setTransactionList( List<Transaction> tempTransactionList);
}
