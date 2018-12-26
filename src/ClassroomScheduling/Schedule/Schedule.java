package ClassroomScheduling.Schedule;

import ClassroomScheduling.Availability.Availability;
import ClassroomScheduling.TimeSpan.TimeSpan;

import java.util.ArrayList;

public abstract class Schedule {

    protected ArrayList<ArrayList<TimeSpan>> program;
    protected int daysCount;

    public Schedule(int daysCount) {
        this.daysCount = daysCount;
        program = new ArrayList<ArrayList<TimeSpan>>();
        for (int i = 0; i < daysCount; i++)
            program.add(new ArrayList<TimeSpan>());
    }

    public int getDaysCount() {
        return daysCount;
    }

    public ArrayList<ArrayList<TimeSpan>> getProgram() {
        return program;
    }

    public ArrayList<TimeSpan> getDay(Days day) {
        return program.get(day.ordinal());
    }

    public ArrayList<TimeSpan> getDay(int day) {
        return program.get(day);
    }

    public abstract Availability statusAt(Days day, TimeSpan timeSpan);

    public ArrayList<TimeSpan> CoincidingTimeSpans(Days day, TimeSpan timeSpan) {
        ArrayList<TimeSpan> coincidingTimeSpans = new ArrayList<>();
        for (TimeSpan currentTimeSpan : getDay(day))
            if (currentTimeSpan.Coincides(timeSpan))
                coincidingTimeSpans.add(currentTimeSpan);
        return coincidingTimeSpans;
    }

    public enum Days {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}
}
