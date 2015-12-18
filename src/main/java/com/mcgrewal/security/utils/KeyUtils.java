package com.mcgrewal.security.utils;

import com.google.common.io.Files;
import org.apache.log4j.Logger;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.IOException;
import java.security.Key;

/**
 * @author grewalri
 * 
 */
public class KeyUtils
{
	private static final Logger LOG = Logger.getLogger(KeyUtils.class);
	private static final int KEY_SIZE = 128; // 128 bits
	private static final String DEFAULT_CRYPTO_ALGORITHM = "AES";
	
	private KeyUtils()
	{
		// Prevent reflection attacks
		throw new UnsupportedOperationException();
	}
	
	public static Key createKey(String keyAlgorithm, int keySize)
	{
		SecretKeySpec keySpec = null;
		
		try
		{
			KeyGenerator kgen = KeyGenerator.getInstance(keyAlgorithm);
			kgen.init(keySize);
			SecretKey key = kgen.generateKey();
			byte[] encodedKey = key.getEncoded();
			keySpec = new SecretKeySpec(encodedKey, keyAlgorithm);
		}
		catch(Exception ex)
		{
			LOG.error("Unable to register the shared session key : ", ex);
		}
		
		return keySpec;
	}
	
	public static Key createKey(String keyAlgorithm)
	{
		return createKey(keyAlgorithm, KEY_SIZE);
	}
	
	public static Key createKeyFromBytes(byte[] keyBytes, String keyAlgorithm)
	{
		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, keyAlgorithm);
		return keySpec;
	}
	
	public static Key createKeyFromBytes(byte[] keyBytes)
	{
		return createKeyFromBytes(keyBytes, DEFAULT_CRYPTO_ALGORITHM);
	}
	
	public static void saveKeyToFile(Key key, String sessionKeyFileName) throws IOException
	{
		byte[] bytes = key.getEncoded();
		Files.write(bytes, new File(sessionKeyFileName));
	}
	
	public static Key loadKeyFromFile(String keyFileName) throws IOException
	{
		return loadKeyFromFile(new File(keyFileName));
	}
	
	public static Key loadKeyFromFile(File keyFile) throws IOException
	{
		byte[] bytes = Files.toByteArray(keyFile);
		return createKeyFromBytes(bytes, DEFAULT_CRYPTO_ALGORITHM);
	}
}
