package ClassroomScheduling;

import ClassroomScheduling.Availability.TeacherAvailability;
import ClassroomScheduling.Schedule.Schedule;
import ClassroomScheduling.Schedule.TeacherSchedule;
import ClassroomScheduling.TimeSpan.TimeSpan;

public class Teacher {
    private String name;
    private TeacherSchedule schedule;

    public Teacher(String name, TeacherSchedule schedule) {
        this.name = name;
        this.schedule = schedule;
    }

    public Teacher(String name) {
        this.name = name;
        schedule = null;
    }

    public TeacherAvailability statusAt(Schedule.Days day, TimeSpan timeSpan){
        return (TeacherAvailability) schedule.statusAt(day, timeSpan);
    }

    public void setSchedule(TeacherSchedule schedule) {
        this.schedule = schedule;
    }
}
