package com.team_work_java.team_work_java.dto;

import java.util.UUID;

public class RecommendationDto {
    private UUID id;
    private String name;
    private String text;

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
