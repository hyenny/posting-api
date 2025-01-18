package org.example.postingapi.posting.api

import java.util.UUID
import org.example.postingapi.posting.application.command.CreatePostingCommand
import org.example.postingapi.posting.application.command.UpdatePostingCommand
import org.example.postingapi.posting.domain.Author

data class CreatePostingRequest(
    val authorId: UUID,
    val authorName: String,
    val title: String,
    val content: String
) {
    fun toCommand() = CreatePostingCommand(
        author = Author(id = authorId, name = authorName),
        title = title,
        content = content,
    )
}

data class UpdatePostingRequest(
    val authorId: UUID,
    val authorName: String,
    val title: String,
    val content: String
) {
    fun toCommand(id: UUID) = UpdatePostingCommand(
        id = id,
        author = Author(id = authorId, name = authorName),
        title = title,
        content = content,
    )
}