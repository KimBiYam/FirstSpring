package org.zerock.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.zerock.calculator.Calculator;

public class CalculateoTest {

	@Test
	public void testSum() {
		Calculator cal = new Calculator();
		assertEquals(30, cal.sum(20, 10));
		System.out.println("test1");

	}

	@Test
	public void testSum1() {
		Calculator cal = new Calculator();
		assertEquals(60, cal.sum(50, 10));
		System.out.println("test2");

	}	
	
//	가장 먼저 실행
	@BeforeClass
	public static void beforeTest() {
		System.out.println("BeforeClass");
	}
//  가장 마지막에 실행
	@AfterClass
	public static void afterTest() {
		System.out.println("AfterClass");
	}
//	테스트 전 실행
	@Before
	public void setUp() {
		System.out.println("Before setUp");
	}
//	테스트 후 실행
	@After
	public void tearDown() {
		System.out.println("After tearDown");
	}

}
