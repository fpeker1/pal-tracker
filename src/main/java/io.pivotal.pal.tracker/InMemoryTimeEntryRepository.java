package io.pivotal.pal.tracker;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private Map<Long, TimeEntry> timeEntryMap = new HashMap<>();
    private long counter = 0;

    public TimeEntry create(TimeEntry tm){
        counter = counter + 1;
        long id = counter;
        tm.setId(id);
        timeEntryMap.put(id, tm);
        return tm;
    }

    public TimeEntry find(long key) {
        return timeEntryMap.get(key);
    }

    public List<TimeEntry> list(){
         return new ArrayList<>(timeEntryMap.values());
    }

    public TimeEntry update(long userId, TimeEntry tm){
        TimeEntry updated = new TimeEntry(userId, tm.getProjectId(), tm.getUserId(), tm.getDate(), tm.getHours());
        timeEntryMap.replace(userId, updated);
            return updated;

    }

    public void delete(long userId){

       timeEntryMap.remove(userId);
    }
}
