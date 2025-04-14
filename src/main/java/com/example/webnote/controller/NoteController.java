package com.example.webnote.controller;

import com.example.webnote.model.Note;
import com.example.webnote.repository.NoteRepository;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*public class NoteController {
    
}*/

@Controller
@RequestMapping("/notes")
public class NoteController {

    private final NoteRepository repo;

    public NoteController(NoteRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public String listNotes(Model model) {
        model.addAttribute("notes", repo.findAll());
        return "note-list";
    }

    @GetMapping("/new")
    public String newNoteForm(Model model) {
        model.addAttribute("note", new Note());
        return "note-form";
    }

    @PostMapping
    public String saveNote(@ModelAttribute Note note) {
        /*if(note.getId()!=null){
            Note existingNote = repo.findById(note.getId()).orElseThrow();
            note.setCreatedAt(existingNote.getCreatedAt());
            note.setUpdatedAt(LocalDateTime.now());
        }*/
        System.out.println("created:"+note.getCreatedAt());
        System.out.println("updated:"+note.getUpdatedAt());
        repo.save(note);
        return "redirect:/notes";
    }

    @GetMapping("/edit/{id}")
    public String editNote(@PathVariable Long id, Model model) {
        Note note = repo.findById(id).orElseThrow();
        model.addAttribute("note", note);
        return "note-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/notes";
    }
}
