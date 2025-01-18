package org.example.postingapi.posting.api

import java.util.UUID
import org.example.postingapi.posting.application.command.PostingCommandService
import org.example.postingapi.posting.application.query.GetPostingQuery
import org.example.postingapi.posting.application.query.PostingQueryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/postings")
class PostingController(
    private val postingCommandService: PostingCommandService,
    private val postingQueryService: PostingQueryService,
) {

    @PostMapping
    fun create(@RequestBody request: CreatePostingRequest) {
        postingCommandService.createPosting(request.toCommand())
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody request: UpdatePostingRequest) {
        postingCommandService.updatePosting(request.toCommand(id))
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: UUID): GetPostingResponse {
        return with(postingQueryService.getPosting(GetPostingQuery(id = id))) {
            GetPostingResponse(
                id = id,
                author = author,
                title = title,
                content = content,
                viewCount = viewCount,
                createdAt = createdAt,
                updatedAt = updatedAt,
                deletedAt = deletedAt,
            )
        }
    }
}



