package com.example.viktor.springrestfulkotlin.note

import org.springframework.stereotype.Service

@Service
class NoteService(private val noteRepository: NoteRepository) {

    fun all(): Iterable<Note> = noteRepository.findAll()

    fun get(id: String): Note = noteRepository.findOne(id)

    fun add(note: Note): Note = noteRepository.save(note)

    fun edit(id: String, note: Note): Note = noteRepository.save(note.copy(id = id))

    fun remove(id: String) = noteRepository.delete(id)
}