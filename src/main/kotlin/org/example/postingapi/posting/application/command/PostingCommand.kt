package org.example.postingapi.posting.application.command

import org.example.postingapi.posting.domain.Author

data class CreatePostingCommand(
    val author: Author,
    val title: String,
    val content: String,
)