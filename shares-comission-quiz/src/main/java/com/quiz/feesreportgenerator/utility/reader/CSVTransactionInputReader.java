package com.quiz.feesreportgenerator.utility.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.quiz.feesreportgenerator.domain.Client;
import com.quiz.feesreportgenerator.domain.Transaction;

public class CSVTransactionInputReader implements AbstractTransactionInputReader {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	private Properties properties = new Properties();
	private FileReader reader;
	private BufferedReader bfReader;
	String singleTx = null;
	Transaction transaction = null;
	String csvDelimeter;
	String fileLocation;

	public List<Transaction> readFile() {

		List<Transaction> transtionList = new ArrayList<>();

		try {
			bfReader=new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/feesReporter.properties")));
			properties.load(bfReader);
			csvDelimeter = properties.getProperty("csvFileDeliminiter");
			System.out.println(csvDelimeter);
			fileLocation = properties.getProperty("csvFileLocation");
			
			bfReader=new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileLocation)));
			bfReader.readLine();
			while ((singleTx = bfReader.readLine()) != null) {
				//bfReader.readLine();
				transaction = new Transaction();
				String[] txLine = singleTx.split(csvDelimeter);
				Client client = new Client();

				transaction.setTransactionId(txLine[0]);
				client.setClientId(txLine[1]);
				client.setSecurityId(txLine[2]);
				transaction.setClient(client);
				transaction.setTransactionType(txLine[3]);
			
				SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
			
				transaction.setTransactionDate(sdf.parse(txLine[4]));
				transaction.setMarketValue(txLine[5]);
				transaction.setPriority(txLine[6]);
				transtionList.add(transaction);
				
			}
			
			
		} catch (IOException | ParseException readingException) {
			
			logger.info(readingException.getMessage());
		}finally {
			try {
				if(bfReader!=null)
				bfReader.close();
				if(reader!=null)
				reader.close();
			} catch (IOException closeException) {
				logger.info(closeException.getMessage());
				
			}
		}
		return transtionList;

	}
}
