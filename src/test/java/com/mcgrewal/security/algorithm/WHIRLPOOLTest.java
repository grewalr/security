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
public class WHIRLPOOLTest extends HashedAlgorithmAbstractTest
{
	@Parameters
	public static Collection<Object[]> data()
	{
		// Collection of testEmbeddedAgent parameters to testEmbeddedAgent
		Collection<Object[]> returnCollection = Arrays.asList(new Object[][]
		{
			{"WHIRLPOOL", "10401090", new byte[] {119, -32, -29, -88, 120, -22, -58, -22, -77, 63, -41, 92, 100, 45, 91, 21, 74, -109, 41, 78, 38, 73, -62, 89, -21, -9, 56, 105, -31, -93, -106, -91, -77, -126, -81, -41, 12, -68, 78, -120, 30, 100, 11, 72, 107, -74, 68, 79, -44, 45, -82, 105, -67, 95, 81, -126, -123, -123, -27, 90, 110, -100, -37, -84}},
			{"WHIRLPOOL", "40375759", new byte[] {-29, 107, 14, 95, -75, -104, 49, -115, -113, -73, -64, -63, -31, -67, -95, -104, -92, 59, -91, 64, 14, 5, -3, 82, 60, 106, -52, -105, -95, -100, 7, -52, 32, 45, -21, -101, -12, 104, -75, -52, 103, -123, -80, -110, -61, 58, -105, -8, 7, -25, 0, 123, -95, -28, 108, -60, 114, -87, -87, -4, 77, 55, -108, 105}}, 
		});
		
		return returnCollection;
	}
	
	public WHIRLPOOLTest(String algorithm, String input, byte[] expectedResult)
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
