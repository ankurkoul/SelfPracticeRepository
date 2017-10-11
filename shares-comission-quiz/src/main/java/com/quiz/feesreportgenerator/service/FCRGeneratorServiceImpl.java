package com.quiz.feesreportgenerator.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.quiz.feesreportgenerator.dao.FCRGeneratorDAOImpl;
import com.quiz.feesreportgenerator.dao.FeesCalcaluteAndReportGeneratorDAO;
import com.quiz.feesreportgenerator.domain.Transaction;
import com.quiz.feesreportgenerator.utility.reader.CSVTransactionInputReader;

public class FCRGeneratorServiceImpl implements FeesCalcaluteAndReportGeneratorService {

	private List<Transaction> transactionList;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private FeesCalcaluteAndReportGeneratorDAO dao=new FCRGeneratorDAOImpl();

	@Override
	public void getTransactionList() {
		List<Transaction> tempTransactionList = new CSVTransactionInputReader().readFile();
		if(tempTransactionList.isEmpty()){
			transactionList = Collections.emptyList();
		}else{
			transactionList=new ArrayList<>();
			for (Transaction tx : tempTransactionList) {
				transactionList.add(calculateFees(tx));
			}
		}
	}

	
	//for mocking
	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}



	private Transaction calculateFees(Transaction transaction) {
	return	dao.calculateFees(transaction);
	
	}

	@Override
	public void generateReport() {
		dao.generateReport(transactionList);
		
	}
	
	
	

}
