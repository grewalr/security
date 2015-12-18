package com.mcgrewal.security.encoding;

import com.mcgrewal.security.algorithm.HashedAlgorithm;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.BinaryCodec;
import org.apache.commons.codec.binary.Hex;

import java.math.BigInteger;


/**
 * @author grewalri
 * 
 */
@SuppressWarnings("unchecked")
public enum EncoderFactory
{
	HEX
	{
		@Override
		public Encoder<String, byte[]> getEncoder()
		{
			return new Encoder<String, byte[]>()
			{
				@Override
				public String encode(byte[] bytes)
				{
					return Hex.encodeHexString(bytes);
				}

				@Override
				public void setHashedAlgorithm(HashedAlgorithm algo)
				{
					// NO IMPLEMENTATION
				}
			};
		}
	},

	BASE32
	{
		@Override
		public Encoder<String, byte[]> getEncoder()
		{
			return new Encoder<String, byte[]>()
			{
				@Override
				public String encode(byte[] bytes)
				{
					Base32 base32 = new Base32();
					return base32.encodeToString(bytes);
				}

				@Override
				public void setHashedAlgorithm(HashedAlgorithm algo)
				{
					// NO IMPLEMENTATION
				}
			};
		}
	},

	BASE64
	{
		@Override
		public Encoder<String, byte[]> getEncoder()
		{
			return new Encoder<String, byte[]>()
			{
				@Override
				public String encode(byte[] bytes)
				{
					return Base64.encodeBase64String(bytes);
				}

				@Override
				public void setHashedAlgorithm(HashedAlgorithm algo)
				{
					// NO IMPLEMENTATION
				}
			};
		}
	},

	BINARY
	{
		@Override
		public Encoder<String, byte[]> getEncoder()
		{
			return new Encoder<String, byte[]>()
			{
				@Override
				public String encode(byte[] bytes)
				{
					return BinaryCodec.toAsciiString(bytes);
				}

				@Override
				public void setHashedAlgorithm(HashedAlgorithm algo)
				{
					// NO IMPLEMENTATION
				}
			};
		}
	},

	INTEGER
	{
		@Override
		public Encoder<String, byte[]> getEncoder()
		{
			return new Encoder<String, byte[]>()
			{
				@Override
				public String encode(byte[] input)
				{
					return new BigInteger(input).toString();
				}

				@Override
				public void setHashedAlgorithm(HashedAlgorithm algo)
				{
					// NO IMPLEMENTATION
				}
			};
		}
	},

	XMASKED
	{
		@Override
		public Encoder<String, byte[]> getEncoder()
		{
			return new Encoder<String, byte[]>()
			{
				@Override
				public String encode(byte[] input) 
				{
					String value = new String(input);
					return value.replaceAll(".", "X");
				}

				@Override
				public void setHashedAlgorithm(HashedAlgorithm algo)
				{
					// NO IMPLEMENTATION
				}
			};
		}
	},

	BUBBLEBABBLE
	{
		@Override
		public Encoder<String, byte[]> getEncoder()
		{
			return new BubbleBabble();
		}
	},
	
	DICTIONARY
	{
		@Override
		public Encoder<String, byte[]> getEncoder()
		{
			return new Dictionary();
		}
	},
	
	NOOP
	{
		@Override
		public Encoder<String, byte[]> getEncoder()
		{
			return new Encoder<String, byte[]>()
			{
				@Override
				public String encode(byte[] input) 
				{
					return new String(input);
				}

				@Override
				public void setHashedAlgorithm(HashedAlgorithm algo)
				{
					// NO IMPLEMENTATION
				}
			};
		}
	};

	public abstract <T1, T2> Encoder<T1, T2> getEncoder();
}
