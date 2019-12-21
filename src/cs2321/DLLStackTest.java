package cs2321;

import org.junit.Before;
import org.junit.Test;

public class DLLStackTest {

	private DLLStack<String> T = init();
	public DLLStack<String> init() {
		return new DLLStack<String>();
	}
	
	@Before
	public void setUp() throws Exception {
		T.push("A");
		T.push("B");
		T.push("C");
	}
	
	@Test
	@jug.TestName("top returns top of stack")
	public void test1() {
		org.junit.Assert.assertEquals("C",T.top());
	}
	
	@Test
	@jug.TestName("top does not remove from stack")
	public void test2() {
		T.top();
		org.junit.Assert.assertEquals("C",T.top());
	}
	
	@Test
	@jug.TestName("pop returns top of stack")
	public void test3() {
		org.junit.Assert.assertEquals("C",T.pop());
	}

	@Test
	@jug.TestName("pop removes from stack")
	public void test4() {
		T.pop();
		org.junit.Assert.assertEquals("B",T.pop());
	}
	
	@Test
	@jug.TestName("size returns ammount of elements in stack")
	public void test5() {
		org.junit.Assert.assertEquals(3,T.size());
	}
	
	@Test
	@jug.TestName("isEmpty returns true if stack is empty")
	public void test6() {
		T.pop();
		T.pop();
		T.pop();
		org.junit.Assert.assertEquals(true,T.isEmpty());
	}
	
	@Test
	@jug.TestName("push adds to top of stack")
	public void test7() {
		T.push("D");
		org.junit.Assert.assertEquals("D",T.top());
	}
	
	@Test
	@jug.TestName("top works when stack is empty")
	public void test8() {
		T.pop();
		T.pop();
		T.pop();
		org.junit.Assert.assertEquals(null,T.top());
	}
	
}
