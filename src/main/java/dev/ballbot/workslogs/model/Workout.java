package dev.ballbot.workslogs.model;

import dev.ballbot.workslogs.dto.WorkoutOutput;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public String exerciseName;
    public String duration;
    public LocalDateTime date;
    public String content;

    public WorkoutOutput workoutOutput() {
        return new WorkoutOutput(
                this.id,
                this.exerciseName,
                this.duration,
                this.date,
                this.content
        );
    }
}
