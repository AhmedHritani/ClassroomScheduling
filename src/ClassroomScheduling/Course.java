package ClassroomScheduling;

import ClassroomScheduling.StudentsGroup.StudentsGroup;

public class Course {

    private int id;
    private String name;
    private Teacher teacher;
    private StudentsGroup group;
    private int difficulty;
    private int duration;

    public Course(int id, String name, Teacher teacher, StudentsGroup group, int difficulty, int duration) {
        this.id=id;
        this.name = name;
        this.teacher = teacher;
        this.group = group;
        this.difficulty = difficulty;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public StudentsGroup getGroup() {
        return group;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
