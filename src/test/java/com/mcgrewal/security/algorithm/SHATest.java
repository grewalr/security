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
public class SHATest extends HashedAlgorithmAbstractTest
{
	@Parameters
	public static Collection<Object[]> data()
	{
		// Collection of testEmbeddedAgent parameters to testEmbeddedAgent
		Collection<Object[]> returnCollection = Arrays.asList(new Object[][]
		{
			{"SHA1", "10401090", new byte[] {40, 53, 89, -72, -16, -119, 23, 41, -39, -31, -69, -51, -114, -87, 107, 63, 8, 1, 78, -116}},
			{"SHA1", "40375759", new byte[] {-93, -35, 21, -42, -36, -92, -2, 54, 25, -127, 65, -112, 113, 113, 9, -71, -109, 18, -120, 123}}, 
			
			{"SHA224", "10401090", new byte[] {26, 15, 40, -41, -59, 70, 62, 92, 109, -77, 57, 93, 55, 43, -27, 125, -67, -120, -61, -9, -89, -79, 88, -92, -104, -64, 63, 51}},
			{"SHA224", "40375759", new byte[] {-111, 84, -12, 11, 44, -61, -9, -80, -117, -23, -43, -25, 35, 84, 36, -18, 106, -115, 72, -114, 80, 84, 105, -39, -7, -99, 88, 110}}, 
			
			{"SHA256", "10401090", new byte[] {8, 118, 49, -58, -69, -121, -83, 97, 113, -11, 54, 2, 73, 43, 104, 54, -51, -45, -40, 103, 79, -45, 48, -19, -42, -5, -56, 46, 79, 36, -99, 111}}, 
			{"SHA256", "40375759", new byte[] {-107, 6, 98, 6, 64, 27, -99, 109, -74, -25, -53, -117, 112, 20, 44, 37, 70, -58, 117, 98, 21, 95, 54, 57, 70, -69, -41, 63, -24, 67, 19, 78}}, 

			{"SHA384", "10401090", new byte[] {-63, -36, -107, -121, -118, 98, 89, 109, 42, -49, -121, -33, -111, 34, 26, 32, 60, 16, -114, 87, 77, 71, -49, -51, -106, 103, 66, -74, -38, -52, -92, -89, -112, -122, -69, -114, 78, -28, -9, 22, 89, 93, 110, -60, 58, -2, 86, -60}}, 
			{"SHA384", "40375759", new byte[] {-127, -25, 31, 50, -74, -64, -33, -27, 60, 80, -33, 28, -18, -128, -48, 63, -102, -117, 43, -107, 23, -110, 118, 43, -121, -37, -4, -106, -11, -89, -111, -85, -123, -121, -115, -54, -66, -114, 27, -78, 117, -95, -90, 4, 27, -120, -9, 51}}, 
			
			{"SHA512", "10401090", new byte[] {49, -15, -37, 53, 22, -89, 126, 37, -91, -60, -94, -85, 4, -21, -79, -66, -16, -60, -3, -118, -47, 85, 124, 13, 20, 115, -120, 75, -106, -58, -101, -113, -106, -13, 40, -69, -61, -25, -42, -85, 72, 70, 121, -64, 78, 76, 121, 16, -120, -71, -63, 23, -18, 105, -21, -60, 90, -63, 49, -102, -30, 16, 124, 10}}, 
			{"SHA512", "40375759", new byte[] {-128, 27, -29, -65, -91, -7, -75, -43, -121, 11, 41, -31, 36, -121, -100, 66, 31, -4, -69, -117, -118, -54, 3, -11, 80, 102, 72, -66, -13, 38, 127, 68, 60, 68, 52, -106, 121, 51, 35, 27, 35, 19, -86, 3, 91, -53, 107, -63, 117, 125, -4, -127, 83, 123, 99, -32, 119, -42, 65, 13, -90, 127, -31, -18}} 
		});
		
		return returnCollection;
	}

	// Constructor required for the testEmbeddedAgent parameters
	public SHATest(String algorithm, String input, byte[] expectedOutput)
	{
		super(algorithm, input, expectedOutput);
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
