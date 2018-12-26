package ClassroomScheduling.Schedule;

import ClassroomScheduling.TimeSpan.StudentTimeSpan;
import ClassroomScheduling.TimeSpan.TimeSpan;
import ClassroomScheduling.Availability.*;

import java.util.ArrayList;

public class StudentSchedule extends Schedule {

    public StudentSchedule(Schedule schedule) {
        super(schedule.getDaysCount());
        for (int i = 0; i < daysCount; i++) {
            ArrayList<TimeSpan> currentDay = getDay(i), currentDayCpy = schedule.getDay(i);
            for (TimeSpan timeSpan : currentDayCpy) {
                try {
                    currentDay.add(new StudentTimeSpan((StudentTimeSpan) timeSpan));
                } catch (TimeSpan.InvalidTimeSpanException ignored) {
                }
            }
        }
    }

    @Override
    public Availability statusAt(Days day, TimeSpan timeSpan) {
        boolean available = true;
        ArrayList<TimeSpan> coincidingTimeSpans = CoincidingTimeSpans(day, timeSpan);
        for (TimeSpan coincidingTimeSpan : coincidingTimeSpans) {
            if (!((StudentTimeSpan) coincidingTimeSpan).isAvailable()) {
                available = false;
                break;
            }
        }
        if (available)
            return (Availability) new StudentGroupAvailability(true);
        else
            return (Availability) new StudentGroupAvailability(false);
    }

    //Add a function to get status at for a group of student in a day in a timespan
    //Add a function to get status at for a Location in a day in a timespan

}
