package com.mcgrewal.security.steps;

import com.mcgrewal.security.algorithm.Algorithm;
import com.mcgrewal.security.algorithm.DigestAlgorithmFactory;
import com.mcgrewal.security.encoding.Encoder;
import com.mcgrewal.security.encoding.EncoderFactory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author grewalri
 *
 */
public class HashingSteps
{
	private Algorithm<byte[], String> algo;
	private Encoder<String, byte[]> encoder;
	
	private byte[] digestedInput;
	
	@Given("that <digest> algorithm is chosen and encoder type <anEncoder>")
	public void setAlgorithm(@Named("digest") String digest, @Named("anEncoder") String anEncoder)
	{
		algo = DigestAlgorithmFactory.valueOf(digest).getDigest();
		encoder = EncoderFactory.valueOf(anEncoder).getEncoder();
	}
	
	@When("a <counterpartyId> is supplied")
	public void suppliedInputString(@Named("counterpartyId") String counterpartyId)
	{
		digestedInput = algo.digest(counterpartyId);
	}
	
	@Then("the output hash is <hash>")
	public void hashOutputString(@Named("hash") String hash)
	{
		String actualHash = encoder.encode(digestedInput);
		assertThat(actualHash, equalTo(hash));
	}
}
