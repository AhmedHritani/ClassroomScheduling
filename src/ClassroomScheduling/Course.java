package ClassroomScheduling;

import ClassroomScheduling.StudentsGroup.StudentsGroup;

public class Course {
    private Teacher teacher;
    private StudentsGroup group;
    private int difficulty;
    private int duration;

    public Teacher getTeacher() {
        return teacher;
    }

    public StudentsGroup getGroup() {
        return group;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
