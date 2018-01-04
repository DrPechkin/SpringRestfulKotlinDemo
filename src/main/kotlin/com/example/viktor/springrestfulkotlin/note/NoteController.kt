package com.example.viktor.springrestfulkotlin.note

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class NoteController(private val noteService: NoteService) {

    @GetMapping
    fun index() = noteService.all()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody note: Note) = noteService.add(note)

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    fun read(@PathVariable id: String) = noteService.get(id)

    @PutMapping("{id}")
    fun update(@PathVariable id: String, @RequestBody note: Note) = noteService.edit(id, note)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: String) = noteService.remove(id)
}