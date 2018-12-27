package ClassroomScheduling.TimeSpan;

import ClassroomScheduling.Course;
import ClassroomScheduling.Location.Location;
import ClassroomScheduling.StudentsGroup.StudentsGroup;
import ClassroomScheduling.Teacher;

import java.time.DayOfWeek;

public class StudentTimeSpan extends TimeSpan {

    private Course course;
    private Teacher teacher;
    private StudentsGroup studentsGroup;
    private Location location;

    public StudentTimeSpan(float startingTime, float endingTime, DayOfWeek day, Course course, StudentsGroup studentsGroup, Location location) throws InvalidTimeSpanException {
        super(startingTime, endingTime, day);
        this.course = course;
        this.teacher = course.getTeacher();
        this.studentsGroup = studentsGroup;
        this.location = location;
    }

    public StudentTimeSpan(StudentTimeSpan timeSpan) throws InvalidTimeSpanException {
        super(timeSpan);
        this.course = timeSpan.course;
        this.teacher = timeSpan.teacher;
        this.studentsGroup = timeSpan.studentsGroup;
    }

    public StudentsGroup getStudentsGroup() {
        return studentsGroup;
    }

    public Course getCourse() {
        return course;
    }

    public Location getLocation() {
        return location;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
