package ClassroomScheduling.Constraints.StrongConstraints;

import ClassroomScheduling.Schedule.Schedule;
import ClassroomScheduling.TimeSpan.TimeSpan;

import java.util.ArrayList;

public class MaximumLectureDuration implements StrongConstraint {

    private int numbersOfHours;

    public MaximumLectureDuration(int numbersOfHours) {
        this.numbersOfHours = numbersOfHours;
    }

    @Override
    public boolean Check(Schedule schedule) {

        for (ArrayList<TimeSpan> timeSpans : schedule.getProgram()) {
            for (TimeSpan timeSpan : timeSpans) {
                if(timeSpan.getDuration() > numbersOfHours)
                    return false;
            }
        }

        return true;
    }
}
