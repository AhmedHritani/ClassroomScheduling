package ClassroomScheduling.Constraints.StrongConstraints;

import ClassroomScheduling.Schedule.Schedule;
import ClassroomScheduling.StudentsGroup.StudentsGroup;
import ClassroomScheduling.TimeSpan.StudentTimeSpan;
import ClassroomScheduling.TimeSpan.TimeSpan;

import java.util.ArrayList;

public class HavingMoreThanOneLectureAtTheSameTimeConstraint implements StrongConstraint {

    @Override
    public boolean check(Schedule schedule) {

        for (ArrayList<TimeSpan> timeSpans : schedule.getProgram()) {
            for (TimeSpan timeSpan : timeSpans) {
                //Getting The Current StudentGroup
                StudentsGroup currentStudentGroup = ((StudentTimeSpan)timeSpan).getStudentsGroup();
                //Getting all the parents of this student group
                ArrayList<StudentsGroup> parents = currentStudentGroup.getParents();
                //Getting all the children of this student group
                ArrayList<StudentsGroup> children = currentStudentGroup.getChildren();
                //Iterating on all the timespans on this day
                for (TimeSpan lookIntoSpan : timeSpans) {
                    //Making sure it is't the current timeSpan
                    if(lookIntoSpan.equals(timeSpan))
                        continue;
                    //Casting to StudentTimeSpan
                    StudentTimeSpan tempi = (StudentTimeSpan)lookIntoSpan;
                    //Checking if the one of the parents have a class at the same time
                    for (StudentsGroup parent : parents) {
                        if(tempi.Coincides(timeSpan) && tempi.getStudentsGroup().equals(parent))
                            return false;
                    }
                    //Checking if the one of the children have a class at the same time
                    for (StudentsGroup child : children) {
                        if(tempi.Coincides(timeSpan) && tempi.getStudentsGroup().equals(child))
                            return false;
                    }
                }
            }
        }

        return true;
    }
}
