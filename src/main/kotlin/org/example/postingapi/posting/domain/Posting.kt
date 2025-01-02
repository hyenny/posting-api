package org.example.postingapi.posting.domain

import java.time.LocalDateTime
import java.util.UUID

data class Posting(
    val id: UUID,
    val author: Author,
    val title: String,
    val content: String,
    val viewCount: Int,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val deletedAt: LocalDateTime? = null,
)

data class Author(
    val authorId: UUID,
    val authorName: String,
)