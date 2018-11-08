package spring.boot.kotlindemo.event

import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/events")
class EventController {

    @PostMapping
    fun create(@RequestBody event: Event): ResponseEntity<Any> {
        val locationUri = linkTo(methodOn(EventController::class.java).getEvent(event.id)).toUri()
        return ResponseEntity.created(locationUri).body(event)
    }

    @GetMapping("/{id}")
    fun getEvent(@PathVariable id: Int): ResponseEntity<Any> {
        throw UnsupportedOperationException("ToDo")
    }
}