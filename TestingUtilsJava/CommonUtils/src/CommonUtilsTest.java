import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

public class CommonUtilsTest 
{
	private final String testdata = "Hi this is some testdata to use f​or our tests";
	
	@Test
	public void testFindInFile() throws IOException 
	{
		BufferedWriter writer = new BufferedWriter( new FileWriter("testfile.txt"));
		writer.write(testdata);
		writer.close();
		assertTrue(CommonUtils.findInFile("this", "testfile.txt"));
	
		new File("testfile.txt").delete();
	}
	@Test
	public void testFindInString() throws IOException 
	{		
		assertTrue(CommonUtils.findInString("Hi", testdata));
	}
	@Test
	public void testFindInDirectory() throws IOException 
	{
		BufferedWriter writer = new BufferedWriter( new FileWriter("testfile.txt"));
		writer.write(testdata);
		writer.close();
		assertTrue(CommonUtils.findInFile("this", "testfile.txt"));
	
		new File("testfile.txt").delete();
	}
	
	@Test
	public void testNegative()  
	{
		final int n = -1;
		assertTrue(CommonUtils.sieveOfEratosthenes(n) == 0);
	}
	
	@Test
	public void tesZero()  
	{
		final int n = 0;
		assertTrue(CommonUtils.sieveOfEratosthenes(n) == 0);
	}
	
	@Test
	public void test10()  
	{
		final int n = 10;
		assertTrue(CommonUtils.sieveOfEratosthenes(n) == 4);
	}
	
	@Test
	public void test100()  
	{
		final int n = 100;
		assertTrue(CommonUtils.sieveOfEratosthenes(n) == 25);
	}
	
	@Test
	public void test1000()  
	{
		final int n = 1000;
		assertTrue(CommonUtils.sieveOfEratosthenes(n) == 168);
	}
	
	@Ignore
	@Test
	public void test1000000()  
	{
		final int n = 1000000;
		assertTrue(CommonUtils.sieveOfEratosthenes(n) == 78498);
	}
	
	@Ignore
	@Test
	public void test1000000000()  
	{
		final int n = 1000000000;
		assertTrue(CommonUtils.sieveOfEratosthenes(n) == 50847534);
	}
	
	@Test
	public void calcDistance0()
	{
		CharSequence cs1 = "";
		CharSequence cs2 = "";
		
		assertTrue(CommonUtils.levenshteinDistance(cs1, cs2) == 0);
	}
	
	@Test
	public void calcDistance1()
	{
		CharSequence cs1 = "AA";
		CharSequence cs2 = "AB";
		
		assertTrue(CommonUtils.levenshteinDistance(cs1, cs2) == 1);
	}
	
	@Test
	public void calcDistance2()
	{
		CharSequence cs1 = "AAA";
		CharSequence cs2 = "ABC";
		
		assertTrue(CommonUtils.levenshteinDistance(cs1, cs2) == 2);
	}
	
	@Test
	public void calcDistanceN()
	{
		CharSequence cs1 = "dsfgdfhdfer";
		CharSequence cs2 = "fgjtykfgnsd";
		
		assertTrue(CommonUtils.levenshteinDistance(cs1, cs2) > 5);
	}
}

