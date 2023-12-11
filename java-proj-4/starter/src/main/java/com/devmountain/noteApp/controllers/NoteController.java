package com.devmountain.noteApp.controllers;

import com.devmountain.noteApp.dtos.NoteDto;
import com.devmountain.noteApp.services.NoteService;
import com.devmountain.noteApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {

    @Autowired
    private UserService userService;
    @Autowired
    private NoteService noteService;

    @GetMapping("users/{userid}")
    public List<NoteDto>  getNotesByUser(@PathVariable Long userId) {
        return noteService.getAllNotesByUserId(userId);
    }

    @PostMapping("users/{userid}")
    public void addNote(@RequestBody NoteDto noteDto, @PathVariable Long userId) {
        noteService.addNote(noteDto, userId);
    }

    @DeleteMapping("{noteId}")
    public void deleteNoteById(Long noteId) {
        noteService.deleteNoteById(noteId);
    }

    @PutMapping
    public void updateNote (NoteDto noteDto) {
        noteService.updatingNoteById(noteDto);
    }

    @GetMapping("{noteId}")
    public Optional<NoteDto> getNoteById (@PathVariable Long noteId) {
        return noteService.getNoteById(noteId);
    }

}
