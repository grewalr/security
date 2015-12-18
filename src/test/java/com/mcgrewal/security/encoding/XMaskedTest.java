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
public class XMaskedTest extends EncoderAbstractTest<String, byte[]>
{
	@Parameters
	public static Collection<Object[]> data()
	{
		// Collection of testEmbeddedAgent parameters to testEmbeddedAgent
		Collection<Object[]> testParamsCollection = Arrays.asList(new Object[][]
		{
			{"XMASKED", "10401090".getBytes(), "XXXXXXXX"}, 
			{"XMASKED", "40375759".getBytes(), "XXXXXXXX"}, 
			{"XMASKED", "40439317".getBytes(), "XXXXXXXX"}, 
			{"XMASKED", "1030170813123".getBytes(), "XXXXXXXXXXXXX"}, 
			{"XMASKED", "40376223 1231231".getBytes(), "XXXXXXXXXXXXXXXX"},
			{"XMASKED", "1 2 3 4 5".getBytes(), "XXXXXXXXX"}
		});
		
		return testParamsCollection;
	}
	
	// Contructor required for testEmbeddedAgent parameters
	public XMaskedTest(String algorithm, byte[] input, String expectedResult)
	{
		super(algorithm, input, expectedResult);
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
