package io.wordy.runlengthencoder.service;

import io.wordy.runlengthencoder.exception.IndexNotYetCachedException;
import io.wordy.runlengthencoder.model.CachedEncodedLine;
import io.wordy.runlengthencoder.model.EncodedLines;
import io.wordy.runlengthencoder.repository.CachedEncodedLineRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class CachedEncodedLineService {
    private CachedEncodedLineRepository cachedEncodedLineRepository;
    private EncoderService encoderService;

    public CachedEncodedLineService(CachedEncodedLineRepository cachedEncodedLineRepository) {
        this.cachedEncodedLineRepository = cachedEncodedLineRepository;
    }

    public CachedEncodedLine fetchCachedEncodedLine(long index) {
        return cachedEncodedLineRepository.findByIndex(index)
                .orElseThrow(() -> new IndexNotYetCachedException("This index has not been fetched yet: " + index));
    }

    public CachedEncodedLine cacheEncodedLine(EncodedLines encodedLines) {
        Long lastEndIndex = cachedEncodedLineRepository.findLastCachedEncodedLine();
        long startIndex = lastEndIndex == null ? 1 : (lastEndIndex + 1);
        CachedEncodedLine cachedEncodedLine = new CachedEncodedLine(encodedLines.getValue(), startIndex, startIndex + (encodedLines.getNumberOfElements() - 1));
        cachedEncodedLineRepository.save(cachedEncodedLine);
        return cachedEncodedLine;
    }
}
