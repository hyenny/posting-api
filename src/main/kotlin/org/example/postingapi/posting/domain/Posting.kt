package org.example.postingapi.posting.domain

import java.time.LocalDateTime
import java.util.UUID

class Posting private constructor(
    val id: UUID?,
    val author: Author,
    var title: String,
    var content: String,
    var viewCount: Int,
    val createdAt: LocalDateTime,
    var updatedAt: LocalDateTime,
    val deletedAt: LocalDateTime?,
) {

    fun update(title: String, content: String) {
        this.title = title
        this.content = content
        this.updatedAt = LocalDateTime.now()
    }

    companion object {
        private operator fun invoke(
            id: UUID,
            author: Author,
            title: String,
            content: String,
            viewCount: Int,
            updatedAt: LocalDateTime,
            createdAt: LocalDateTime,
            deletedAt: LocalDateTime?,
        ): Posting {
            return Posting(
                id = id,
                author = author,
                title = title,
                content = content,
                viewCount = viewCount,
                updatedAt = updatedAt,
                createdAt = createdAt,
                deletedAt = deletedAt,
            )
        }

        fun new(
            author: Author,
            title: String,
            content: String,
        ): Posting {
            return Posting(
                id = null,
                author = author,
                title = title,
                content = content,
                viewCount = 0,
                createdAt = LocalDateTime.now(),
                updatedAt = LocalDateTime.now(),
                deletedAt = null,
            )
        }

        fun of(
            id: UUID?,
            author: Author,
            title: String,
            content: String,
            viewCount: Int,
            updatedAt: LocalDateTime,
            createdAt: LocalDateTime,
            deletedAt: LocalDateTime?,
        ): Posting {
            return Posting(
                id = id,
                author = author,
                title = title,
                content = content,
                viewCount = viewCount,
                updatedAt = updatedAt,
                createdAt = createdAt,
                deletedAt = deletedAt,
            )
        }
    }
}

data class Author(
    val id: UUID,
    val name: String,
)