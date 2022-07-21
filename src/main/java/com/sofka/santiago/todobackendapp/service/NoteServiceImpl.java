package com.sofka.santiago.todobackendapp.service;

import com.sofka.santiago.todobackendapp.entity.Note;
import com.sofka.santiago.todobackendapp.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class NoteServiceImpl implements NoteService{

    private final NoteRepository repository;

    public NoteServiceImpl(NoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Note> findAllNotes() {
        return repository.findAll();
    }

    @Override
    public Note saveNote(Note note) {
        Objects.requireNonNull(note);
        return repository.save(note);
    }

    @Override
    public Note findNoteByID(Long id) {
        Objects.requireNonNull(id);
        return repository.findById(id).get();
    }

    @Override
    public Note updateNote(Note note) {
        Objects.requireNonNull(note);
        Objects.requireNonNull(note.getId());
        note.oneTimeModified();
        repository.save(note);
        return note;
    }

    @Override
    public void deleteNote(Long id) {
        repository.deleteById(id);
    }
}
