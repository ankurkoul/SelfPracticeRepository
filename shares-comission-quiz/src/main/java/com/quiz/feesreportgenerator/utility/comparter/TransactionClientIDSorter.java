package com.quiz.feesreportgenerator.utility.comparter;

import java.util.Comparator;

import com.quiz.feesreportgenerator.domain.Client;
import com.quiz.feesreportgenerator.domain.Transaction;

public class TransactionClientIDSorter implements Comparator<Transaction>{

	@Override
	public int compare(Transaction before, Transaction after) {
		Client beforeClient=	before.getClient();
		Client afterClient=	after.getClient();
			return beforeClient.getClientId().compareTo(afterClient.getClientId());
		}
	

}
