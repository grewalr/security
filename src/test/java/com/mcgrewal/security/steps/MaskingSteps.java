package com.mcgrewal.security.steps;

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
public class MaskingSteps
{
	private Encoder<String, byte[]> encoderType;
	private String result;
	
	@Given("the type of <encoder>")
	public void setEncoderType(@Named("encoder") String encoder)
	{
		encoderType = EncoderFactory.valueOf(encoder).getEncoder();
	}
	
	@When("an <inputString> is supplied")
	public void suppliedInputString(@Named("inputString") String inputString)
	{
		result = encoderType.encode(inputString.getBytes());
	}
	
	@Then("the output masked value is <resultString>")
	public void compareTheResult(@Named("resultString") String resultString)
	{
		assertThat(result, equalTo(resultString));
	}
}
