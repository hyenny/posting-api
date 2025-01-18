package org.example.postingapi.posting.api

import java.time.LocalDateTime
import java.util.UUID
import org.example.postingapi.posting.domain.Author

data class GetPostingResponse(
    val id: UUID,
    val author: Author,
    val title: String,
    val content: String,
    val viewCount: Int,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val deletedAt: LocalDateTime?,
)