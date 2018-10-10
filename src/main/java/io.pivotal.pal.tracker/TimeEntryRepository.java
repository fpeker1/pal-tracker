package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TimeEntryRepository {

    public TimeEntry create(TimeEntry tm);

    public TimeEntry find(long l);

    public List<TimeEntry> list();

    public TimeEntry update(long userId, TimeEntry tm);

    public void delete(long l);
}
