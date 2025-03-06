package com.aditya.journal.entity;

//POJO - Plain Old Java Object

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document
@Data // for all getter setter constructor etc using lombok
public class JournalEntry {


    @Id //unique key , not neccessary
    private ObjectId id;
    private String title;
    private String content;
    private LocalDateTime date;

}
