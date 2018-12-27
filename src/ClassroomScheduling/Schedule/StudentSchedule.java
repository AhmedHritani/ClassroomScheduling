package ClassroomScheduling.Schedule;

import ClassroomScheduling.Availability.Availability;
import ClassroomScheduling.Availability.StudentGroupAvailability;
import ClassroomScheduling.TimeSpan.StudentTimeSpan;
import ClassroomScheduling.TimeSpan.TimeSpan;

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
    public Availability statusAt(TimeSpan timeSpan) {
        boolean availability = true;
        ArrayList<TimeSpan> coincidingTimeSpans = CoincidingTimeSpans(timeSpan);

        for (TimeSpan coincidingTimeSpan : coincidingTimeSpans) {
            if (((StudentTimeSpan) coincidingTimeSpan).getStudentsGroup().equals( ((StudentTimeSpan)timeSpan).getStudentsGroup())) {
                availability = false;
                break;
            }
        }
        return (Availability) new StudentGroupAvailability(availability);
    }

    //Add a function to get status at for a group of student in a day in a timespan
    //Add a function to get status at for a Location in a day in a timespan

}
