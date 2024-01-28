package com.vl.words;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/words")
public class WordController {
    private final WordService wordService;

    @Autowired
    public WordController(WordService wordService){
        this.wordService = wordService;
    }

    @RequestMapping(
            params = {"name", "translation", "sentence"},
            method = RequestMethod.POST)
    public ResponseEntity<Word> createWord(@RequestParam("name") String name, @RequestParam("translation") String translation, @RequestParam("sentence") String sentence){
        return new ResponseEntity<>(wordService.createWord(name, translation, sentence), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Word> getAllTask(){
        return wordService.getAllWords();
    }

    @GetMapping("/{id}")
    public Word getById(@PathVariable UUID id){
        return wordService.getWord(id);
    }

    @PostMapping
    public Word addById(@RequestBody Word word){
        return wordService.addWord(word);
    }

    @PutMapping("/{id}")
    public Word getById(@PathVariable UUID id, @RequestBody Word word){
        return wordService.updateTask(id, word);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        wordService.deleteWord(id);
    }
}
