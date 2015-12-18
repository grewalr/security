package com.mcgrewal.security.crypto.impl;

import com.mcgrewal.security.crypto.Decryptor;
import com.mcgrewal.security.utils.KeyUtils;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.common.io.Resources;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.security.Key;

import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

/**
 * @author grewalri
 *
 */
public class FileDecryptorTest
{
	private Decryptor<File, File> decryptor;
	private Key key;
	
	private static final String TEST_STRING = "THIS IS A TEST";
	private static String parentDir = Resources.getResource("crypto").getPath();
	private static File testFile = new File(parentDir, "testDecryptionFile.enc"); 
	private static File sessionKeyFile = new File(parentDir, "EDDISessionTest.key");
	private File actualResultFile;
	
	@Before
	public void setUp() throws Exception
	{
		Files.write(TEST_STRING, testFile, Charsets.UTF_8);
		key = KeyUtils.loadKeyFromFile(sessionKeyFile);
		decryptor = new FileDecryptor(key);
	}

	@Test
	public void testEncrypt() throws Exception
	{
		actualResultFile = decryptor.decrypt(testFile);
		assertThat(Files.toByteArray(actualResultFile), not(Files.toByteArray(testFile)));
	}

	@After
	public void tearDown() throws Exception
	{
		testFile.delete();
		actualResultFile.delete();		
		key = null;
		decryptor = null;
	}
}
