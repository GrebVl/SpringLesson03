package com.vl.words;

import java.util.UUID;

public class Word {
    public enum Status {
        ADD,
        IN_PROGRESS,
        DONE
    }

    private UUID id;
    private String name;
    private String translation;
    private String sentence;
    private String description;
    private Status status;

    public Word(String name, String translation, String sentence) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.translation = translation;
        this.sentence = sentence;
        this.status = Status.ADD;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
