package com.sofka.santiago.todobackendapp.service;

import com.sofka.santiago.todobackendapp.entity.Note;
import com.sofka.santiago.todobackendapp.repository.NoteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class NoteServiceImplTest {

    private NoteServiceImpl service;

    @Mock
    private NoteRepository repository;


    @BeforeEach
    void setUp(){
        service = new NoteServiceImpl(repository);
    }

    @Test
    void updateNoteTest(){
        //Arrange
        Note note = new Note();
        note.setId(3168549L);
        note.setTitle("title test");
        note.setReminder("reminder test");
        note.setDate("date test");

        Note noteResponse = new Note();
        noteResponse.setId(3168549L);
        noteResponse.setTitle("title test");
        noteResponse.setReminder("reminder test");
        noteResponse.setDate("date test");
        noteResponse.setNumberOfTimesModified(1L);

        Mockito.when(repository.save(any(Note.class))).thenReturn(noteResponse);

        //Act
        System.out.println("note before updating: " + note.toString());
        var response = service.updateNote(note);
        System.out.println("note after updating: " + response.toString());
        //Assert
        Assertions.assertEquals(response.getNumberOfTimesModified(), noteResponse.getNumberOfTimesModified());
        Mockito.verify(repository).save(note);
    }
}