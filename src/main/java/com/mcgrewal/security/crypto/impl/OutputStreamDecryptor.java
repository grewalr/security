package com.mcgrewal.security.crypto.impl;

import com.mcgrewal.security.crypto.Decryptor;
import org.apache.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import java.io.OutputStream;
import java.security.Key;

/**
 * @author grewalri
 *
 */
public class OutputStreamDecryptor extends AbstractCryptor implements Decryptor<OutputStream, OutputStream>
{
	private static final Logger LOG = Logger.getLogger(OutputStreamDecryptor.class);
	
	public OutputStreamDecryptor(Key key)
	{
		super(key);
	}
	
	@Override
	public OutputStream decrypt(OutputStream input)
	{
		CipherOutputStream cos = null;
		try
		{
			cipher.init(Cipher.DECRYPT_MODE, key);
			cos = new CipherOutputStream(input, cipher);
		}
		catch(Exception ex)
		{
			LOG.error("Unable to encrypt outputStream : ", ex);
		}

		return cos;
	}
}