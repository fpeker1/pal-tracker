package io.pivotal.pal.tracker;

import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private CounterService counter;
    private GaugeService gauge;
    private TimeEntryRepository tmr;

    public TimeEntryController(
            TimeEntryRepository tmr,
            CounterService counter,
            GaugeService gauge
    ) {
        this.tmr = tmr;
        this.counter = counter;
        this.gauge = gauge;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TimeEntry timeEntryToCreate) {

        TimeEntry timeEntry = tmr.create(timeEntryToCreate);
        return new ResponseEntity(timeEntry, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id) {

        TimeEntry timeEntry = tmr.find(id);

        HttpStatus httpStatus = null;

        if (timeEntry != null) {
            httpStatus = HttpStatus.OK;
        } else if (timeEntry == null) {
            httpStatus = HttpStatus.NOT_FOUND;

        }
        return new ResponseEntity(timeEntry, httpStatus);
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {

        return new ResponseEntity(tmr.list(), HttpStatus.OK);

    }

    @PutMapping("{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable Long id, @RequestBody TimeEntry timeEntry) {

        TimeEntry timeEntryUpdated = tmr.update(id, timeEntry);

        HttpStatus httpStatus = null;

        if (timeEntryUpdated != null) {
            httpStatus = HttpStatus.OK;
        } else if (timeEntryUpdated == null) {
            httpStatus = HttpStatus.NOT_FOUND;

        }
        return new ResponseEntity(timeEntryUpdated, httpStatus);

    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        tmr.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);


    }
}
