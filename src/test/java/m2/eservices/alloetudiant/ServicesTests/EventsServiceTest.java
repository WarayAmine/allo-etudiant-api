package m2.eservices.alloetudiant.ServicesTests;

import m2.eservices.alloetudiant.dto.EventDto;
import m2.eservices.alloetudiant.pojos.Event;
import m2.eservices.alloetudiant.repositories.EventRepository;
import m2.eservices.alloetudiant.servicesImpl.EventsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EventsServiceTest {

    @Mock
    EventRepository eventRepository;

    @InjectMocks
    EventsServiceImpl eventsService;

    @Test
    public void should_return_created_event() {
        EventDto eventDto = new EventDto();
        eventDto.setTitle("test event");

        Event expected = new Event();
        expected.setTitle(eventDto.getTitle());

        when(eventRepository.save(any(Event.class))).thenReturn(expected);

        Event result = eventsService.createEvent(eventDto);

        assertThat(result.getTitle()).isSameAs(eventDto.getTitle());
    }
}
