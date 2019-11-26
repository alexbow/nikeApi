package event;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Event object that gets built through the API. Couldnt get Lombok to work, but
 * it would save a lot of lines of code
 */
public class EventModel {
    private String attribute;
    private String description;
    private String name;
    private String date;
    private String address;
    @JsonIgnore
    private UUID id;

    // Builds the event model
    public EventModel(String attribute, String description, UUID id, String name, String date, String address) {
        this.attribute = attribute;
        this.description = description;
        this.id = id;
        this.name = name;
        this.date = date;
        this.address = address;
    }

    // returns the attribute property
    public String getAttribute() {
        return this.attribute;
    }

    // returns the description property
    public String getDescription() {
        return this.description;
    }

    // returns the event id
    public UUID getId() {
        return this.id;
    }

    // returns the events name
    public String getName() {
        return this.name;
    }

    // returns the events data
    public String getDate() {
        return this.date;
    }

    // returns the address property
    public String getAddress() {
        return this.address;
    }
}