package com.mcgrewal.security.algorithm;

import org.bouncycastle.crypto.digests.GOST3411Digest;
import org.bouncycastle.crypto.digests.MD2Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.NullDigest;
import org.bouncycastle.crypto.digests.RIPEMD128Digest;
import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.crypto.digests.RIPEMD256Digest;
import org.bouncycastle.crypto.digests.RIPEMD320Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.digests.TigerDigest;
import org.bouncycastle.crypto.digests.WhirlpoolDigest;

/**
 * @author grewalri
 *
 */
public enum DigestAlgorithmFactory
{
	// SHA Algorithm
	SHA1 		{@Override public HashedAlgorithm getDigest() { return new HashedAlgorithm(new SHA1Digest());}},
	SHA224 		{@Override public HashedAlgorithm getDigest() { return new HashedAlgorithm(new SHA224Digest());}},
	SHA256 		{@Override public HashedAlgorithm getDigest() { return new HashedAlgorithm(new SHA256Digest());}},
	SHA384 		{@Override public HashedAlgorithm getDigest() { return new HashedAlgorithm(new SHA384Digest());}},
	SHA512 		{@Override public HashedAlgorithm getDigest() { return new HashedAlgorithm(new SHA512Digest());}},
	
	// MD Algorithm
	MD2 		{@Override public HashedAlgorithm getDigest() { return new HashedAlgorithm(new MD2Digest());}},
	MD4 		{@Override public HashedAlgorithm getDigest() { return new HashedAlgorithm(new MD4Digest());}},
	MD5 		{@Override public HashedAlgorithm getDigest() { return new HashedAlgorithm(new MD5Digest());}},

	// RIPEMD Algorithm (RACE Integrity Primitives Evaluation Message Digest)
	RIPEMD128 	{@Override public HashedAlgorithm getDigest() { return new HashedAlgorithm(new RIPEMD128Digest());}},
	RIPEMD160 	{@Override public HashedAlgorithm getDigest() { return new HashedAlgorithm(new RIPEMD160Digest());}},
	RIPEMD256 	{@Override public HashedAlgorithm getDigest() { return new HashedAlgorithm(new RIPEMD256Digest());}},
	RIPEMD320 	{@Override public HashedAlgorithm getDigest() { return new HashedAlgorithm(new RIPEMD320Digest());}},

	// Miscellaneous Algorithms
	GOST3411 	{@Override public HashedAlgorithm getDigest() { return new HashedAlgorithm(new GOST3411Digest());}},
	
	// http://www.cs.technion.ac.il/~biham/Reports/Tiger
	TIGER 		{@Override public HashedAlgorithm getDigest() { return new HashedAlgorithm(new TigerDigest());}},
		
	// http://www.larc.usp.br/~pbarreto/WhirlpoolPage.html
	WHIRLPOOL 	{@Override public HashedAlgorithm getDigest() { return new HashedAlgorithm(new WhirlpoolDigest());}},
		
	// No operation
	NOOP 		{@Override public HashedAlgorithm getDigest() { return new HashedAlgorithm(new NullDigest());}};
	
	public abstract HashedAlgorithm getDigest();
}