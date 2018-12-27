package ClassroomScheduling.StudentsGroup;

import java.util.ArrayList;

public abstract class StudentsGroup {
    private int id;
    private int studentsCount;
    private StudentsGroup parent;
    private ArrayList<StudentsGroup> children;

    StudentsGroup(int id, int studentsCount, StudentsGroup parent) {
        this.id = id;
        this.studentsCount = studentsCount;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    public void AddChild(StudentsGroup child){
        children.add(child);
    }

    public int getId() {
        return id;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public StudentsGroup getParent() {
        return parent;
    }

    public ArrayList<StudentsGroup> getChildren() {
        ArrayList<StudentsGroup> result = new ArrayList<>();

        result.addAll(children);
        for (StudentsGroup child : children) {
            result.addAll(child.getChildren());
        }

        return result;
    }

    public ArrayList<StudentsGroup> getParents() {
        ArrayList<StudentsGroup> parentsList = null;
        if (parent != null)
            parentsList = parent.getParents();
        else
            parentsList = new ArrayList<>();
        parentsList.add(this);
        return parentsList;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        else if (getClass() == obj.getClass()) {
            StudentsGroup SGObj = (StudentsGroup) obj;
            return getParents().equals(SGObj.getParents());
        } else return false;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
