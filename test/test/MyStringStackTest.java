package test;

import java.util.NoSuchElementException;

import junit.framework.TestCase;
import junit.framework.TestSuite;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import stack.MyStringStack;


public class MyStringStackTest extends TestCase {
	private String s1, s2;
	
	public MyStringStackTest(String name) {
		super(name);
	}
	@Before
	public void setUp() throws Exception {
		s1 = "Hello";
		s2 = "there";	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPush() {
		String o1 = null;  
		MyStringStack stack = new MyStringStack();
		stack.push (s1);
		assertTrue (stack.isEmpty());
	}

	@Test
	public void testPop() {
		String o1 = null;

		MyStringStack stack = new MyStringStack();
        assertTrue ("Initial Stack state", stack.isEmpty());
        try {
            o1 = stack.pop ();
            fail ("Failed pop()");
        } catch (NoSuchElementException e) {}
        
		stack.push(s1);
		assertFalse("Stack should not be empty after push()", stack.isEmpty());
		
		try {
			o1 = stack.pop();
		}catch (NoSuchElementException e) {
			fail("Falied pop - No Elements");
		}
		assertSame (s1,o1);
		assertTrue ("Stack should be empty after popping all elements", stack.isEmpty());
		//assertTrue ( stack.isEmpty());
	}

	@Test
	public void testIsEmpty() {
		String s3 = null;
		MyStringStack stack = new MyStringStack();
		assertTrue (stack.isEmpty());
		stack.push(s1);
		assertFalse(stack.isEmpty());
		
		try {
			s3 = stack.pop();
		}catch (NoSuchElementException e) {
			fail();
		}
		assertSame (s1,s3);
		assertTrue (stack.isEmpty());
	}

	@org.junit.Test
	public void testClear() {
		String o1 = null;  
		MyStringStack stack = new MyStringStack();
        assertTrue (stack.isEmpty());
        stack.push (s1);
        stack.push (s2);
        assertFalse (stack.isEmpty());
        stack.clear ();
        assertTrue (stack.isEmpty());
        try {
            o1 = stack.pop ();
            fail ();
        } catch (NoSuchElementException e) {}

	}
	
	@Test
	public void testStackNull() {
        String o1 = null;  
        MyStringStack stack = new MyStringStack();
        assertTrue (stack.isEmpty());
        stack.push (null);
        assertTrue (stack.isEmpty());
        stack.push (null);
        stack.push (s1);
        stack.push (null);
        try {
            o1 = stack.pop ();
            assertSame (o1, s1);
        } catch (NoSuchElementException e) {  fail (); }
        assertTrue (stack.isEmpty());
        try {
            o1 = stack.pop ();
            fail ();
        } catch (NoSuchElementException e) {}
	}
	
	@Test
	public void testStackSequence() {
        String o1 = null;  
        MyStringStack stack = new MyStringStack();
        assertTrue (stack.isEmpty());
        stack.push (s1);
        try {
            o1 = stack.pop ();
            assertSame (s1, o1);
        } catch (NoSuchElementException e) {  fail ();  }
        stack.push (s1);
        stack.push (s2);
        try {
            o1 = stack.pop ();  assertSame (s2, o1);
            o1 = stack.pop ();  assertSame (s1, o1);
        } catch (NoSuchElementException e) {  fail ();  }
        assertTrue (stack.isEmpty());
	}
	
	public static junit.framework.Test suite() {
		TestSuite suite = new TestSuite("Test for default package");
		System.out.println ("Test for default package");
		//$JUnit-BEGIN$
		suite.addTestSuite(MyStringStackTest.class);
		//$JUnit-END$
		return suite;
	}



}
