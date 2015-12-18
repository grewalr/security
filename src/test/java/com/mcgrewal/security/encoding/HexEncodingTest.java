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
public class HexEncodingTest extends EncoderAbstractTest<String, byte[]>
{
	@Parameters
	public static Collection<Object[]> data()
	{
		// Collection of testEmbeddedAgent parameters to testEmbeddedAgent
		Collection<Object[]> returnCollection = Arrays.asList(new Object[][]
		{
			{
				"HEX",
				new byte[] {40, 53, 89, -72, -16, -119, 23, 41, -39, -31, -69, -51, -114, -87, 107, 63, 8, 1, 78, -116},
				"283559b8f0891729d9e1bbcd8ea96b3f08014e8c"
			},
			{
				"HEX",
				new byte[] {-93, -35, 21, -42, -36, -92, -2, 54, 25, -127, 65, -112, 113, 113, 9, -71, -109, 18, -120, 123},
				"a3dd15d6dca4fe3619814190717109b99312887b"
			},
			{	
				"HEX",
				new byte[] {8, 118, 49, -58, -69, -121, -83, 97, 113, -11, 54, 2, 73, 43, 104, 54, -51, -45, -40, 103, 79, -45, 48, -19, -42, -5, -56, 46, 79, 36, -99, 111},
				"087631c6bb87ad6171f53602492b6836cdd3d8674fd330edd6fbc82e4f249d6f"
			},
			{	
				"HEX",
				new byte[] {-107, 6, 98, 6, 64, 27, -99, 109, -74, -25, -53, -117, 112, 20, 44, 37, 70, -58, 117, 98, 21, 95, 54, 57, 70, -69, -41, 63, -24, 67, 19, 78},
				"95066206401b9d6db6e7cb8b70142c2546c67562155f363946bbd73fe843134e"
			},
			{	
				"HEX",
				new byte[] {49, -15, -37, 53, 22, -89, 126, 37, -91, -60, -94, -85, 4, -21, -79, -66, -16, -60, -3, -118, -47, 85, 124, 13, 20, 115, -120, 75, -106, -58, -101, -113, -106, -13, 40, -69, -61, -25, -42, -85, 72, 70, 121, -64, 78, 76, 121, 16, -120, -71, -63, 23, -18, 105, -21, -60, 90, -63, 49, -102, -30, 16, 124, 10},
				"31f1db3516a77e25a5c4a2ab04ebb1bef0c4fd8ad1557c0d1473884b96c69b8f96f328bbc3e7d6ab484679c04e4c791088b9c117ee69ebc45ac1319ae2107c0a"
			},
			{	
				"HEX",
				new byte[] {-128, 27, -29, -65, -91, -7, -75, -43, -121, 11, 41, -31, 36, -121, -100, 66, 31, -4, -69, -117, -118, -54, 3, -11, 80, 102, 72, -66, -13, 38, 127, 68, 60, 68, 52, -106, 121, 51, 35, 27, 35, 19, -86, 3, 91, -53, 107, -63, 117, 125, -4, -127, 83, 123, 99, -32, 119, -42, 65, 13, -90, 127, -31, -18},
				"801be3bfa5f9b5d5870b29e124879c421ffcbb8b8aca03f5506648bef3267f443c4434967933231b2313aa035bcb6bc1757dfc81537b63e077d6410da67fe1ee"
			}
		});
		
		return returnCollection;
	}
	
	public HexEncodingTest(String encoderString, byte[] input, String expectedResult)
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
