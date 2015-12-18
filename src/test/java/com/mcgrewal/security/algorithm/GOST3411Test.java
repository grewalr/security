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
public class GOST3411Test extends HashedAlgorithmAbstractTest
{
	@Parameters
	public static Collection<Object[]> data()
	{
		// Collection of testEmbeddedAgent parameters to testEmbeddedAgent
		Collection<Object[]> returnCollection = Arrays.asList(new Object[][]
		{
			{"GOST3411", "10401090", new byte[] {-80, -109, 21, -29, 67, 49, -122, -46, -51, 73, -45, 93, 16, 94, -10, 105, -123, 55, -71, 127, -18, 111, -97, 115, -35, 77, -25, 111, -128, -70, 10, 85}},
			{"GOST3411", "40375759", new byte[] {-81, -19, 40, 46, 81, -73, 20, -82, 56, 92, 90, 46, 102, -35, -76, -5, -77, 31, -84, -122, -63, 31, 65, -65, 71, -110, 83, 81, -80, -87, -46, -14}}, 
		});
		
		return returnCollection;
	}
	
	public GOST3411Test(String algorithm, String input, byte[] expectedResult)
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
