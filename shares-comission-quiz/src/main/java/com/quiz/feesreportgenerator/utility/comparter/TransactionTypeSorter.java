package com.quiz.feesreportgenerator.utility.comparter;

import java.util.Comparator;

import com.quiz.feesreportgenerator.domain.Transaction;

public class TransactionTypeSorter implements Comparator<Transaction>{

	@Override
	public int compare(Transaction before, Transaction after) {
		// TODO Auto-generated method stub
		return before.getTransactionType().compareTo(after.getTransactionType());
	}

}
