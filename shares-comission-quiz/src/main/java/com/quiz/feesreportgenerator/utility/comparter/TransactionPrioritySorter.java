package com.quiz.feesreportgenerator.utility.comparter;

import java.util.Comparator;

import com.quiz.feesreportgenerator.domain.Transaction;

public class TransactionPrioritySorter implements Comparator<Transaction>{

	@Override
	public int compare(Transaction before, Transaction after) {
		
		if(before.getPriority().equalsIgnoreCase("Y") && after.getPriority().equalsIgnoreCase("N")){
			return -1;
		}
		if(before.getPriority().equalsIgnoreCase("N") && after.getPriority().equalsIgnoreCase("Y")){
			return 1;
		}
		return 0;
	}

}
