package com.quiz.feesreportgenerator.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.quiz.feesreportgenerator.domain.Transaction;
import com.quiz.feesreportgenerator.domain.TransactionCharge;
import com.quiz.feesreportgenerator.domain.TransactionType;
import com.quiz.feesreportgenerator.utility.comparter.TransactionClientIDSorter;
import com.quiz.feesreportgenerator.utility.comparter.TransactionDateSorter;
import com.quiz.feesreportgenerator.utility.comparter.TransactionPrioritySorter;
import com.quiz.feesreportgenerator.utility.comparter.TransactionTypeSorter;

public class FCRGeneratorDAOImpl implements FeesCalcaluteAndReportGeneratorDAO {
	private List<Transaction> transactionList = new ArrayList<>();
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<Transaction> setTransactionList(List<Transaction> tempTransactionList) {
		if (tempTransactionList.isEmpty()) {

			transactionList = Collections.emptyList();
			return tempTransactionList;
		} else {

			for (Transaction tx : tempTransactionList) {
				transactionList.add(calculateFees(tx));
			}

			return transactionList;
		}

	}

	@Override
	public Transaction calculateFees(Transaction transaction) {
		if (transaction == null) {
			return null;

		} else {
			if (isIntraDayTransaction(transaction)) {
				transaction.setTransactionFees(TransactionCharge.TEN.getValue());
			} else {
				if (transaction.getPriority().equalsIgnoreCase("Y")) {
					transaction.setTransactionFees(TransactionCharge.FIVE_HUNDREAD.getValue());
				} else {
					if (transaction.getTransactionType().equalsIgnoreCase(TransactionType.SELL.getType())
							|| transaction.getTransactionType().equalsIgnoreCase(TransactionType.WITHDRAW.getType())) {
						transaction.setTransactionFees(TransactionCharge.HUNDREAD.getValue());

					} else if (transaction.getTransactionType().equalsIgnoreCase(TransactionType.BUY.getType())
							|| transaction.getTransactionType().equalsIgnoreCase(TransactionType.DEPOSIT.getType())) {

						transaction.setTransactionFees(TransactionCharge.FIFTY.getValue());
					}
				}
			}
			return transaction;
		}

	}

	private boolean isIntraDayTransaction(Transaction transaction) {
		boolean isIntraDay = false;
		Transaction localTransaction = null;
		if (!transactionList.isEmpty()) {
			/*
			 * compare other tx with current
			 */
			for (Transaction tempTx : transactionList) {
				if (tempTx.getClient().getClientId().equals(transaction.getClient().getClientId())

						&& tempTx.getClient().getSecurityId().equals(transaction.getClient().getSecurityId())
						&& tempTx.getTransactionDate().equals(transaction.getTransactionDate())) {
					if (tempTx.getTransactionType().equals(TransactionType.BUY.getType())
							&& transaction.getTransactionType().equals(TransactionType.SELL.getType())
							|| (tempTx.getTransactionType().equals(TransactionType.SELL.getType())
									&& transaction.getTransactionType().equals(TransactionType.BUY.getType()))) {
						isIntraDay = true;
						localTransaction = tempTx;
						break;
					}

				}
			}
			if (localTransaction != null) {
				/*
				 * make both tx fees as equal 10 since both will be intra day
				 * 
				 * hence other tx will be readded to list after adding 10
				 * and isIntra Day flag set 10 for current tx also
				 */
				transactionList.remove(localTransaction);
				localTransaction.setTransactionFees(TransactionCharge.TEN.getValue());
				transactionList.add(localTransaction);
			}
		} else {
			isIntraDay = false;
		}
		return isIntraDay;
	}

	@Override
	public void generateReport(List<Transaction> transactionList) {
		logger.info("=======================================================");

		logger.info("CLIENT ID| TRANSACTIONtYPE|TRANSACTION DATE | PRIORITY|PROCESSING FEES||");

		showUnsortedData(transactionList);
		sortByClientID(transactionList);
		sortByPriority(transactionList);
		sortByDate(transactionList);
		sortByType(transactionList);
	}

	private void sortByType(List<Transaction> transactionList) {
		logger.info("===========SORTEd by Type============================================");
		Collections.sort(transactionList, new TransactionTypeSorter());
		showUnsortedData(transactionList);
	}

	private void sortByDate(List<Transaction> transactionList) {
		logger.info("===========SORTEd by DATE============================================");
		Collections.sort(transactionList, new TransactionDateSorter());
		showUnsortedData(transactionList);
	}

	private void sortByPriority(List<Transaction> transactionList) {
		logger.info("===========SORTEd by Priority============================================");
		Collections.sort(transactionList, new TransactionPrioritySorter());
		showUnsortedData(transactionList);
	}

	private void sortByClientID(List<Transaction> transactionList) {
		logger.info("===========SORTEd by CLIENT ID============================================");
		Collections.sort(transactionList, new TransactionClientIDSorter());
		showUnsortedData(transactionList);
	}

	private void showUnsortedData(List<Transaction> transactionList) {
		for (Transaction transaction : transactionList) {
			logger.info("---------------------------------------------------------------------------");
			logger.info(transaction.getClient().getClientId() + "\t" + transaction.getTransactionType() + "\t"
					+ transaction.getTransactionDate() + "\t" + transaction.getPriority() + "\t"
					+ transaction.getTransactionFees());
		}
	}

}
