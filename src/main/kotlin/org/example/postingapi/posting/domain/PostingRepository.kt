package org.example.postingapi.posting.domain

import java.util.UUID

interface PostingRepository {
    fun save(newPosting: Posting)
    fun findById(id: UUID): Posting?
    fun getById(id: UUID): Posting
}