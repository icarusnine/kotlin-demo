package spring.boot.kotlindemo.event

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.time.LocalDateTime

class EventTest {
    @Test
    fun create() {
        //Given
        val event = Event(
                id = 1,
                name = "Spring Meetup",
                description = "Spring boot meetup in suwomn",
                beginEnrollmentDateTime = LocalDateTime.of(2018, 11, 8, 10, 0),
                closeEnrollmentDateTime = LocalDateTime.of(2018, 11, 9, 10, 0),
                beginEventDateTime = LocalDateTime.of(2018, 11, 10, 10, 0),
                endEventDateTime = LocalDateTime.of(2018, 11, 11, 10, 0),
                location = "Suwon",
                basePrice = 100,
                maxPrice = 200,
                limitOfEnrollment = 10,
                offline = false,
                free = false)

        //When & Then
        assertThat(event.basePrice).isEqualTo(100)
        assertThat(event.maxPrice).isEqualTo(200)
        assertThat(event.name).isEqualTo("Spring Meetup")
    }
}