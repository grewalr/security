package com.mcgrewal.security.algorithm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author grewalri
 *
 */
@RunWith(Parameterized.class)
public class RIPEMDTest extends HashedAlgorithmAbstractTest
{
	@Parameters
	public static Collection<Object[]> data()
	{
		// Collection of testEmbeddedAgent parameters to testEmbeddedAgent
		Collection<Object[]> returnCollection = Arrays.asList(new Object[][]
		{
			{"RIPEMD128", "10401090", new byte[] {10, -31, -59, -17, -64, -77, 27, -93, 20, 118, -102, -115, 0, -76, -122, 55}},
			{"RIPEMD128", "40375759", new byte[] {83, -10, 91, -102, -96, 118, -12, 40, 27, -122, -124, -16, 36, -78, 20, 60}}, 
			
			{"RIPEMD160", "10401090", new byte[] {-57, 76, 0, 21, 0, 122, 31, -40, 45, -105, -121, -97, 89, 6, -76, -30, -73, -72, -87, -50}},
			{"RIPEMD160", "40375759", new byte[] {-41, -60, -114, 67, -21, -5, -100, 15, 80, -114, 15, -104, -106, 47, 90, 91, -126, 116, 88, -5}}, 
			
			{"RIPEMD256", "10401090", new byte[] {1, 2, -123, -84, 104, 22, -105, -61, -13, 89, -56, 41, -118, -31, 100, -124, -30, -81, -27, -37, -121, -5, -30, 121, 125, 96, 30, -40, -101, -92, 126, -37}}, 
			{"RIPEMD256", "40375759", new byte[] {70, 15, 43, 92, -71, -21, -102, -109, 55, -33, -74, -98, -123, 104, -1, 126, -125, -125, -95, -100, 81, 116, 103, 4, 0, -61, 20, 100, -99, -27, -82, -20}}, 

			{"RIPEMD320", "10401090", new byte[] {-100, 26, -105, -102, -98, 103, -35, -110, -65, -2, -76, 106, -45, 56, -73, 8, 98, 8, 87, 16, -123, -68, -15, 43, 9, -55, 3, -76, -26, 60, 24, 1, 12, 70, 88, 74, -93, -110, -104, 114}}, 
			{"RIPEMD320", "40375759", new byte[] {21, 39, -5, -28, -111, -58, 41, -95, 96, -90, -37, -94, -62, 18, 71, -73, 1, -125, 76, -54, 95, 50, -128, 5, -9, 34, -14, -111, 105, 70, -1, 58, -52, 23, -94, 22, -78, -32, 19, 77}}, 
		});
		
		return returnCollection;
	}
	
	public RIPEMDTest(String algorithm, String input, byte[] expectedResult)
	{
		super(algorithm, input, expectedResult);
	}

	@Before
	public void setUp() throws Exception
	{
		super.setup();
	}
	
	@Test
	public void testGenerateHashWithoutSalt()
	{
		super.testGenerateHashWithoutSalt();
	}

	@Test
	public void testGenerateHashWithSalt()
	{
		super.testGenerateHashWithSalt();
	}
	
	@After
	public void tearDown() throws Exception
	{
		super.tearDown();
	}
}
