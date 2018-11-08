package spring.boot.kotlindemo.event

import java.time.LocalDateTime

data class Event(
        var id: Int,
        var name: String,
        var description: String,
        var beginEnrollmentDateTime: LocalDateTime,
        var closeEnrollmentDateTime: LocalDateTime,
        var beginEventDateTime: LocalDateTime,
        var endEventDateTime: LocalDateTime,
        var location: String, // (optional) 이게 없으면 온라인 모임
        var basePrice: Int,
        var maxPrice: Int,
        var limitOfEnrollment: Int,
        var offline: Boolean,
        var free: Boolean,
        var eventStatus: EventStatus = EventStatus.DRAFT)

enum class EventStatus {
    DRAFT, PUBLISHED, BEGAN_ENROLLMEND, CLOSED_ENROLLMENT, STARTED, ENDED
}
