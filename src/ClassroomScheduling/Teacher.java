package ClassroomScheduling;

import ClassroomScheduling.Availability.TeacherAvailability;
import ClassroomScheduling.Schedule.TeacherSchedule;
import ClassroomScheduling.TimeSpan.TimeSpan;

public class Teacher {
    private int id;
    private String name;
    private TeacherSchedule schedule;
    private int maximumNumberOfLecturesInDay, maximumNumberOfLeacturesInWeek;

    public Teacher(String name, TeacherSchedule schedule, int maximumNumberOfLecturesInDay, int maximumNumberOfLecturesInWeek) {
        this.name = name;
        this.schedule = schedule;
        this.maximumNumberOfLecturesInDay = maximumNumberOfLecturesInDay;
        this.maximumNumberOfLeacturesInWeek = maximumNumberOfLecturesInWeek;
    }

    public int getMaximumNumberOfLecturesInDay() {
        return maximumNumberOfLecturesInDay;
    }

    public int getMaximumNumberOfLecturesInWeek() {
        return maximumNumberOfLeacturesInWeek;
    }

    public TeacherAvailability statusAt(TimeSpan timeSpan) {
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
