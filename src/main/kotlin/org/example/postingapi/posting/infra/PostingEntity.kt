package org.example.postingapi.posting.infra

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "posting")
class PostingEntity(
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    val id: UUID,

    @Embedded
    val author: AuthorEmbeddable,

    @Column(name = "title", nullable = false)
    val title: String,

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    val content: String,

    @Column(name = "view_count", nullable = false)
    var viewCount: Int = 0,

    @Column(name = "created_at", nullable = false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "deleted_at")
    var deletedAt: LocalDateTime? = null
) {

    override fun toString(): String {
        return "PostingEntity(id=$id, author='${author.authorName}' title='$title', createdAt=$createdAt, updatedAt=$updatedAt, deletedAt=$deletedAt)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        other as PostingEntity
        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}


@Embeddable
data class AuthorEmbeddable(

    @Column(name = "author_id", nullable = false, updatable = false)
    val authorId: UUID,

    @Column(name = "author_name", nullable = false)
    val authorName: String
)