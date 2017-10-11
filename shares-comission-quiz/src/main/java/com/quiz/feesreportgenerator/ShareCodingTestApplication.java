package com.quiz.feesreportgenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.quiz.feesreportgenerator.service.FCRGeneratorServiceImpl;
import com.quiz.feesreportgenerator.service.FeesCalcaluteAndReportGeneratorService;

@SpringBootApplication
public class ShareCodingTestApplication implements CommandLineRunner {

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(ShareCodingTestApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		FeesCalcaluteAndReportGeneratorService fcrService=new FCRGeneratorServiceImpl();
		fcrService.getTransactionList();
		
		fcrService.generateReport();
		
	}
}
