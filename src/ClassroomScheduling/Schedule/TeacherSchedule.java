package ClassroomScheduling.Schedule;

import ClassroomScheduling.TimeSpan.TeacherTimeSpan;
import ClassroomScheduling.TimeSpan.TimeSpan;
import ClassroomScheduling.Availability.*;

import java.util.ArrayList;

public class TeacherSchedule extends Schedule {

    public TeacherSchedule(int daysCount) {
        super(daysCount);
    }

    @Override
    public Availability statusAt(Days day, TimeSpan timeSpan) {

        ArrayList<TimeSpan> coincidingTimeSpans=CoincidingTimeSpans(day,timeSpan);
        boolean available=true,comfortable=true;
        for (TimeSpan coincidingTimeSpan : coincidingTimeSpans) {
            if (!((TeacherTimeSpan) coincidingTimeSpan).isAvailable()) {
                available = false;
                break;
            } else if (!((TeacherTimeSpan) coincidingTimeSpan).isComfortable())
                comfortable = false;
        }

        if (!available)
            return new TeacherAvailability(TeacherAvailability.Status.UNAVAILABLE);
        else if (!comfortable)
            return new TeacherAvailability(TeacherAvailability.Status.UNCOMFORTABLE);
        else
            return new TeacherAvailability(TeacherAvailability.Status.COMFORTABLE);
    }
}
