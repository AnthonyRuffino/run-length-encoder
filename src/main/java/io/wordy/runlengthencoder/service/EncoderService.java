package io.wordy.runlengthencoder.service;

import io.wordy.runlengthencoder.model.EncodedLines;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;

@Service
public class EncoderService {
    public EncodedLines encode(BufferedReader reader) {

        StringBuffer result = new StringBuffer();

        String lastLine = null;
        int currentCount = 1;
        int totalCount = 0;
        try {
            while(reader.ready()) {
                totalCount++;
                String line = reader.readLine();
                if(line.equals(lastLine)) {
                    currentCount++;
                } else if(lastLine != null) {
                    result.append(currentCount).append(lastLine);
                    currentCount = 1;
                }
                lastLine = line;
            }
            result.append(currentCount).append(lastLine);
        } catch(Exception e) {
            throw new RuntimeException("OOPS", e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Error closing reader: " + e.getMessage());
            }
        }


        return new EncodedLines(result.toString(), totalCount);
    }
}
