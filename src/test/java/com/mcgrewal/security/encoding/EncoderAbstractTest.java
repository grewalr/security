package com.mcgrewal.security.encoding;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author grewalri
 *
 */
public abstract class EncoderAbstractTest<T1, T2>
{
	private static final Logger LOG = LoggerFactory.getLogger(EncoderAbstractTest.class);
	
	private Encoder<T1, T2> encoder;
	private T2 input;
	private T1 expectedResult;
	private String encoderString;
	
	// Contructor required for testEmbeddedAgent parameters
	public EncoderAbstractTest(String encoderString, T2 input, T1 expectedResult)
	{
		this.encoderString = encoderString;
		this.input = input;
		this.expectedResult = expectedResult;
	}
	
	@Before
	public void setUp() throws Exception
	{
		encoder = EncoderFactory.valueOf(encoderString).getEncoder();
	}

	@Test
	public void testEncode()
	{
		T1 actualResult = encoder.encode(input);
		
		if(LOG.isDebugEnabled()) 
			LOG.debug("\tencoding algorithm : {}, \tinput : {}, \texpectedResult : {}, \tactualResult : {}", 
					encoderString, input, expectedResult, actualResult);
		
		assertThat(actualResult, equalTo(expectedResult));
	}

	@After
	public void tearDown() throws Exception
	{
		encoder = null;
	}
}
