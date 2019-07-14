package io.wordy.runlengthencoder.exception;

public class IndexNotInCachedEncodedLineException extends RunLengthEncodingException {
    public IndexNotInCachedEncodedLineException(String message) {
        super(message);
    }
}
