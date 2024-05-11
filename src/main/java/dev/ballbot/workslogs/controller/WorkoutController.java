package dev.ballbot.workslogs.controller;

import dev.ballbot.workslogs.dto.WorkoutInput;
import dev.ballbot.workslogs.dto.WorkoutOutput;
import dev.ballbot.workslogs.service.WorkoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workoutLog")
@CrossOrigin("*")
public class WorkoutController {
    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService service) {
        this.workoutService = service;
    }

    @GetMapping()
    public ResponseEntity<List<WorkoutOutput>> getAll() {
        return new ResponseEntity<>(workoutService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<List<WorkoutOutput>> getPage(@RequestParam(value="howMany") Long howMany, @RequestParam(value="pageNum") Long pageNum) {
        Long a = pageNum * howMany;
        List<WorkoutOutput> list = workoutService.findAll();
        return new ResponseEntity<>(
                workoutService.findAll().subList(a.intValue(), list.size() < a + 5 ? list.size() : a.intValue() + 5),
                HttpStatus.OK
        );
    }

    @PostMapping()
    public ResponseEntity<WorkoutOutput> create(@RequestBody WorkoutInput workoutInput) {
        if (workoutInput.getExerciseName().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        WorkoutOutput output = workoutService.create(workoutInput);
        return new ResponseEntity<>(output, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkoutOutput> get(@PathVariable(value="id") Long id) {
        WorkoutOutput output = workoutService.findAll().get(id.intValue());
        if (output == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(output, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkoutOutput> put(@RequestBody WorkoutInput workin, @PathVariable(value="id") Long id) {
        if (workin.getExerciseName().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(workoutService.update(id, workin), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value="id") Long id) {
        workoutService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
