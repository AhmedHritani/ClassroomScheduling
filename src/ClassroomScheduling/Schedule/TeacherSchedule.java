package ClassroomScheduling.Schedule;

import ClassroomScheduling.Availability.Availability;
import ClassroomScheduling.Availability.TeacherAvailability;
import ClassroomScheduling.TimeSpan.TeacherTimeSpan;
import ClassroomScheduling.TimeSpan.TimeSpan;

import java.util.ArrayList;

public class TeacherSchedule extends Schedule {

    public TeacherSchedule(TeacherSchedule teacherSchedule) {
        super(teacherSchedule);
    }

    @Override
    public Schedule MakeMove(TimeSpan timeSpan) {
        Schedule updatedSchedule = new TeacherSchedule(this);
        updatedSchedule.AddTimeSpan(timeSpan);
        return updatedSchedule;
    }

    @Override
    public Availability statusAt(TimeSpan timeSpan) {

        ArrayList<TimeSpan> coincidingTimeSpans = CoincidingTimeSpans(timeSpan);
        boolean available = true, comfortable = true;
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
