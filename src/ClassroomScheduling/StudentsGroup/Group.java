package ClassroomScheduling.StudentsGroup;

import java.util.ArrayList;

public class Group extends StudentsGroup {
    public Group(int id, int studentsCount, StudentsGroup parent, ArrayList<StudentsGroup> children) {
        super(id, studentsCount, parent, children);
    }
}
