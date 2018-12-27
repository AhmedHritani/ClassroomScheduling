package ClassroomScheduling.Constraints.StrongConstraints;

import ClassroomScheduling.Schedule.Schedule;
import ClassroomScheduling.Teacher;
import ClassroomScheduling.TimeSpan.StudentTimeSpan;
import ClassroomScheduling.TimeSpan.TimeSpan;

import java.util.ArrayList;

public class TeacherIsAvailableConstraint implements StrongConstraint {

    @Override
    public boolean Check(Schedule schedule) {

        for (ArrayList<TimeSpan> day : schedule.getProgram()) {
            for (TimeSpan timeSpan : day) {
                StudentTimeSpan tempi = (StudentTimeSpan) timeSpan;
                Teacher currentTeacher = tempi.getTeacher();
                if (!currentTeacher.statusAt(timeSpan).isAvailable())
                    return false;
            }
        }
        return true;
    }
}
