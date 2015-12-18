package com.mcgrewal.security.crypto.impl;

import com.mcgrewal.security.crypto.Decryptor;
import org.apache.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import java.io.InputStream;
import java.security.Key;

/**
 * @author grewalri
 *
 */
public class InputStreamDecryptor extends AbstractCryptor implements Decryptor<InputStream, InputStream>
{
	private static final Logger LOG = Logger.getLogger(InputStreamDecryptor.class);
	
	public InputStreamDecryptor(Key key)
	{
		super(key);
	}
	
	@Override
	public InputStream decrypt(InputStream input)
	{
		CipherInputStream cis = null;
		try
		{
			cipher.init(Cipher.DECRYPT_MODE, key);
			cis = new CipherInputStream(input, cipher);
		}
		catch(Exception ex)
		{
			LOG.error("Unable to decrypt inputStream : ", ex);
		}

		return cis;
	}
}
