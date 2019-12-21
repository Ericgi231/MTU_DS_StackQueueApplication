package cs2321;

import org.junit.Before;
import org.junit.Test;

public class JosephusTest {

	private Josephus game = init();
	private String[] people = new String[6];

	public Josephus init() {
		return new Josephus();
	}
	
	@Before
	public void setUp() throws Exception {
		people[0] = "Alice";
		people[1] = "Bob";
		people[2] = "Cindy";
		people[3] = "Doug";
		people[4] = "Ed";
		people[5] = "Fred";
	}

	@Test
	@jug.TestName("number between 0 and array.size gives correct answer")
	public void testOrder1() {
		org.junit.Assert.assertEquals("Ed",game.order(people,2).last().getElement());
	}

	@Test
	@jug.TestName("number 1 returns last name in array")
	public void testOrder2() {
		org.junit.Assert.assertEquals("Fred",game.order(people,1).last().getElement());
	}

	@Test
	@jug.TestName("number greater than array size returns correct answer")
	public void testOrder3() {
		org.junit.Assert.assertEquals("Cindy",game.order(people,8).last().getElement());
	}

	@Test
	@jug.TestName("number equal to array.size returns correct answer")
	public void testOrder4() {
		org.junit.Assert.assertEquals("Doug",game.order(people,6).last().getElement());
	}
	
	@Test
	@jug.TestName("Extra number between 0 and array.size gives correct answer")
	public void testOrder5() {
		org.junit.Assert.assertEquals("Alice",game.order(people,3).last().getElement());
	}
	
	@Test
	@jug.TestName("Extra number between 0 and array.size gives correct answer")
	public void testOrder6() {
		org.junit.Assert.assertEquals("Ed",game.order(people,4).last().getElement());
	}

}
