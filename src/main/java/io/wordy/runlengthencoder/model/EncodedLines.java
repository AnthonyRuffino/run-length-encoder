package io.wordy.runlengthencoder.model;

public class EncodedLines {
    private final String value;
    private final int numberOfElements;

    public EncodedLines(String value, int numberOfElements) {
        this.value = value;
        this.numberOfElements = numberOfElements;
    }

    public String getValue() {
        return value;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }
}
