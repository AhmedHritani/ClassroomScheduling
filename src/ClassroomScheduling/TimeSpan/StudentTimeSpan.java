package ClassroomScheduling.TimeSpan;

import ClassroomScheduling.Course;
import ClassroomScheduling.StudentsGroup.StudentsGroup;
import ClassroomScheduling.Teacher;

public class StudentTimeSpan extends TimeSpan {

    private boolean available;
    private Course course;
    private Teacher teacher;
    private StudentsGroup studentsGroup;

    public StudentTimeSpan(float startingTime, float endingTime, Course course, StudentsGroup studentsGroup) throws InvalidTimeSpanException {
        super(startingTime, endingTime);
        this.available = false;
        this.course = course;
        this.teacher = course.getTeacher();
        this.studentsGroup = studentsGroup;
    }

    public StudentTimeSpan(float startingTime, float endingTime, boolean available) throws InvalidTimeSpanException {
        super(startingTime, endingTime);
        this.available = available;
    }

    public StudentTimeSpan(StudentTimeSpan timeSpan) throws InvalidTimeSpanException {
        super(timeSpan);
        this.available = timeSpan.available;
        this.course = timeSpan.course;
        this.teacher = timeSpan.teacher;
        this.studentsGroup = timeSpan.studentsGroup;
    }

    public boolean isAvailable() {
        return available;
    }

    public StudentsGroup getStudentsGroup() {
        return studentsGroup;
    }

    public Course getCourse() {
        return course;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
