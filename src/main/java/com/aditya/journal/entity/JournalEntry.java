package com.aditya.journal.entity;

//POJO - Plain Old Java Object

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.Date;

@Document
public class JournalEntry {


    @Id //unique key , not neccessary
    private ObjectId id;
    private String title;
    private String content;
    private LocalDateTime date;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }



    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }



    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }



}
