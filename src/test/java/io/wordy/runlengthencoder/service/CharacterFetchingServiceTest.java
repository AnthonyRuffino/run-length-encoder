package io.wordy.runlengthencoder.service;

import io.wordy.runlengthencoder.exception.IndexNotYetCachedException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class CharacterFetchingServiceTest extends TestBase {

    private CharacterFetchingService characterFetchingService;

    @Autowired
    private DecoderService decoderService;

    @Autowired
    private CachedEncodedLineService cachedEncodedLineService;

    @Before
    public void setUp() throws Exception {
        characterFetchingService = new CharacterFetchingService(cachedEncodedLineService, decoderService);
    }

    @Test
    public void getCharacterAtIndex1Test() {
        char w = characterFetchingService.getCharacterAtIndex(1);
        assertEquals('W'+"", w+"");
    }

    @Test
    public void getCharacterAtIndex68Test() {
        char x = characterFetchingService.getCharacterAtIndex(68);
        assertEquals('X'+"", x+"");
    }

    @Test
    public void getCharacterAtIndex80Test() {
        char x = characterFetchingService.getCharacterAtIndex(80);
        assertEquals('X'+"", x+"");
    }

    @Test
    public void getCharacterAtIndex81Test() {
        char b = characterFetchingService.getCharacterAtIndex(81);
        assertEquals('B'+"", b+"");
    }

    @Test
    public void getCharacterAtIndex135Test() {
        char z = characterFetchingService.getCharacterAtIndex(135);
        assertEquals('Z'+"", z+"");
    }

    @Test(expected = IndexNotYetCachedException.class)
    public void indexNotYetCachedExceptionTest() {
        characterFetchingService.getCharacterAtIndex(1000);
    }
}
