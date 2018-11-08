package spring.boot.kotlindemo.event

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.header
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.LocalDateTime

@RunWith(SpringRunner::class)
@WebMvcTest
class EventControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Test
    fun createEvent() {

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

        // When & Then
        mockMvc.perform(post("/api/events")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(event)))
                .andDo(print())
                .andExpect(status().isCreated)
                .andExpect(header().exists("Location"))

    }
}