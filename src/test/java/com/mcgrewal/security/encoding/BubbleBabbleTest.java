package com.mcgrewal.security.encoding;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BubbleBabbleTest extends EncoderAbstractTest<String, byte[]>
{
	@Parameters
	public static Collection<Object[]> data()
	{
		// Collection of testEmbeddedAgent parameters to testEmbeddedAgent
		Collection<Object[]> returnCollection = Arrays.asList(new Object[][]
		{
			{"BUBBLEBABBLE", "".getBytes(), "xexax"},
			{"BUBBLEBABBLE", "1234567890".getBytes(), "xesef-disof-gytuf-katof-movif-baxux"}, 
			{"BUBBLEBABBLE", "Pineapple".getBytes(), "xigak-nyryk-humil-bosek-sonax"},
			{"BUBBLEBABBLE", "asdf".getBytes(), "ximel-finek-koxex"},
			{"BUBBLEBABBLE", "0123456789".getBytes(), "xesaf-casef-fytef-hutif-lovof-nixix"},
			{"BUBBLEBABBLE", "Testing a sentence.".getBytes(), "xihak-hysul-gapak-venyd-bumud-besek-heryl-gynek-vumuk-hyrox"}
		});
		
		return returnCollection;
	}
	
	public BubbleBabbleTest(String encoderString, byte[] input, String expectedResult)
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
