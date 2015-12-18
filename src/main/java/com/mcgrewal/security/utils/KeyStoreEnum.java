package com.mcgrewal.security.utils;

import java.security.Key;

/**
 * @author grewalri
 *
 */
public enum KeyStoreEnum 
{
	INSTANCE;
	
	private static Key localkey;
	private static byte[] localEncodedKey;

	public static void setKey(Key key)
	{
		localkey = key;
	}

	public static Key getKey()
	{
		return localkey;
	}
	
	public static void setEncodedKey(byte[] encodedKey)
	{
		localEncodedKey = encodedKey;
	}
	
	public static byte[] getEncodedKey()
	{
		return localEncodedKey;
	}
}