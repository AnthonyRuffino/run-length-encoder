package io.wordy.runlengthencoder.service;

import io.wordy.runlengthencoder.model.CachedEncodedLine;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class CharacterFetchingService {
    private CachedEncodedLineService cachedEncodedLineService;
    private DecoderService decoder;

    public CharacterFetchingService(CachedEncodedLineService cachedEncodedLineService, DecoderService decoder) {
        this.cachedEncodedLineService = cachedEncodedLineService;
        this.decoder = decoder;
    }


    //10022069
    //10568321
    public char getCharacterAtIndex(long index) {
        CachedEncodedLine cachedEncodedLine = cachedEncodedLineService.fetchCachedEncodedLine(index);
        long indexInEncodedLine = (index - cachedEncodedLine.getStartIndex());
        return decoder.getCharAtIndex(cachedEncodedLine.getEncodedLine(), indexInEncodedLine);
    }
}
