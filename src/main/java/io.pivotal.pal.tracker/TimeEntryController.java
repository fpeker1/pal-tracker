package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TimeEntryController {

    @Autowired
    TimeEntryRepository tmr;

    public TimeEntryController(TimeEntryRepository tmr)
    {
       this.tmr = tmr;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(TimeEntry timeEntryToCreate) {

        TimeEntry timeEntry = tmr.create(timeEntryToCreate);
        return new ResponseEntity(timeEntry, HttpStatus.CREATED);
    }

    @GetMapping("/read")
    public ResponseEntity<TimeEntry> read(long l) {

        TimeEntry timeEntry = tmr.find(l);

        HttpStatus httpStatus=null;

        if(timeEntry!=null) {
            httpStatus =  HttpStatus.OK;
        }
        else if(timeEntry == null) {
            httpStatus =  HttpStatus.NOT_FOUND;

        }
        return new ResponseEntity(timeEntry, httpStatus);
    }

    @GetMapping("/list")
    public ResponseEntity<List<TimeEntry>> list() {

      List<TimeEntry> timeEntryList = new ArrayList<>();
      timeEntryList.add(new TimeEntry(1L, 123L, 456L, LocalDate.parse("2017-01-08"), 8));


        return new ResponseEntity(timeEntryList, HttpStatus.OK);

    }

    @PostMapping("/update")
    public ResponseEntity<?> update(long l, TimeEntry timeEntry) {

        TimeEntry timeEntryUpdated = tmr.update(l,timeEntry);

        HttpStatus httpStatus=null;

        if(timeEntryUpdated!=null) {
            httpStatus =  HttpStatus.OK;
        }
        else if(timeEntryUpdated == null) {
            httpStatus =  HttpStatus.NOT_FOUND;

        }
        return new ResponseEntity(timeEntryUpdated, httpStatus);

    }

    @PostMapping("/delete")
    public ResponseEntity<TimeEntry> delete(long l) {

        return  null;

    }
}
