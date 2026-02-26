package com.example.notesapp.data

class NoteRepository(private val noteDao: NoteDao) {

    // Get all notes as Flow
    val allNotes = noteDao.getAllNotes()

    // Insert note
    suspend fun insert(note: NoteEntity) {
        noteDao.insertNote(note)
    }

    // Delete note
    suspend fun delete(note: NoteEntity) {
        noteDao.deleteNote(note)
    }
}