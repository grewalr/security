package com.mcgrewal.security.algorithm;

import org.bouncycastle.crypto.Digest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


/**
 * @author grewalri
 *
 */
public class HashedAlgorithm implements Algorithm<byte[], String>
{
	private static final Logger LOG = LoggerFactory.getLogger(HashedAlgorithm.class);
	private boolean generateRandomSalt;
	private byte[] salt;
	private String seed;
	private Digest algo;
	
	public HashedAlgorithm(Digest digest)
	{
		this.algo = digest;
	}
	
	@Override
	public void generateRandomSalt()
	{
		this.generateRandomSalt = true;
	}

	@Override
	public void setSalt(byte[] salt)
	{
		this.salt = salt; 		
	}
	
	@Override
	public String getSeed()
	{
		return (null != seed) ? seed : String.valueOf(System.nanoTime());
	}
	
	@Override
	public void setSeed(String seed)
	{
		this.seed = seed;
	}
	
	@Override
	public Digest getDigest()
	{
		return algo;
	}

	@Override
	public byte[] digest(String input)
	{
		// Concatenate the seed if present 
		if(null != seed) input += seed;
		
		if(null != salt && salt.length > 0) 
		{
			input += salt.toString();
		}
		else if(generateRandomSalt)
		{
			// Apply random salt
			input += getSalt();
		}
	
		algo.update(input.getBytes(), 0, input.length());
	
		byte[] digest = new byte[algo.getDigestSize()];
	
	    algo.doFinal(digest, 0);
	
	    return digest;
	}
	
	private static String getSalt()
	{      
		byte[] generatedSalt = new byte[32];
		try
		{
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.nextBytes(generatedSalt);       
		}
		catch(NoSuchAlgorithmException e)
		{
			LOG.error("Could not generate salt", e);
		} 
		
		return generatedSalt.toString();
	}

	
}
