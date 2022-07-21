package com.sofka.santiago.todobackendapp.controller;

import com.sofka.santiago.todobackendapp.entity.Note;
import com.sofka.santiago.todobackendapp.service.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin("*")
public class NoteController {

    @Autowired
    private NoteServiceImpl service;

    @GetMapping("get/all/notes")
    public List<Note> findAllNotes(){
        return service.findAllNotes();
    }

    @GetMapping("find/{id}")
    public Note findNoteByID(@PathVariable Long id){
        return service.findNoteByID(id);
    }

    @PostMapping("save/note")
    public Note saveNote(@RequestBody Note note){
        return service.saveNote(note);
    }

    @PutMapping("update/note")
    public Note updateNote(@RequestBody Note note){
        return service.updateNote(note);
    }

    @DeleteMapping("delete/note/{id}")
    public void deleteNote(@PathVariable Long id){
        service.deleteNote(id);
    }
}
