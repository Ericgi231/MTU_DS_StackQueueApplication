package cs2321;

import org.junit.Before;
import org.junit.Test;

public class InfixToPostfixTest {

	private String I;

	public InfixToPostfix init() {
		return new InfixToPostfix();
	}
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	@jug.TestName("addition converts correctly")
	public void testConvert1() {
		I = "4 + 2";
		org.junit.Assert.assertEquals("4 2 +",InfixToPostfix.convert(I));
	}
	
	@Test
	@jug.TestName("subtraction converts correctly")
	public void testConvert2() {
		I = "4 - 2";
		org.junit.Assert.assertEquals("4 2 -",InfixToPostfix.convert(I));
	}

	@Test
	@jug.TestName("multiplication converts correctly")
	public void testConvert3() {
		I = "4 * 2";
		org.junit.Assert.assertEquals("4 2 *",InfixToPostfix.convert(I));
	}
	
	@Test
	@jug.TestName("division converts correctly")
	public void testConvert4() {
		I = "4 / 2";
		org.junit.Assert.assertEquals("4 2 /",InfixToPostfix.convert(I));
	}
	
	@Test
	@jug.TestName("precedence of operators convert correctly")
	public void testConvert5() {
		I = "5 - 10 + 5 * 10 / 2";
		org.junit.Assert.assertEquals("5 10 - 5 10 * 2 / +",InfixToPostfix.convert(I));
	}
	
	@Test
	@jug.TestName("brackets convert correctly")
	public void testConvert6() {
		I = "18 + 2 * ( 10 - 5 * ( 2 + 20 ) / 2 )";
		org.junit.Assert.assertEquals("18 2 10 5 2 20 + * 2 / - * +",InfixToPostfix.convert(I));
	}
	
	@Test
	@jug.TestName("doubles convert correctly")
	public void testConvert7() {
		I = "5.50 - 10 + 5.25 * 10 / 2";
		org.junit.Assert.assertEquals("5.50 10 - 5.25 10 * 2 / +",InfixToPostfix.convert(I));
	}
	
	@Test
	@jug.TestName("large equation converts correctly")
	public void testConvert8() {
		I = "2 * 2 + 4 - 6 / ( 8 - 6 ) * 2 + 20";
		org.junit.Assert.assertEquals("2 2 * 4 + 6 8 6 - / 2 * - 20 +",InfixToPostfix.convert(I));
	}
	
	@Test
	@jug.TestName("EXTRA1: large equation converts correctly")
	public void testConvert9() {
		I = "-56 / 33 * -34 + 88 * -5 + 48 * -98 + -22 * -80";
		org.junit.Assert.assertEquals("-56 33 / -34 * 88 -5 * + 48 -98 * + -22 -80 * +",InfixToPostfix.convert(I));
	}
	
	@Test
	@jug.TestName("EXTRA2: large equation converts correctly")
	public void testConvert10() {
		I = "14 / 87 / 56 * 80 + 59 * 27 - -87 * 65 / -59";
		org.junit.Assert.assertEquals("14 87 / 56 / 80 * 59 27 * + -87 65 * -59 / -",InfixToPostfix.convert(I));
	}
	
	@Test
	@jug.TestName("EXTRA3: large equation converts correctly")
	public void testConvert11() {
		I = "-47 * 39 / -15 * 23 + -29 * -61 / -32 * 21";
		org.junit.Assert.assertEquals("-47 39 * -15 / 23 * -29 -61 * -32 / 21 * +",InfixToPostfix.convert(I));
	}
}
