package com.mcgrewal.security.encoding;

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
public class IntegerEncodingTest extends EncoderAbstractTest<String, byte[]>
{

	@Parameters
	public static Collection<Object[]> data()
	{
		// Collection of testEmbeddedAgent parameters to testEmbeddedAgent
		Collection<Object[]> returnCollection = Arrays.asList(new Object[][]
		{
			{"INTEGER", "10401090".getBytes(), "3544390288328898864"},
			{"INTEGER", "12345678".getBytes(), "3544952156018063160"},
			{"INTEGER", "40375759".getBytes(), "3760562001063392569"},
			{"INTEGER", "87654321".getBytes(), "4050765991979987505"},
			{"INTEGER", "10101010".getBytes(), "3544386989794013488"}
		});
		
		return returnCollection;
	}
	public IntegerEncodingTest(String encoderString, byte[] input, String expectedResult)
	{
		super(encoderString, input, expectedResult);
	}

	@Before
	public void setUp() throws Exception
	{
		super.setUp();
	}

	@Test
	public void testEncode()
	{
		super.testEncode();
	}

	@After
	public void tearDown() throws Exception
	{
		super.tearDown();
	}
}
