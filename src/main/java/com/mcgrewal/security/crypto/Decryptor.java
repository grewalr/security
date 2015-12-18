package com.mcgrewal.security.crypto;

/**
 * @author grewalri
 *
 */
public interface Decryptor<T1, T2>
{
	T1 decrypt(T2 input);
}
