package com.quiz.feesreportgenerator.utility.reader;

import java.util.List;

import com.quiz.feesreportgenerator.domain.Transaction;

public interface AbstractTransactionInputReader {
	 List<Transaction> readFile();
	
}
