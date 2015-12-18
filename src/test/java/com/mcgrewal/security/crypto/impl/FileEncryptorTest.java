package com.mcgrewal.security.crypto.impl;

import com.mcgrewal.security.crypto.Encryptor;
import com.mcgrewal.security.utils.KeyUtils;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.common.io.Resources;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.security.Key;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author grewalri
 *
 */
public class FileEncryptorTest
{
	private Encryptor<File, File> encryptor;
	private Key key;
	
	private static final String TEST_STRING = "THIS IS A TEST";
	private static final byte[] expectedBytes = {104, 92, -65, -60, 59, 29, -114, 86, -95, 28, -64, -59, -73, 10, -53, -18};
	
	private static String parentDir = Resources.getResource("crypto").getPath();
	private static File testFile = new File(parentDir, "testEncryptionFile");
	private static File sessionKeyFile = new File(parentDir, "EDDISessionTest.key");
	private File actualResultFile;
	
	@Before
	public void setUp() throws Exception
	{
		Files.write(TEST_STRING, testFile, Charsets.UTF_8);
		key = KeyUtils.loadKeyFromFile(sessionKeyFile);
		encryptor = new FileEncryptor(key);
	}

	@Test
	public void testEncrypt() throws Exception
	{
		actualResultFile = encryptor.encrypt(testFile);
		assertThat(Files.toByteArray(actualResultFile), equalTo(expectedBytes));
	}

	@After
	public void tearDown() throws Exception
	{
		actualResultFile.delete();
		testFile.delete();
		key = null;
		encryptor = null;
	}
}
