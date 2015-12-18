package com.mcgrewal.security.encoding;

import com.mcgrewal.security.algorithm.DigestAlgorithmFactory;
import com.mcgrewal.security.algorithm.HashedAlgorithm;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class DictionaryTest
{
    private static final Logger LOG = LoggerFactory.getLogger(DictionaryTest.class);

    private String hashedAlgo, expectedResult, seed;
    private byte[] input;
    private Encoder<String, byte[]> dictEnc;

    @Parameters
    public static Collection<Object[]> data()
    {
        // Collection of test parameters to test
        Collection<Object[]> returnCollection = Arrays.asList(new Object[][]
                                                                      {
                                                                              // MD4
                                                                              {"MD4", "This is a test.".getBytes(), "TeSt", "RubeCoveCadySwagHotSpy"},
                                                                              {"MD4", "AbCdEfGhIjK".getBytes(), "alpha1", "OsloVentScanSitsCladEdit"},
                                                                              {"MD4", "OTP's are good".getBytes(), "correct", "SideBigSaveBootTateNut"},

                                                                              // MD5
                                                                              {"MD5", "This is a test.".getBytes(), "TeSt", "LineWontHoseFinBegHulk"},
                                                                              {"MD5", "AbCdEfGhIjK".getBytes(), "alpha1", "DebtBombLineCubeWavyHyde"},
                                                                              {"MD5", "OTP's are good".getBytes(), "correct", "EmilArgoLootMudOilyLain"},

                                                                              // SHA256
                                                                              {"SHA256", "This is a test.".getBytes(), "TeSt", "RothRidFinWayHelmLost"},
                                                                              {"SHA256", "AbCdEfGhIjK".getBytes(), "alpha1", "LopWheeNellLipClawChad"},
                                                                              {"SHA256", "OTP's are good".getBytes(), "correct", "KiteNewNutYokeGownEtc"},

                                                                              // SHA512
                                                                              {"SHA512", "This is a test.".getBytes(), "TeSt", "LeonEaseTeemDramBakeBog"},
                                                                              {"SHA512", "AbCdEfGhIjK".getBytes(), "alpha1", "JavaNedMeadEdAlpBog"},
                                                                              {"SHA512", "OTP's are good".getBytes(), "correct", "RoamHostCotQuitLeaAd"}
                                                                      });

        return returnCollection;
    }

    public DictionaryTest(String hashedAlgo, byte[] input, String seed, String expectedResult)
    {
        this.hashedAlgo = hashedAlgo;
        this.input = input;
        this.seed = seed;
        this.expectedResult = expectedResult;
    }


    @Before
    public void setUp() throws Exception
    {
        dictEnc = EncoderFactory.DICTIONARY.getEncoder();
        HashedAlgorithm digest = DigestAlgorithmFactory.valueOf(hashedAlgo).getDigest();
        digest.setSeed(seed);
        dictEnc.setHashedAlgorithm(digest);
    }

    @Test
    public void testEncode()
    {
        String actualResult = dictEnc.encode(input);

        if (LOG.isDebugEnabled())
        {
            LOG.debug("\thashed algorithm : {}, \tencoder : DICTIONARY, \tinput : {}, \texpectedResult : {}, \tactualResult : {}",
                      hashedAlgo, input, expectedResult, actualResult);
        }

        assertThat(actualResult, equalTo(expectedResult));
    }

    @After
    public void tearDown() throws Exception
    {
        dictEnc = null;
    }
}
