package ClassroomScheduling.StudentsGroup;

import java.util.ArrayList;

public class Class extends StudentsGroup {
    public Class(int id, int studentsCount, StudentsGroup parent, ArrayList<StudentsGroup> children) {
        super(id, studentsCount, parent, children);
    }
}
