package com.mcgrewal.security.crypto.impl;

import com.mcgrewal.security.crypto.Encryptor;
import com.mcgrewal.security.utils.KeyUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.security.Key;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

/**
 * @author grewalri
 *
 */
public class KeyEncryptorTest
{
	private Encryptor<byte[], Key> keyEncryptor;
	private Key key;
	
	@Before
	public void setUp() throws Exception
	{
		keyEncryptor = new KeyEncryptor();
		key = KeyUtils.createKey("AES");
	}

	/**
	 * Test method for {@link com.mcgrewal.security.crypto.impl.KeyEncryptor#encrypt(java.security.Key)}.
	 */
	@Test
	public final void testEncrypt()
	{
		byte[] keyBytes = keyEncryptor.encrypt(key);
		assertThat(keyBytes, notNullValue());
	}

	@After
	public void tearDown() throws Exception
	{
		keyEncryptor = null;
		key = null;
	}
}
