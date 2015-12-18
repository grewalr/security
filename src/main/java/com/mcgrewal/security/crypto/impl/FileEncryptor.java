package com.mcgrewal.security.crypto.impl;

import com.mcgrewal.security.crypto.Encryptor;
import com.mcgrewal.security.utils.KeyUtils;
import com.google.common.io.ByteStreams;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;

/**
 * @author grewalri
 *
 */
public class FileEncryptor extends AbstractCryptor implements Encryptor<File, File>
{
	private static final Logger LOG = Logger.getLogger(FileEncryptor.class);

	public FileEncryptor(Key key)
	{
		super(key);
	}

	@Override
	public File encrypt(File input)
	{
		String encodedFileName = input.getName() + ENCODED_EXT;
		File encryptedFile = new File(input.getParent(), encodedFileName);

		FileInputStream fis = null;
		CipherOutputStream cos = null;
		
		try
		{
			cipher.init(Cipher.ENCRYPT_MODE, key);
			
			fis = new FileInputStream(input);
			cos = new CipherOutputStream(new FileOutputStream(encryptedFile), cipher);
	
			ByteStreams.copy(fis, cos);
		}
		catch(Exception ex)
		{
			LOG.error("Unable to encrypt file : " + input.getAbsolutePath(), ex);
		}
		finally
		{
			IOUtils.closeQuietly(fis);
			
			try
			{
				if(null != cos) cos.flush(); cos.close();
			}
			catch(IOException ioe)
			{
				LOG.error("Unable to close streams : ", ioe);
			}
		}
		
		return encryptedFile;
	}
	
	public static void main(String[] args)
	{
		Key key = KeyUtils.createKey("AES");
		new FileEncryptor(key).encrypt(
				new File("C:/EDDI/data/CopyofCredit_20140203_subsetA--DATA_MASKING/EDDI/Cr/Glob/Insight/Prod/0/EOD/2014-02-03/RMCrGlob/data/esf/F/1/book-sdaps-1211-Frag-RROTC-2.esf.frag.gz"));
		
	}
}
