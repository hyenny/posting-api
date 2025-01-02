package org.example.postingapi.posting.infra

import org.example.postingapi.posting.domain.Author
import org.example.postingapi.posting.domain.Posting

object PostingMapper {

    fun toDomain(entity: PostingEntity): Posting {
        return Posting(
            id = entity.id,
            author = Author(
                authorId = entity.author.authorId,
                authorName = entity.author.authorName
            ),
            title = entity.title,
            content = entity.content,
            viewCount = entity.viewCount,
            createdAt = entity.createdAt,
            updatedAt = entity.updatedAt,
            deletedAt = entity.deletedAt,
        )
    }

    fun toEntity(domain: Posting): PostingEntity {
        return PostingEntity(
            id = domain.id,
            author = AuthorEmbeddable(
                authorId = domain.author.authorId,
                authorName = domain.author.authorName
            ),
            title = domain.title,
            content = domain.content,
            viewCount = domain.viewCount,
            createdAt = domain.createdAt,
            updatedAt = domain.updatedAt,
            deletedAt = domain.deletedAt
        )
    }
}