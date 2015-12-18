package com.mcgrewal.security.crypto.impl;

import com.mcgrewal.security.crypto.Decryptor;
import org.apache.commons.io.IOUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

/**
 * @author grewalri
 *
 */
public class KeyDecryptor implements Decryptor<Key, byte[]>
{
	private static final Logger LOG = LoggerFactory.getLogger(KeyEncryptor.class);
	
	private static final String 
			PRIVATE_KEY_NAME = "EDDIRSAPrivate.key", 
			KEY_ENCRYPTION_ALGO	= "RSA";
	
	private String sharedKeyAlgorithm;
	
	public KeyDecryptor(String sharedKeyAlgorithm)
	{
		this.sharedKeyAlgorithm = sharedKeyAlgorithm;
	}
	
	public Key decrypt(byte[] sessionKey)
	{
		CipherInputStream cis = null;
		SecretKeySpec sharedKeySpec = null;
		
		try
		{
			Cipher decipher = Cipher.getInstance(KEY_ENCRYPTION_ALGO, new BouncyCastleProvider());
			InputStream in = getClass().getClassLoader().getResource(PRIVATE_KEY_NAME).openStream();
			
			// Read private RSA key to be used to decrypt the session key
			byte[] encodedKey = IOUtils.toByteArray(in);
			
			// Create private key
			PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(encodedKey);
			KeyFactory keyFactory = KeyFactory.getInstance(KEY_ENCRYPTION_ALGO);
			PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);
	
			// Now read the encrypted shared key and decipher
			decipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] sharedKey = new byte[16];
			cis = new CipherInputStream(new ByteArrayInputStream(sessionKey), decipher);
			cis.read(sharedKey);
			sharedKeySpec = new SecretKeySpec(sharedKey, sharedKeyAlgorithm);
		}
		catch(Exception ex)
		{
			LOG.error("Unable to decrypt key : ", ex);
		}
		finally
		{
			if(null != cis) IOUtils.closeQuietly(cis);
		}
		
		return sharedKeySpec;
	}
}
