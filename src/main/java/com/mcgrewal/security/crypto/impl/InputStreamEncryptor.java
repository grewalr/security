package com.mcgrewal.security.crypto.impl;

import com.mcgrewal.security.crypto.Encryptor;
import org.apache.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import java.io.InputStream;
import java.security.Key;

/**
 * @author grewalri
 *
 */
public class InputStreamEncryptor extends AbstractCryptor implements Encryptor<InputStream, InputStream>
{
	private static final Logger LOG = Logger.getLogger(InputStreamEncryptor.class);
	
	public InputStreamEncryptor(Key key)
	{
		super(key);
	}
	
	@Override
	public InputStream encrypt(InputStream input)
	{
		CipherInputStream cis = null;
		try
		{
			cipher.init(Cipher.ENCRYPT_MODE, key);
			cis = new CipherInputStream(input, cipher);
		}
		catch(Exception ex)
		{
			LOG.error("Unable to decrypt inputStream : ", ex);
		}

		return cis;
	}
}
