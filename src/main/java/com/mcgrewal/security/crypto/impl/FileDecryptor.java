package com.mcgrewal.security.crypto.impl;

import com.mcgrewal.security.crypto.Decryptor;
import com.google.common.io.ByteStreams;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;

/**
 * @author grewalri
 *
 */
public class FileDecryptor extends AbstractCryptor implements Decryptor<File, File>
{
	private static final Logger LOG = Logger.getLogger(FileDecryptor.class);
	
	public FileDecryptor(Key key)
	{
		super(key);
	}
	
	@Override
	public File decrypt(File input)
	{
		String inputFilename = input.getAbsolutePath();
		String decodedFileName = inputFilename.substring(0, inputFilename.indexOf(ENCODED_EXT));
		File output = new File(decodedFileName);

		CipherInputStream cis = null;
		FileOutputStream fos = null;
		
		try
		{
			cipher.init(Cipher.DECRYPT_MODE, key);
	
			cis = new CipherInputStream(new FileInputStream(input), cipher);
			fos = new FileOutputStream(output);
	
			ByteStreams.copy(cis, fos);
		}
		catch(Exception ex)
		{
			LOG.error("Unable to decrypt file : " + input.getAbsolutePath(), ex);
		}
		finally
		{
			IOUtils.closeQuietly(cis);
			
			try
			{
				if(null != fos) fos.flush(); fos.close();
			}
			catch(IOException ioe)
			{
				LOG.error("Unable to close streams : ", ioe);
			}
		}
		
		return output;
	}
	
}
