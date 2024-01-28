package com.vl.words;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notifyAddWord(Word word){
        System.out.println("A new word has been created:  " + word.getName());
    }

    public void notifyDeleteWord(Word word){
        System.out.println("A word has been delete:  " + word.getName());
    }

    public void notifyUpdateWord(Word word){
        System.out.println("A word has been update:  " + word.getName());
    }
}
