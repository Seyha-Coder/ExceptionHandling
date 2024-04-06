package org.example.exceptionhandling.Repository;

import org.apache.ibatis.annotations.*;
import org.example.exceptionhandling.Model.EventModel.Event;
import org.example.exceptionhandling.Model.EventModel.EventRequest;

import java.util.List;

@Mapper
public interface EventRepository {

    @Select("    SELECT *FROM events LIMIT #{limit} OFFSET (#{offset}-1) * #{limit}")
    @Results(id = "eventMapping", value = {
            @Result(property = "id", column = "event_id"),
            @Result(property = "name", column = "event_name"),
            @Result(property = "date", column = "event_date"),
            @Result(property = "venue", column = "venue_id",
                    one = @One(select = "org.example.exceptionhandling.Repository.VenueRepository.getById"))

    })
    List<Event> getAll(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("""
                SELECT *FROM events WHERE event_id = #{id}
            """)
    @ResultMap("eventMapping")
    Event getById(int id);

    @Select("""
                INSERT INTO events (event_name, event_date, venue_id) VALUES (#{event.name},#{event.date},#{event.venueId}) RETURNING *
            """)
    @ResultMap("eventMapping")
    Event insertEvent(@Param("event") EventRequest eventRequest);

    @Select("""
                UPDATE events SET event_name = #{event.name}, event_date = #{event.date}, venue_id = #{event.venueId} WHERE event_id = #{id}
                RETURNING  *
            """)
    @ResultMap("eventMapping")
    Event updateEvent(int id, @Param("event") EventRequest eventRequest);

    @Select("""
                DELETE FROM events WHERE event_id = #{id}
            """)
    void deleteEvent(int id);
}
