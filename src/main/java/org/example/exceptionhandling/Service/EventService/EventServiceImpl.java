package org.example.exceptionhandling.Service.EventService;

import org.example.exceptionhandling.Model.EventModel.Event;
import org.example.exceptionhandling.Model.EventModel.EventRequest;
import org.example.exceptionhandling.Repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{
    private EventRepository eventRepository;
    public EventServiceImpl(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }
    @Override
    public List<Event> getAll(Integer offset, Integer limit) {
        return eventRepository.getAll(offset,limit);
    }

    @Override
    public Event geyById(int id) {
        return eventRepository.getById(id);
    }

    @Override
    public Event insertEvent(EventRequest eventRequest) {
        return eventRepository.insertEvent(eventRequest);
    }

    @Override
    public Event updateEvent(int id,EventRequest eventRequest) {
        return eventRepository.updateEvent(id,eventRequest);
    }

    @Override
    public void deleteEvent(int id) {
        eventRepository.deleteEvent(id);
    }
}
