package io.wordy.runlengthencoder.model;

import javax.persistence.*;

@Entity
public class CachedEncodedLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition="TEXT")
    private String encodedLine;
    private long startIndex;
    private long endIndex;

    private CachedEncodedLine() {
    }

    public CachedEncodedLine(String encodedLine, long startIndex, long endIndex) {
        this.encodedLine = encodedLine;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEncodedLine() {
        return encodedLine;
    }

    public void setEncodedLine(String encodedLine) {
        this.encodedLine = encodedLine;
    }

    public long getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(long startIndex) {
        this.startIndex = startIndex;
    }

    public long getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(long endIndex) {
        this.endIndex = endIndex;
    }
}
