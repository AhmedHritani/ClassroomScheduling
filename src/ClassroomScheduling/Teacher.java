package ClassroomScheduling;

import ClassroomScheduling.Availability.TeacherAvailability;
import ClassroomScheduling.Schedule.Schedule;
import ClassroomScheduling.Schedule.TeacherSchedule;
import ClassroomScheduling.TimeSpan.TimeSpan;

public class Teacher {
    private String name;
    private int id;
    private TeacherSchedule schedule;
    private int maximumNumberOfLeacturesInDay, maximumNumberOfLeacturesInWeek;

    public Teacher(String name, TeacherSchedule schedule, int maximumNumberOfLeacturesInDay, int maximumNumberOfLeacturesInWeek) {
        this.name = name;
        this.schedule = schedule;
        this.maximumNumberOfLeacturesInDay = maximumNumberOfLeacturesInDay;
        this.maximumNumberOfLeacturesInWeek = maximumNumberOfLeacturesInWeek;
    }

    public int getMaximumNumberOfLeacturesInDay() {
        return maximumNumberOfLeacturesInDay;
    }

    public int getMaximumNumberOfLeacturesInWeek() {
        return maximumNumberOfLeacturesInWeek;
    }

    public TeacherAvailability statusAt(TimeSpan timeSpan){
        return (TeacherAvailability) schedule.statusAt(timeSpan);
    }

    public void setSchedule(TeacherSchedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
