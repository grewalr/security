package com.mcgrewal.security.crypto;

/**
 * @author grewalri
 *
 */
public interface Encryptor<T1, T2>
{
	T1 encrypt(T2 input);
}
