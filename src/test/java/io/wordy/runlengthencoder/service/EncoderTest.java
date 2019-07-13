package io.wordy.runlengthencoder.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EncoderTest {

    private Encoder encoder;

    public static String INPUT = "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWBWWWWWWWWWWWWWW";
    public static String RESULT = "12W1B12W3B24W1B14W";

    @Before
    public void setUp() throws Exception {
        encoder = new Encoder();
    }

    @Test
    public void encode() {
        String result = encoder.encode(INPUT);
        assertEquals(RESULT, result);
    }
}
