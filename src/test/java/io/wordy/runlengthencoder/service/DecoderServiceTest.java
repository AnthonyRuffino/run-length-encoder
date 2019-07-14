package io.wordy.runlengthencoder.service;

import io.wordy.runlengthencoder.exception.IndexNotInCachedEncodedLineException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DecoderServiceTest extends TestBase {

    private DecoderService decoderService;

    @Before
    public void setUp() throws Exception {
        decoderService = new DecoderService();
    }

    @Test
    public void getCharAtIndexTest1() {
        char result = decoderService.getCharAtIndex(ENCODED_RESULT, 13);
        assertEquals('B' + "", result + "");
    }

    @Test
    public void getCharAtIndexTest2() {
        char result = decoderService.getCharAtIndex(ENCODED_RESULT, 14);
        assertEquals('W' + "", result + "");
    }

    @Test(expected = IndexNotInCachedEncodedLineException.class)
    public void indexNotInCachedEncodedLineExceptionTest() {
        decoderService.getCharAtIndex(ENCODED_RESULT, 10000);
    }
}
