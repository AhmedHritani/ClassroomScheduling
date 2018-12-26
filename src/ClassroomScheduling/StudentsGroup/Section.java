package ClassroomScheduling.StudentsGroup;

import java.util.ArrayList;

public class Section extends StudentsGroup {
    public Section(int id, int studentsCount, StudentsGroup parent, ArrayList<StudentsGroup> children) {
        super(id, studentsCount, parent, children);
    }
}
