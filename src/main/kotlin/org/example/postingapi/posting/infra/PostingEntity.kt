package org.example.postingapi.posting.infra

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.PostLoad
import jakarta.persistence.PostPersist
import jakarta.persistence.Table
import jakarta.persistence.Transient
import java.time.LocalDateTime
import java.util.UUID
import org.springframework.data.domain.Persistable

@Entity
@Table(name = "posting")
class PostingEntity(
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private val id: UUID,

    @Embedded
    val author: AuthorEmbeddable,

    @Column(name = "title", nullable = false)
    val title: String,

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    val content: String,

    @Column(name = "view_count", nullable = false)
    val viewCount: Int,

    @Column(name = "created_at", nullable = false, updatable = false)
    val createdAt: LocalDateTime,

    @Column(name = "updated_at", nullable = false)
    val updatedAt: LocalDateTime,

    @Column(name = "deleted_at")
    val deletedAt: LocalDateTime?
): Persistable<UUID> {

    @Transient
    private var _isNew: Boolean = true

    override fun getId(): UUID = id

    override fun isNew(): Boolean = _isNew

    @PostPersist
    @PostLoad
    fun load() {
        _isNew = false
    }

    override fun toString(): String {
        return "PostingEntity(id=$id, author='${author.name}' title='$title', createdAt=$createdAt, updatedAt=$updatedAt, deletedAt=$deletedAt)"
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
    val id: UUID,

    @Column(name = "author_name", nullable = false)
    val name: String
)