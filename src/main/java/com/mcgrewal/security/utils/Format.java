package com.mcgrewal.security.utils;

/**
 * @author grewalri
 *
 */
public class Format
{
	private Format()
	{}
	
	public static String value(short[] cipher)
	{
		byte[] clearBytes = new byte[cipher.length];
		
		for(int i = 0; i < cipher.length; i++)
		{
			clearBytes[i] = (byte) ~cipher[i];
		}
		
		return new String(clearBytes);
	}
}
