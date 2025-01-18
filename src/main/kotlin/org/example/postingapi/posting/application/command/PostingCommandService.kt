package org.example.postingapi.posting.application.command

import org.example.postingapi.posting.domain.Posting
import org.example.postingapi.posting.domain.PostingRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

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

    @Transactional
    fun updatePosting(command: UpdatePostingCommand) {
        val posting = postingRepository.getById(command.id)
        if (command.author.id != posting.author.id) {
            throw IllegalArgumentException("해당 게시글의 작성자가 일치하지 않습니다.")
        }

        posting.update(title = command.title, content = command.content)
        postingRepository.save(posting)
    }
}

