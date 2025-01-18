package org.example.postingapi.posting.infra

import java.util.UUID
import org.example.postingapi.posting.domain.Author
import org.example.postingapi.posting.domain.Posting
import org.example.postingapi.posting.domain.PostingRepository
import org.example.postingapi.posting.infra.PostingMapper.toDomain
import org.example.postingapi.posting.infra.PostingMapper.toEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class PostingRepositoryImpl(
    private val postingJpaRepository: PostingJpaRepository,
): PostingRepository {
    override fun save(newPosting: Posting) {
        postingJpaRepository.save(toEntity(newPosting))
    }

    override fun findById(id: UUID): Posting? {
        return postingJpaRepository.findByIdOrNull(id)?.let { toDomain(it) }
    }

    override fun getById(id: UUID): Posting {
        return findById(id) ?: throw IllegalArgumentException("해당 $id 의 게시글이 존재하지 않습니다.")
    }
}

interface PostingJpaRepository : JpaRepository<PostingEntity, UUID>

private object PostingMapper {

    fun toDomain(entity: PostingEntity): Posting {
        return Posting.of(
            id = entity.id,
            author = Author(
                id = entity.author.id,
                name = entity.author.name
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
                id = domain.author.id,
                name = domain.author.name
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