package com.mcgrewal.security.encoding;

import com.mcgrewal.security.algorithm.HashedAlgorithm;

/**
 * @author grewalri
 * @see <a href="http://wiki.yak.net/589">http://wiki.yak.net/589</a>
 * 
 */
public class BubbleBabble implements Encoder<String, byte[]>
{
	private static final char[] VOWELS = "aeiouy".toCharArray();
	private static final char[] CONSONANTS = "bcdfghklmnprstvzx".toCharArray();

	@Override
	public String encode(byte[] input)
	{
		int seed = 1;
		int byteLetter1;
		int byteLetter2;
		
		StringBuilder sb = new StringBuilder();
		
		// Added to the start 
		sb.append(CONSONANTS[16]);
		
		for(int i = 0 ;; i += 2)
		{
			if (i >= input.length)
			{
				sb.append(VOWELS[seed % 6]);
				sb.append(CONSONANTS[16]);
				sb.append(VOWELS[seed / 6]);
				break;
			}
			
			byteLetter1 = input[i] & 0xffff; // Ensure that the last 8 bits are returned 
			sb.append(VOWELS[(((byteLetter1 >> 6) & 3) + seed) % 6]);
			sb.append(CONSONANTS[(byteLetter1 >> 2) & 15]);
			sb.append(VOWELS[((byteLetter1 & 3) + (seed / 6)) % 6]);
			
			if (i + 1 >= input.length) break;
			
			byteLetter2 = input[i + 1] & 0xffff;
			sb.append(CONSONANTS[(byteLetter2 >> 4) & 15]);
			sb.append('-');
			sb.append(CONSONANTS[byteLetter2 & 15]);
			
			// Reseed calculated on mainly reshuffling the vowels to give randomness
			seed = (seed * 5 + byteLetter1 * 7 + byteLetter2) % 36;
		}
		
		// Append 'x' to the end of the string builder
		sb.append(CONSONANTS[16]);
		
		return sb.toString();
	}

	@Override
	public void setHashedAlgorithm(HashedAlgorithm algo)
	{
		// NOT IMPLEMENTED		
	}
}
