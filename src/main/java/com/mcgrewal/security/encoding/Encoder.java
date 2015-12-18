package com.mcgrewal.security.encoding;

import com.mcgrewal.security.algorithm.HashedAlgorithm;

/**
 * @author grewalri
 *
 */
public interface Encoder<T1,T2>
{
	T1 encode(T2 input);
	
	void setHashedAlgorithm(HashedAlgorithm algo);
}
