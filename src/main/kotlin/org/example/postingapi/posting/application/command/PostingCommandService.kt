package org.example.postingapi.posting.application.command

import org.example.postingapi.posting.domain.Posting
import org.example.postingapi.posting.domain.PostingRepository
import org.springframework.stereotype.Service

@Service
class PostingCommandService(
    private val postingRepository: PostingRepository
) {
    fun createPosting(command: CreatePostingCommand) {
        val posting = with(command) {
            Posting.new(
                author = author,
                title = title,
                content = content,
            )
        }
        postingRepository.save(posting)
    }
}

