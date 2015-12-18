package com.mcgrewal.security.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

/**
 * @author grewalri
 *
 */
public abstract class HashedAlgorithmAbstractTest
{
	private static final Logger LOG = LoggerFactory.getLogger(HashedAlgorithmAbstractTest.class);
	
	private Algorithm<byte[], String> algo;
	
	private String algorithm;
	private String input;
	private byte[] expectedResult;
	
	protected HashedAlgorithmAbstractTest(String algorithm, String input, byte[] expectedResult)
	{
		this.algorithm = algorithm;
		this.input = input;
		this.expectedResult = expectedResult;
	}

	protected void setup() throws Exception
	{
		algo = DigestAlgorithmFactory.valueOf(algorithm).getDigest();
	}
	
	protected void testGenerateHashWithoutSalt()
	{
		byte[] digestedBytes = algo.digest(input);
		
		assertThat(digestedBytes, equalTo(expectedResult));

		if (LOG.isDebugEnabled())
			LOG.debug("testGenerateHashWithoutSalt() - \talgorithm : {} \tinput : {} \texpectedOutput : {} \tactualOutput : {} ", algorithm, input, expectedResult, digestedBytes);
	}

	protected void testGenerateHashWithSalt()
	{
		algo.generateRandomSalt();
		byte[] digestedBytes = algo.digest(input);
		
		assertThat(digestedBytes, not(expectedResult));
		
		if (LOG.isDebugEnabled())
			LOG.debug("testGenerateHashWithSalt() - \talgorithm : {} \tinput : {} \texpectedOutput : {} \tactualOutput : {} ", algorithm, input, expectedResult, digestedBytes);
	}
	
	protected void tearDown() throws Exception
	{
		algo = null;
	}
}
