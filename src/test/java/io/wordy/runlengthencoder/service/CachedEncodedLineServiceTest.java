package io.wordy.runlengthencoder.service;

import io.wordy.runlengthencoder.exception.IndexNotYetCachedException;
import io.wordy.runlengthencoder.model.CachedEncodedLine;
import io.wordy.runlengthencoder.model.EncodedLines;
import io.wordy.runlengthencoder.repository.CachedEncodedLineRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;


public class CachedEncodedLineServiceTest extends TestBase {

    private CachedEncodedLineService cachedEncodedLineService;

    @Autowired
    private CachedEncodedLineRepository cachedEncodedLineRepository;

    @Before
    public void setUp() throws Exception {
        cachedEncodedLineService = new CachedEncodedLineService(cachedEncodedLineRepository);
    }

    @Test
    public void fetchCachedEncodedLine() {
        CachedEncodedLine line = cachedEncodedLineService.fetchCachedEncodedLine(1);
        assertEquals(line.getEncodedLine(), ENCODED_RESULT);
    }

    @Test
    public void fetchCachedEncodedLine2() {
        CachedEncodedLine line = cachedEncodedLineService.fetchCachedEncodedLine(68);
        assertEquals(line.getEncodedLine(), ENCODED_RESULT2);
    }

    @Test
    public void fetchCachedEncodedLine3() {
        CachedEncodedLine line = cachedEncodedLineService.fetchCachedEncodedLine(135);
        assertEquals(line.getEncodedLine(), ENCODED_RESULT3);
    }

    @Test(expected = IndexNotYetCachedException.class)
    public void fetchCachedEncodedLineIndexNotYetCachedException() {
        cachedEncodedLineService.fetchCachedEncodedLine(1000);
    }

    @Test
    public void cacheEncodedLineTest() {
        EncodedLines encodedLines = new EncodedLines(ENCODED_RESULT, 67);
        CachedEncodedLine line = cachedEncodedLineService.cacheEncodedLine(encodedLines);
        assertEquals(202, line.getStartIndex());
        assertEquals(202 + 66, line.getEndIndex());
    }
}
