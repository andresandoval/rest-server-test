package com.example.demo;

import java.time.LocalDate;
import java.util.UUID;


public class FilePostDTO {
    private final UUID ownerId;

    private final String name;

    private final String description;

    private final UUID subjectId;

    private final String language;

    private final String notes;

    private final LocalDate publishingDate;

    private final String clazz = "FILE";

    public FilePostDTO(UUID ownerId, String name, String description, UUID subjectId, String language,
                       String notes, LocalDate publishingDate) {
        this.ownerId = ownerId;
        this.name = name;
        this.description = description;
        this.subjectId = subjectId;
        this.language = language;
        this.notes = notes;
        this.publishingDate = publishingDate;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public UUID getSubjectId() {
        return subjectId;
    }

    public String getLanguage() {
        return language;
    }

    public String getNotes() {
        return notes;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public String getClazz() {
        return clazz;
    }
}
