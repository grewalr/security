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
public class BaseEncodingTest extends EncoderAbstractTest<String, byte[]>
{
	@Parameters
	public static Collection<Object[]> data()
	{
		// Collection of testEmbeddedAgent parameters to testEmbeddedAgent
		Collection<Object[]> returnCollection = Arrays.asList(new Object[][]
		{
			// Base32 params
			{"BASE32", "10401090".getBytes(), "GEYDIMBRGA4TA==="},
			{"BASE32", "12345678".getBytes(), "GEZDGNBVGY3TQ==="},
			{"BASE32", "40375759".getBytes(), "GQYDGNZVG42TS==="},
			{"BASE32", "87654321".getBytes(), "HA3TMNJUGMZDC==="},
			{"BASE32", "10101010".getBytes(), "GEYDCMBRGAYTA==="},
			
			// Base64 params 
			{"BASE64", "10401090".getBytes(), "MTA0MDEwOTA="},
			{"BASE64", "12345678".getBytes(), "MTIzNDU2Nzg="},
			{"BASE64", "40375759".getBytes(), "NDAzNzU3NTk="},
			{"BASE64", "87654321".getBytes(), "ODc2NTQzMjE="},
			{"BASE64", "10101010".getBytes(), "MTAxMDEwMTA="}
		});
		
		return returnCollection;
	}
	
	public BaseEncodingTest(String encoderString, byte[] input, String expectedResult)
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
