package ClassroomScheduling.Schedule;

import ClassroomScheduling.Availability.Availability;
import ClassroomScheduling.TimeSpan.StudentTimeSpan;
import ClassroomScheduling.TimeSpan.TimeSpan;

import java.time.DayOfWeek;
import java.util.ArrayList;

public abstract class Schedule {

    public final static int DaysOfWeek = 7;

    protected ArrayList<ArrayList<TimeSpan>> program;

    public Schedule() {
        program = new ArrayList<ArrayList<TimeSpan>>();
        for (int i = 0; i < DaysOfWeek; i++)
            program.add(new ArrayList<TimeSpan>());
    }

    public Schedule(Schedule schedule) {
        program = new ArrayList<ArrayList<TimeSpan>>();
        for (ArrayList<TimeSpan> day : schedule.getProgram()) {
            ArrayList<TimeSpan> newDay = new ArrayList<>();
            for (TimeSpan timeSpan : day) {
                try {
                    newDay.add(new TimeSpan(timeSpan));
                } catch (TimeSpan.InvalidTimeSpanException e) {
                    e.printStackTrace();
                }
            }
            program.add(newDay);
        }
    }

    public void AddTimeSpan(TimeSpan timeSpan) {
        int day = timeSpan.getDay();
        program.get(day).add(timeSpan);
    }

    public abstract Schedule MakeMove(TimeSpan timeSpan);

    public ArrayList<ArrayList<TimeSpan>> getProgram() {
        return program;
    }

    public ArrayList<TimeSpan> getDay(DayOfWeek day) {
        return program.get(day.ordinal());
    }

    public ArrayList<TimeSpan> getDay(int day) {
        return program.get(day);
    }

    public abstract Availability statusAt(TimeSpan timeSpan);

    public ArrayList<TimeSpan> CoincidingTimeSpans(TimeSpan timeSpan) {
        ArrayList<TimeSpan> coincidingTimeSpans = new ArrayList<>();
        for (TimeSpan currentTimeSpan : getDay(timeSpan.getDay()))
            if (currentTimeSpan.Coincides(timeSpan))
                coincidingTimeSpans.add(currentTimeSpan);
        return coincidingTimeSpans;
    }

    @Override
    public String toString() {
        int dayIndex=6;
        StringBuilder result = new StringBuilder();
        for (ArrayList<TimeSpan> day : program) {
            result.append(DayOfWeek.of(dayIndex+1).toString()).append(": ");
            dayIndex=(dayIndex+1)%7;
            for (TimeSpan timeSpan : day) {
                result
                        .append(timeSpan.getStartingTime()).append(" ")
                        .append(((StudentTimeSpan) timeSpan).getCourse().getName()).append(" ")
                        .append(timeSpan.getEndingTime()).append(" ")
                        .append(((StudentTimeSpan)timeSpan).getLocation().getName())
                        .append(" - ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
