package kr.or.ddit.sum;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalucalationLogicTest {
	
	
	//1~10까지의 합
	@Test
	public void sumBetweenTwoNumbers() {
		CalculationLogic logic =  new CalculationLogic();
		int start = 1;
		int end = 10;
		int sum = logic.sumBetweenTwoNumbers(start, end);
		
		assertEquals(55, sum);
	}
	
	
	@Test
	public void sumBetweenTwoNumbers2() {
		CalculationLogic logic =  new CalculationLogic();
		int start = 3;
		int end = 12;
		int sum = logic.sumBetweenTwoNumbers(start, end);
		
		assertEquals(75, sum);
	}
}
