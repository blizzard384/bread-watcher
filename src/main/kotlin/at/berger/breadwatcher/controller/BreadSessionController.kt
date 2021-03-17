package at.berger.breadwatcher.controller

import at.berger.breadwatcher.model.BreadSession
import at.berger.breadwatcher.service.BreadSessionService
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:3000","https://bread-watcher-fe.herokuapp.com"])
@RestController
@RequestMapping("/api/latest/bread-session")
class BreadSessionController(val service: BreadSessionService) {

    @GetMapping("/{id}")
    fun get(@PathVariable id:  String) : BreadSession {
        return service.get(id)
    }

    @PatchMapping
    fun update(@RequestBody session: BreadSession) : BreadSession {
        return service.update(session)
    }

    @PostMapping
    fun create() : BreadSession {
        return service.create()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:  String) {
        service.delete(id)
    }
}