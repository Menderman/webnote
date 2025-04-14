package com.example.webnote.repository;

import com.example.webnote.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

/*public class NoteRepository {
    
}*/

public interface NoteRepository extends JpaRepository<Note, Long> {
}
