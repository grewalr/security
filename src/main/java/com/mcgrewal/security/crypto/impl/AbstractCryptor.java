package com.mcgrewal.security.crypto.impl;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import java.security.Key;

/**
 * @author grewalri
 *
 */
public abstract class AbstractCryptor
{
	private static final Logger LOG = LoggerFactory.getLogger(AbstractCryptor.class);

	protected static final String ENCODED_EXT = ".enc";
	protected Cipher cipher;
	protected Key key;
	
	public AbstractCryptor(Key key)
	{
		this.key = key;
		initCipher();
	}
	
	private void initCipher()
	{
		try
		{
			// Create the shared key cipher
			cipher = Cipher.getInstance(key.getAlgorithm(), new BouncyCastleProvider());
		}
		catch(Exception ex)
		{
			LOG.error("Unable to register the cipher for "+key.getAlgorithm(), ex);
		}
	}
}
