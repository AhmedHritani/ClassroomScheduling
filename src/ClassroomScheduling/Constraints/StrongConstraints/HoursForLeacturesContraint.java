package ClassroomScheduling.Constraints.StrongConstraints;

import ClassroomScheduling.Schedule.Schedule;
import ClassroomScheduling.TimeSpan.TimeSpan;

import java.util.ArrayList;

public class HoursForLeacturesContraint implements StrongConstraint {

    int numbersOfHours;

    public HoursForLeacturesContraint(int numbersOfHours) {
        this.numbersOfHours = numbersOfHours;
    }

    @Override
    public boolean check(Schedule schedule) {

        for (ArrayList<TimeSpan> timeSpans : schedule.getProgram()) {
            for (TimeSpan timeSpan : timeSpans) {
                if(timeSpan.getDuration() > numbersOfHours)
                    return false;
            }
        }

        return true;
    }
}
