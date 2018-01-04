package com.example.viktor.springrestfulkotlin.note

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "notes")
data class Note(

        @Id
        @JsonProperty("id")
        @Column(name = "id", nullable = false)
        @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "uuid2")
        val id: String? = null,

        @JsonProperty("title")
        @Column(name = "title", length = 30)
        val title: String = "",

        @JsonProperty("text")
        @Column(name = "text", length = 500)
        val text: String = "",

        @JsonProperty("date_create")
        @Column(name = "date_create", updatable = false)
        var dateCreate: Long = 0L,

        @JsonProperty("date_update")
        @Column(name = "date_update")
        var dateUpdate: Long = 0L
)
{
    @PrePersist
    private fun onCreate() {
        dateCreate = Date().time
        dateUpdate = dateCreate
    }

    @PreUpdate
    private fun onUpdate() {
        dateUpdate = Date().time
    }
}