package at.berger.breadwatcher.store

import at.berger.breadwatcher.model.BreadSession

interface BreadSessionStore {

    fun getByPass(id: String): BreadSession?
    fun update(session: BreadSession): BreadSession
    fun create(session: BreadSession): BreadSession
    fun delete(id: String)
}