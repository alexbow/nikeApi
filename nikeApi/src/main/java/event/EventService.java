package event;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class EventService {

    ArrayList<EventModel> eventModels = new ArrayList<>();

    /**
     * creates a new event object and stores it into our local array checks to make
     * sure that the name of the event is unique
     * 
     * @param payload
     * @return
     */
    public EventModel createEventModel(Map<String, Object> payload) {
        for (int i = 0; i < eventModels.size(); i++) {
            if (payload.get("name").equals(eventModels.get(i).getName())) {
                return null; // throw our error
            }
        }
        UUID uuid = UUID.randomUUID();
        EventModel eventModel = new EventModel(payload.get("attribute").toString(),
                payload.get("description").toString(), uuid, payload.get("name").toString(),
                payload.get("date").toString(), payload.get("address").toString());
        eventModels.add(eventModel);
        return eventModel;
    }

    /**
     * searches for the requested id in the event array
     * 
     * @param id
     * @return eventModel
     */
    public EventModel getEventModelById(UUID id) {
        for (int i = 0; i < eventModels.size(); i++) {
            if (id.equals(eventModels.get(i).getId())) {
                return eventModels.get(i);
            }
        }
        return null;
    }

    /**
     * get and return a the entire list of events
     * 
     * @return ArrayList<EventModel> list of events
     */
    public ArrayList<EventModel> getAllEventModels() {
        return eventModels;
    }
}