package com.mcgrewal.security.crypto.impl;

import com.mcgrewal.security.crypto.Encryptor;
import org.apache.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import java.io.OutputStream;
import java.security.Key;

/**
 * @author grewalri
 *
 */
public class OutputStreamEncryptor extends AbstractCryptor implements Encryptor<OutputStream, OutputStream>
{
	private static final Logger LOG = Logger.getLogger(OutputStreamEncryptor.class);
	
	public OutputStreamEncryptor(Key key)
	{
		super(key);
	}
	
	@Override
	public OutputStream encrypt(OutputStream input)
	{
		CipherOutputStream cos = null;
		try
		{
			cipher.init(Cipher.ENCRYPT_MODE, key);
			cos = new CipherOutputStream(input, cipher);
		}
		catch(Exception ex)
		{
			LOG.error("Unable to encrypt outputStream : ", ex);
		}

		return cos;
	}
}
