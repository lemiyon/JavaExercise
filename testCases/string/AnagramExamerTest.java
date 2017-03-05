package string;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AnagramExamerTest {
	
	AnagramExamer e;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAnagrams() {
		assertTrue(AnagramExamer.isAnagram("abc", "cab"));
		assertTrue(AnagramExamer.isAnagram("dgdgdgde", "ddddggge"));
	}
	
	@Test
	public void testNotAnagrams() {
		//같은 길이 다른 문자 
		assertFalse(AnagramExamer.isAnagram("ddd", "aaa"));
		
		//같은 길이 다른 문자 갯수
		assertFalse(AnagramExamer.isAnagram("dda", "daa"));
		
		//다른 길이
		assertFalse(AnagramExamer.isAnagram("ddddd", "ddd"));
	}
	
	@Test
	//case sensative하면 안된다!
	public void testCaseSensitive() {
		assertTrue(AnagramExamer.isAnagram("Hello", "hello"));
	}
	
	@Test
	public void testEmptyStrings() {
		assertTrue(AnagramExamer.isAnagram("",""));
	}

}
