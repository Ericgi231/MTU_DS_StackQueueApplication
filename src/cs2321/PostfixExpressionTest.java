package cs2321;

import org.junit.Before;
import org.junit.Test;

public class PostfixExpressionTest {

	private String expression;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	@jug.TestName("addition evaluates correctly")
	public void testEvaluate1() {
		expression = "1 2 +";
		org.junit.Assert.assertEquals(3,PostfixExpression.evaluate(expression));
	}
	
	@Test
	@jug.TestName("subtraction evaluates correctly")
	public void testEvaluate2() {
		expression = "1 2 -";
		org.junit.Assert.assertEquals(-1,PostfixExpression.evaluate(expression));
	}
	
	@Test
	@jug.TestName("multiplication evaluates correctly")
	public void testEvaluate3() {
		expression = "5 5 *";
		org.junit.Assert.assertEquals(25,PostfixExpression.evaluate(expression));
	}
	
	@Test
	@jug.TestName("division evaluates correctly")
	public void testEvaluate4() {
		expression = "10 2 /";
		org.junit.Assert.assertEquals(5,PostfixExpression.evaluate(expression));
	}
	
	@Test
	@jug.TestName("numbers are evaluated in correct order")
	public void testEvaluate5() {
		expression = "0 1 /";
		org.junit.Assert.assertEquals(0,PostfixExpression.evaluate(expression));
	}
	
	@Test
	@jug.TestName("all 0 is evaluated correctly")
	public void testEvaluate6() {
		expression = "0 0 0 0 + - *";
		org.junit.Assert.assertEquals(0,PostfixExpression.evaluate(expression));
	}
	
	@Test
	@jug.TestName("multiple operators touching evaluates correctly")
	public void testEvaluate7() {
		expression = "5 100 5 4 6 + * / -";
		org.junit.Assert.assertEquals(3,PostfixExpression.evaluate(expression));
	}
	
	@Test
	@jug.TestName("multiple operators split evaluates correctly")
	public void testEvaluate8() {
		expression = "10 10 + 2 * 2 +";
		org.junit.Assert.assertEquals(42,PostfixExpression.evaluate(expression));
	}

}
