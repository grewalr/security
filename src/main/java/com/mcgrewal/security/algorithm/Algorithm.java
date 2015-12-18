package com.mcgrewal.security.algorithm;

import org.bouncycastle.crypto.Digest;

/**
 * @author grewalri
 *
 */
public interface Algorithm<T1,T2>
{
	T1 digest(T2 input);
	
	Digest getDigest();
	
	void generateRandomSalt();
	
	void setSalt(byte[] salt);

	void setSeed(String seed);
	
	String getSeed();
}
