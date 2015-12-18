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
public class TIGERTest extends HashedAlgorithmAbstractTest
{
	@Parameters
	public static Collection<Object[]> data()
	{
		// Collection of testEmbeddedAgent parameters to testEmbeddedAgent
		Collection<Object[]> returnCollection = Arrays.asList(new Object[][]
		{
			{"TIGER", "10401090", new byte[] {58, 123, 117, 65, 80, -10, -77, -24, 86, -113, -71, -43, -67, 54, -48, 122, 70, 17, 112, 43, -73, -83, -96, 49}},
			{"TIGER", "40375759", new byte[] {-60, 8, 89, -9, 4, 3, 87, -53, -16, 0, 79, -17, -12, -12, -49, 81, 83, -61, -80, -124, -124, -46, -80, -120}}, 
		});
		
		return returnCollection;
	}
	
	public TIGERTest(String algorithm, String input, byte[] expectedResult)
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
