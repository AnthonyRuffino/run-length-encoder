package io.wordy.runlengthencoder.service;

import io.wordy.runlengthencoder.RunLengthEncoderApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@Transactional
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunLengthEncoderApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class TestBase {
    public static String INPUT = "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWBWWWWWWWWWWWWWW";
    public static String ENCODED_RESULT = "12W1B12W3B24W1B14W";
    public static String ENCODED_RESULT2 = "12X1B12W3B24W1B14X";
    public static String ENCODED_RESULT3 = "12Z1B12W3B24W1B14Z";

    @Test
    public void contextLoads() {
    }
}
