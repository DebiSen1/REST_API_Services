package com.upgrad.ControllerDemo.dto;

public class IdeaDTO {
    private int id;
    private String ideaTitle;
    private String ideDescription;
    private String ideaAuthor;

    public IdeaDTO(int id, String ideaTitle, String ideDescription, String ideaAuthor) {
        this.id = id;
        this.ideaTitle = ideaTitle;
        this.ideDescription = ideDescription;
        this.ideaAuthor = ideaAuthor;
    }

    public IdeaDTO(){
        //default constructor
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdeaTitle() {
        return ideaTitle;
    }

    public void setIdeaTitle(String ideaTitle) {
        this.ideaTitle = ideaTitle;
    }

    public String getIdeDescription() {
        return ideDescription;
    }

    public void setIdeDescription(String ideDescription) {
        this.ideDescription = ideDescription;
    }

    public String getIdeaAuthor() {
        return ideaAuthor;
    }

    public void setIdeaAuthor(String ideaAuthor) {
        this.ideaAuthor = ideaAuthor;
    }

    @Override
    public String toString() {
        return "IdeaDTO{" +
                "id=" + id +
                ", ideaTitle='" + ideaTitle + '\'' +
                ", ideDescription='" + ideDescription + '\'' +
                ", ideaAuthor='" + ideaAuthor + '\'' +
                '}';
    }
}
