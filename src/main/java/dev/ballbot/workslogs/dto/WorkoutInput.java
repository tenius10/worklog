package dev.ballbot.workslogs.dto;

public class WorkoutInput {
    private String exerciseName;
    private String duration;
    private String content;

    public WorkoutInput(String exerciseName, String duration, String content) {
        this.exerciseName = exerciseName;
        this.duration = duration;
        this.content = content;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public String getDuration() {
        return duration;
    }

    public String getContent() {
        return content;
    }
}
