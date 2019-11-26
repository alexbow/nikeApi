package event;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EventServiceTests {
    @Autowired
    EventService eventService = new EventService();

    private Map<String, Object> firstEvent = new HashMap<String, Object>();
    private Map<String, Object> secondEvent = new HashMap<String, Object>();

    @Before
    public void initEvents() {
        this.firstEvent.put("name", "Suzies Birthday Party");
        this.firstEvent.put("date", "12/20/19");
        this.firstEvent.put("description", "Lil Suzies Birthday");
        this.firstEvent.put("attribute", "Party");
        this.firstEvent.put("address", "121212 Long Live Lane");
        this.firstEvent.put("id", "d76e927e-3248-4636-87e9-87101ed66305");

        this.secondEvent.put("name", "Erics BBQ");
        this.secondEvent.put("date", "12/22/19");
        this.secondEvent.put("description", "Erics beef bonanza");
        this.secondEvent.put("attribute", "lunch");
        this.secondEvent.put("address", "121212 Finger Lickin Avenue");
        this.secondEvent.put("id", "e18f60c1-24bd-47a2-990c-8ebc9834c5ec");
    }

    @Test
    public void sanityCheck() throws Exception {
        assertEquals(true, true);
    }

    @Test
    public void addNewEvent() throws Exception {
        EventModel expectedValue = eventService.createEventModel(firstEvent);
        assertEquals(expectedValue.getAddress(), firstEvent.get("address"));
        assertEquals(expectedValue.getAttribute(), firstEvent.get("attribute"));
        assertEquals(expectedValue.getDate(), firstEvent.get("date"));
        assertEquals(expectedValue.getDescription(), firstEvent.get("description"));
        assertEquals(expectedValue.getName(), firstEvent.get("name"));
    }

    @Test
    public void addSecondEvent() throws Exception {
        EventModel expectedValue = eventService.createEventModel(secondEvent);
        ArrayList<EventModel> eventModels = eventService.getAllEventModels();
        assertEquals(expectedValue.getAddress(), secondEvent.get("address"));
        assertEquals(expectedValue.getAttribute(), secondEvent.get("attribute"));
        assertEquals(expectedValue.getDate(), secondEvent.get("date"));
        assertEquals(expectedValue.getDescription(), secondEvent.get("description"));
        assertEquals(expectedValue.getName(), secondEvent.get("name"));
        assertEquals(eventModels.size(), 1);
    }

    @Test
    public void addMultiEventsAndGetThemAll() throws Exception {
        eventService.createEventModel(firstEvent);
        eventService.createEventModel(secondEvent);
        ArrayList<EventModel> eventModels = eventService.getAllEventModels();
        assertEquals(eventModels.size(), 2);
    }

    @Test
    public void cannotAddSameEvents() throws Exception {
        eventService.createEventModel(firstEvent);
        EventModel sameEvent = eventService.createEventModel(firstEvent);
        assertEquals(sameEvent, null);
    }

    @Test
    public void getEventById() throws Exception {
        EventModel expectedValue = eventService.createEventModel(firstEvent);
        EventModel expectedEvent = eventService.getEventModelById(expectedValue.getId());
        assertEquals(expectedEvent, expectedValue);
    }
}