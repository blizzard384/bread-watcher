package at.berger.breadwatcher.service

import at.berger.breadwatcher.model.BreadSession
import at.berger.breadwatcher.model.error.ErrorCode
import at.berger.breadwatcher.model.error.ServiceEntity
import at.berger.breadwatcher.store.BreadSessionStore
import org.springframework.stereotype.Service
import java.util.*

@Service
class BreadSessionService(val store: BreadSessionStore) {

    fun get(id: String): BreadSession {
        return store.getByPass(id) ?: throw ErrorCode.NOT_FOUND.exc(ServiceEntity.BREAD_SESSION, id)
    }

    fun update(session: BreadSession): BreadSession {
        session.id ?: throw ErrorCode.MISSING_PROPERTY.exc(ServiceEntity.BREAD_SESSION, "id")
        session.breads.removeIf { it.amount == 0.0 }
        return store.update(session)
    }

    fun create(): BreadSession {
        val session = BreadSession("1", UUID.randomUUID().toString(), mutableListOf())
        return store.create(session)
    }

    fun delete(id: String) {
        get(id)
        store.delete(id)
    }
}
