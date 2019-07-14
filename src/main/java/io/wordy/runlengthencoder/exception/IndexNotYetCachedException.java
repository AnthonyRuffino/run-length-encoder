package io.wordy.runlengthencoder.exception;

public class IndexNotYetCachedException extends RunLengthEncodingException {
    public IndexNotYetCachedException(String message) {
        super(message);
    }
}
