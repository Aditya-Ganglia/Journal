package com.aditya.journal.controller;

import com.aditya.journal.Service.JournalEnrtyService;
import com.aditya.journal.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {
    @Autowired
    private JournalEnrtyService journalEnrtyService;

    @GetMapping("/get_journal_entries")
    public List<JournalEntry> getAll() {
        return  journalEnrtyService.getAll();
    }

    @PostMapping("/create_journal_entries")
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        journalEnrtyService.saveEntry(myEntry);
        return  true;
    }
    @GetMapping("/get_by_id/{myId}")
    public ResponseEntity<JournalEntry> getById(@PathVariable ObjectId myId) {
        return journalEnrtyService.findById(myId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/update/{myId}")
    public JournalEntry updateEntry(@PathVariable ObjectId myId ,@RequestBody JournalEntry newEntry){
    JournalEntry old = journalEnrtyService.findById(myId).orElse(null);
    if(old!=null){
        old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("") ? newEntry.getTitle():old.getTitle());
        old.setContent(newEntry.getContent()!=null && !newEntry.equals("")? newEntry.getContent():old.getContent());;
    }
    journalEnrtyService.saveEntry(old);
        return  old;
    }
    @DeleteMapping("/delete/{myId}")
    public boolean deleteEntry(@PathVariable ObjectId myId){
        journalEnrtyService.delete(myId);
        return true;
    }
}

