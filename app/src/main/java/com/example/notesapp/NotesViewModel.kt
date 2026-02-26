package com.example.notesapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.data.NoteEntity
import com.example.notesapp.data.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class NotesViewModel(private val repository: NoteRepository) : ViewModel() {

    // Get notes from database
    val notes: Flow<List<NoteEntity>> = repository.allNotes

    // Add new note
    fun addNote(title: String, content: String) {
        viewModelScope.launch {
            repository.insert(
                NoteEntity(
                    title = title,
                    content = content
                )
            )
        }
    }

    // Delete note
    fun deleteNote(note: NoteEntity) {
        viewModelScope.launch {
            repository.delete(note)
        }
    }
}