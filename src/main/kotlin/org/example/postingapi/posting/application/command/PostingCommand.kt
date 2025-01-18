package org.example.postingapi.posting.application.command

import java.util.UUID
import org.example.postingapi.posting.domain.Author

data class CreatePostingCommand(
    val author: Author,
    val title: String,
    val content: String,
)

data class UpdatePostingCommand(
    val id: UUID,
    val author: Author,
    val title: String,
    val content: String,
)