package com.vl.words;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class WordService {
    private final List<Word> words = new ArrayList<>();
    private NotificationService notificationService;

    public WordService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public List<Word> getAllWords(){
        return words;
    }

    public Word getWord(UUID uuid){
        return words.stream().filter(t ->t.getId().equals(uuid)).findFirst().orElse(null);
    }

    public Word addWord(Word word){
        words.add(word);
        notificationService.notifyAddWord(word);
        return word;
    }

    public Word createWord(String name, String translation, String sentence){
        Word word = new Word(name, translation, sentence);
        return addWord(word);
    }

    public void deleteWord(UUID uuid){
        Word word = getWord(uuid);
        notificationService.notifyDeleteWord(word);
        words.remove(word);
    }

    public Word updateTask(UUID uuid, Word wordNew){
        Word word1 = getWord(uuid);
        if(word1 != null){
            word1.setDescription(wordNew.getDescription());
            word1.setName(wordNew.getName());
            word1.setSentence(wordNew.getSentence());
            word1.setTranslation(wordNew.getTranslation());
            word1.setStatus(wordNew.getStatus());
        }
        notificationService.notifyUpdateWord(word1);
        return word1;
    }
}
