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
public class MDTest extends HashedAlgorithmAbstractTest
{
	@Parameters
	public static Collection<Object[]> data()
	{
		// Collection of testEmbeddedAgent parameters to testEmbeddedAgent
		Collection<Object[]> returnCollection = Arrays.asList(new Object[][]
		{
			{"MD2", "10401090", new byte[] {127, -74, 109, 74, 62, -45, -10, -119, 89, -93, -1, 71, -99, -34, 47, 98}},
			{"MD2", "40375759", new byte[] {-99, -92, 62, 26, 6, -33, 4, -38, -12, 8, -39, -23, -46, -114, -59, 24}}, 
			
			{"MD4", "10401090", new byte[] {119, 82, -32, -26, -32, 5, 66, 52, -42, 21, -121, 38, -73, 80, -113, -16}},
			{"MD4", "40375759", new byte[] {-59, -76, -11, 63, 89, 62, -115, 87, 124, 110, 80, 92, -52, -103, -99, 24}}, 
			
			{"MD5", "10401090", new byte[] {54, -78, -7, -111, -52, 62, -29, 62, 41, 8, 107, 105, -51, -5, -47, 78}}, 
			{"MD5", "40375759", new byte[] {51, 81, 43, -79, -9, -84, 123, -53, 107, 48, -35, -28, 43, -73, -77, -96}}
		});
		
		return returnCollection;
	}
	
	public MDTest(String algorithm, String input, byte[] expectedResult)
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
