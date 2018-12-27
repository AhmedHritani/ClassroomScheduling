package ClassroomScheduling.TimeSpan;

import ClassroomScheduling.Course;
import ClassroomScheduling.Location.Location;
import ClassroomScheduling.StudentsGroup.StudentsGroup;
import ClassroomScheduling.Teacher;

public class StudentTimeSpan extends TimeSpan {

    private Course course;
    private Teacher teacher;
    private StudentsGroup studentsGroup;
    private Location location;

    public StudentTimeSpan(float startingTime, float endingTime, int day, Course course, Location location) throws InvalidTimeSpanException {
        super(startingTime, endingTime, day);
        this.course = course;
        this.teacher = course.getTeacher();
        this.studentsGroup = course.getGroup();
        this.location = location;
    }

    public StudentTimeSpan(StudentTimeSpan timeSpan) throws InvalidTimeSpanException {
        super(timeSpan);
        this.course = timeSpan.course;
        this.teacher = timeSpan.teacher;
        this.studentsGroup = timeSpan.studentsGroup;
        this.location = timeSpan.location;
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
