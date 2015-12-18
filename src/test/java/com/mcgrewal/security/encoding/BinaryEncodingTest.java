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
public class BinaryEncodingTest extends EncoderAbstractTest<String, byte[]>
{
	@Parameters
	public static Collection<Object[]> data()
	{
		// Collection of testEmbeddedAgent parameters to testEmbeddedAgent
		Collection<Object[]> returnCollection = Arrays.asList(new Object[][]
		{
			{"BINARY", "10401090".getBytes(), "0011000000111001001100000011000100110000001101000011000000110001"},
			{"BINARY", "12345678".getBytes(), "0011100000110111001101100011010100110100001100110011001000110001"},
			{"BINARY", "40375759".getBytes(), "0011100100110101001101110011010100110111001100110011000000110100"},
			{"BINARY", "87654321".getBytes(), "0011000100110010001100110011010000110101001101100011011100111000"},
			{"BINARY", "10101010".getBytes(), "0011000000110001001100000011000100110000001100010011000000110001"}
		});
		
		return returnCollection;
	}
	
	public BinaryEncodingTest(String encoderString, byte[] input, String expectedResult)
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
