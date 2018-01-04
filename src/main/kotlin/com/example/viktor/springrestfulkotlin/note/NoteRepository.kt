package com.example.viktor.springrestfulkotlin.note

import org.springframework.data.repository.CrudRepository

interface NoteRepository : CrudRepository<Note, String>