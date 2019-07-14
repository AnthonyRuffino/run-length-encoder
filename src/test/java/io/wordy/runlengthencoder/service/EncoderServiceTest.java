package io.wordy.runlengthencoder.service;

import io.wordy.runlengthencoder.model.EncodedLines;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;

public class EncoderServiceTest extends TestBase {

    private EncoderService encoderService;


    private static BufferedReader getData() {
        StringBuffer sb = new StringBuffer();
        for (int c : INPUT.chars().toArray()) {
            sb.append((char) c).append("\n");
        }
        return new BufferedReader(new InputStreamReader(new ByteArrayInputStream(sb.toString().getBytes())));
    }

    @Before
    public void setUp() {
        encoderService = new EncoderService();

    }

    @Test
    public void encode() {
        EncodedLines result = encoderService.encode(getData());
        assertEquals(ENCODED_RESULT, result.getValue());
        assertEquals(INPUT.length(), result.getNumberOfElements());

    }
}
