package io.wordy.runlengthencoder.service;

import io.wordy.runlengthencoder.model.EncodedLines;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

@ConditionalOnProperty(
        value = "app.scheduling.enable", havingValue = "true", matchIfMissing = true
)
@Configuration
@EnableScheduling
@Profile({"!test"})
public class DataFetchingService {

    private static Logger LOGGER = LoggerFactory.getLogger(DataFetchingService.class);

    private CachedEncodedLineService cachedEncodedLineService;
    private EncoderService encoderService;

    @Value("${characterService}")
    private String characterService;


    public DataFetchingService(CachedEncodedLineService cachedEncodedLineService, EncoderService encoderService) {
        this.cachedEncodedLineService = cachedEncodedLineService;
        this.encoderService = encoderService;
    }

    @Scheduled(fixedDelayString = "${fetchDelay}")
    public void fetchAndCache() {

        try {
            URL url = new URL(characterService);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            InputStream stream = con.getInputStream();
            EncodedLines encodedLines = encoderService.encode(new BufferedReader(new InputStreamReader(stream)));
            cachedEncodedLineService.cacheEncodedLine(encodedLines);
        } catch (IOException e) {
            LOGGER.warn("There was an exception while logging the data from the remote character service", e);
        }
    }
}
