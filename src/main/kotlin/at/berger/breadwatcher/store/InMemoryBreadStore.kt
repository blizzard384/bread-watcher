package at.berger.breadwatcher.store

import at.berger.breadwatcher.model.BreadSession
import org.springframework.stereotype.Service

@Service
class InMemoryBreadStore : BreadSessionStore {

    val store: MutableMap<String, BreadSession> = mutableMapOf()

    override fun getByPass(id: String): BreadSession? {
        return store[id]
    }

    override fun update(session: BreadSession): BreadSession {
        store[session.pass] = session
        return session
    }

    override fun create(session: BreadSession): BreadSession {
        store[session.pass] = session
        return session
    }

    override fun delete(id: String) {
        store.remove(id)
    }
}