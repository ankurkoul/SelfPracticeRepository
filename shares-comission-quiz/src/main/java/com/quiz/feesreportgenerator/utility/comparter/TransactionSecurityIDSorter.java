package com.quiz.feesreportgenerator.utility.comparter;

import java.util.Comparator;

import com.quiz.feesreportgenerator.domain.Client;
import com.quiz.feesreportgenerator.domain.Transaction;

public class TransactionSecurityIDSorter implements Comparator<Transaction>{

	@Override
	public int compare(Transaction before, Transaction after) {
		// TODO Auto-generated method stub
	Client beforeClient=	before.getClient();
	Client afterClient=	after.getClient();
		return beforeClient.getSecurityId().compareTo(afterClient.getSecurityId());
	}

}
