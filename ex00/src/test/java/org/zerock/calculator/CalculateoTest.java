package org.zerock.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.zerock.calculator.Calculator;

public class CalculateoTest {

	@Test
	public void testSum() {
		Calculator cal = new Calculator();
		assertEquals(30, cal.sum(20,10));
		System.out.println("test1");
		
	}
	@Test
	public void testSum1() {
		Calculator cal = new Calculator();
		assertEquals(60, cal.sum(50,10));
		System.out.println("test2");
		
	}
}
