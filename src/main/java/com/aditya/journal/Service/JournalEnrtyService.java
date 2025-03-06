package com.aditya.journal.Service;

import com.aditya.journal.entity.JournalEntry;
import com.aditya.journal.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEnrtyService {

@Autowired
    private JournalEntryRepository journalEntryRepository;

public void saveEntry (JournalEntry journalEntry){
    journalEntryRepository.save(journalEntry);
}
public List<JournalEntry> getAll(){
    return journalEntryRepository.findAll();
}
public Optional<JournalEntry> findById(ObjectId id){
    return  journalEntryRepository.findById(id);
}
public void delete(ObjectId id){
     journalEntryRepository.deleteById(id);
}
}
