package io.wordy.runlengthencoder.service;

import io.wordy.runlengthencoder.exception.IndexNotInCachedEncodedLineException;
import org.springframework.stereotype.Service;

@Service
public class DecoderService {

    public char getCharAtIndex(String runLengthEncodedInput, long index) {
        StringBuffer currentNumber = new StringBuffer();
        int currentIndex = 0;
        for(int c : runLengthEncodedInput.chars().toArray()) {
            if(Character.isDigit(c)) {
                currentNumber.append((char)c);
            } else {
                currentIndex += (Integer.parseInt(currentNumber.toString()));
                if(index <= currentIndex) {
                    return (char)c;
                }
                currentNumber.setLength(0);
            }
        }
        throw new IndexNotInCachedEncodedLineException("Index not in current cached encoded line");
    }
}
