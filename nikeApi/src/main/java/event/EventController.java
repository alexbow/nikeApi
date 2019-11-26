package event;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@RestController
public class EventController {

    @Autowired
    EventService eventService;

    /**
     * Post a new event endpoint
     * 
     * @param payload
     * @return
     */
    @RequestMapping(path = "event", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public EventModel createNewEvent(@RequestBody @Valid Map<String, Object> payload) {
        return eventService.createEventModel(payload);
    }

    /**
     * Get a specific event based on it's ID endpoint
     * 
     * @param id
     * @return
     */
    @RequestMapping(path = "event/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public EventModel findExistingEvent(@PathVariable(value = "id") String id) {
        UUID uuid = UUID.fromString(id);
        return eventService.getEventModelById(uuid);
    }

    /**
     * Returns all events in memory endpoint
     * 
     * @return
     */
    @RequestMapping(path = "event", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<EventModel> getAllEvents() {
        return eventService.getAllEventModels();
    }

}
