package io.wordy.runlengthencoder.api;

import io.wordy.runlengthencoder.service.CharacterFetchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("")
@RestController
public class TestController {

    @Autowired
    CharacterFetchingService characterFetchingService;

    @GetMapping("/{index}")
    public char fetch(@PathVariable long index) {
        return characterFetchingService.getCharacterAtIndex(index);
    }
}
