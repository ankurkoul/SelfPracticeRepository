package com.quiz.feesreportgenerator.utility.reader;

public class CSVTransactionInputReaderBuilder implements AbstractTransactionInputReaderBuilder {
	
	private static AbstractTransactionInputReader txInputReader = new CSVTransactionInputReader() ;

	
	public static AbstractTransactionInputReader createInstance(){
		return txInputReader;
		
	}
	

}
