package io.pivotal.pal.tracker;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private List<TimeEntry> tmList = new ArrayList<TimeEntry>();

    public TimeEntry create(TimeEntry tm){

        return tm;
    }

    public TimeEntry find(long l){

      return null;
    }

    public List<TimeEntry> list(){

        return tmList;
    }

    public TimeEntry update(long userId, TimeEntry tm){
        return tm;
    }

    public void delete(long l){

    }
}
