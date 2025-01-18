package org.example.postingapi.posting.application.query

import org.example.postingapi.posting.domain.Posting
import org.example.postingapi.posting.domain.PostingRepository
import org.springframework.stereotype.Service

@Service
class PostingQueryService(
    private val postingRepository: PostingRepository
) {

    fun getPosting(query: GetPostingQuery): Posting {
        return postingRepository.getById(query.id)
    }
}

