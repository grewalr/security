package com.mcgrewal.security.crypto.impl;

import com.mcgrewal.security.crypto.Encryptor;
import org.apache.commons.io.IOUtils;
import org.bouncycastle.crypto.RuntimeCryptoException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author grewalri
 *
 */
public class KeyEncryptor implements Encryptor<byte[], Key>
{
	private static final Logger LOG = LoggerFactory.getLogger(KeyEncryptor.class);
	
	private static final String 
			PUBLIC_KEY_NAME = "crypto/EDDIRSAPublic.key", 
			KEY_ENCRYPTION_ALGO	= "RSA";
	
	/**
	 * @throws RuntimeCryptoException
	 */
	@Override
	public byte[] encrypt(Key keySpec)
	{
		CipherOutputStream cos = null; 
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try
		{
			Cipher encipher = Cipher.getInstance(KEY_ENCRYPTION_ALGO, new BouncyCastleProvider());
			InputStream in = getClass().getClassLoader().getResource(PUBLIC_KEY_NAME).openStream();
			
			// Read public RSA key to be used to encrypt the session key
			byte[] encodedKey = IOUtils.toByteArray(in);
	
			// Create the public key
			X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(encodedKey);
			KeyFactory keyFactory = KeyFactory.getInstance(KEY_ENCRYPTION_ALGO);
			PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
			
			// Now register the encrypted shared key
			encipher.init(Cipher.ENCRYPT_MODE, publicKey);
			cos = new CipherOutputStream(baos, encipher);
			cos.write(keySpec.getEncoded());
		}
		catch(Exception ex)
		{
			LOG.error("Unable to encrypt key : ", ex);
			throw new RuntimeCryptoException();
		}
		finally
		{
			if(null != cos) IOUtils.closeQuietly(cos);
		}

		return baos.toByteArray();
	}
}
