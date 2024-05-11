package dev.ballbot.workslogs.dto;

import java.time.LocalDateTime;
import java.util.List;

public class WorkoutOutput2 {
    public int maxPage;
    public List<WorkoutOutput> workoutLogs;

    public WorkoutOutput2(
            int maxPage, List<WorkoutOutput> workoutLogs
    ) {
        this.maxPage = maxPage;
        this.workoutLogs = workoutLogs;
    }
}
