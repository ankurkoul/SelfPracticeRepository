package com.quiz.feesreportgenerator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.quiz.feesreportgenerator.dao.FCRGeneratorDAOImpl;
import com.quiz.feesreportgenerator.domain.Client;
import com.quiz.feesreportgenerator.domain.Transaction;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ShareCodingTestApplicationTests extends FCRJunitTester{
	FCRGeneratorDAOImpl daoMock;
	Transaction txMock,txMock2,txMock3;
	Client clientMock,clientMock2,clientMock3;
	 List<Transaction> mockTransactionList;
	 List<Transaction> mockTransactionList2;
@Before
public void setup(){
	daoMock=Mockito.mock(FCRGeneratorDAOImpl.class);
	txMock=Mockito.mock( Transaction.class);
	clientMock=Mockito.mock( Client.class);
	mockTransactionList=Mockito.mock(ArrayList.class);

	
}

@Test
public void testTransactionListIsNull( ){
	assertNull(daoMock.calculateFees(null));
}


@Test
 public void testTransactionListIsEmpty( ) {
	
	mockTransactionList2=Collections.emptyList();
	assertEquals(daoMock.setTransactionList(mockTransactionList).size(),0);
	

	}
}
