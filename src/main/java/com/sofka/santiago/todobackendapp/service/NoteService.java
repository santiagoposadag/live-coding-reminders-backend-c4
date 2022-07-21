package com.sofka.santiago.todobackendapp.service;

import com.sofka.santiago.todobackendapp.entity.Note;

import java.util.List;

public interface NoteService {

    List<Note> findAllNotes();
    Note saveNote(Note note);
    Note findNoteByID(Long id);
    Note updateNote(Note note);
    void deleteNote(Long id);
}
