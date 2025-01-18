package org.example.postingapi.posting.domain

import java.util.UUID

interface PostingRepository {
    fun save(toPosting: Posting)
    fun findById(id: UUID): Posting?
    fun getById(id: UUID): Posting
}