package com.mcgrewal.security.encoding;

import com.mcgrewal.security.algorithm.Algorithm;
import com.mcgrewal.security.algorithm.HashedAlgorithm;
import org.bouncycastle.crypto.Digest;

import java.nio.ByteBuffer;

import static com.mcgrewal.security.encoding.DictionaryWords.WORDS;

/**
 * @author grewalri
 *
 */
public class Dictionary implements Encoder<String, byte[]>
{
	private Algorithm<byte[], String> algo;
	
	@Override
	public String encode(byte[] input)
	{
		String valueStr = new String(input);
		valueStr = algo.getSeed().toLowerCase() + valueStr;
		
		Digest digest = algo.getDigest();
		
		digest.update(valueStr.getBytes(), 0, valueStr.length());
		byte[] hash = new byte[digest.getDigestSize()];
		digest.doFinal(hash, 0);

		return getDictionaryString(hash);
	}

	@Override
	public void setHashedAlgorithm(HashedAlgorithm algo)
	{
		this.algo = algo;
	}

	private String getDictionaryString(byte[] hash)
	{
		long word;
		String tmpstr;
		int i;
		byte parity;

		// Convert hash to long
		ByteBuffer buffer = ByteBuffer.allocate(hash.length);
	    buffer.put(hash);
	    buffer.flip();
	    word = buffer.getLong(); 
		
		tmpstr = "";
		parity = 0;
		
		for(i = 4; i >= 0; i--)
		{
			int wordIndex = (int) ((word >> (i * 11 + 9)) & 0x7ff);
			tmpstr += btoe(wordIndex);
		}
		
		tmpstr += btoe((int) ((word << 2) & 0x7fc) | (parity & 0x3));
		return tmpstr;
	}

	private String btoe(int index)
	{
		index = index % WORDS.length;
		return WORDS[index];
	}
}
