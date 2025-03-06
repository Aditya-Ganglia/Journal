package com.aditya.journal.repository;

import com.aditya.journal.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface JournalEntryRepository extends MongoRepository <JournalEntry, ObjectId>{//MongoRepository is a interface

}
