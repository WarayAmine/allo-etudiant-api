package m2.eservices.alloetudiant.webServicesTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import m2.eservices.alloetudiant.common.Urls;
import m2.eservices.alloetudiant.dto.EventDto;
import m2.eservices.alloetudiant.pojos.Event;
import m2.eservices.alloetudiant.servicesImpl.EventsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EventsApiTest {

    @MockBean
    EventsServiceImpl eventsService;

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_created_event() throws Exception {
        EventDto eventDto = new EventDto();
        eventDto.setTitle("Event test");

        Event event = new Event();
        event.setTitle(eventDto.getTitle());

        when(eventsService.createEvent(any(EventDto.class))).thenReturn(event);

        mockMvc.perform(post(Urls.EVENTS)
                .content(mapper.writeValueAsString(eventDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.title").value(eventDto.getTitle())
        );
    }

}
