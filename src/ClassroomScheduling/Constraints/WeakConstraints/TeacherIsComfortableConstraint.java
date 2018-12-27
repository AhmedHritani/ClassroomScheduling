package ClassroomScheduling.Constraints.WeakConstraints;

import ClassroomScheduling.Schedule.Schedule;
import ClassroomScheduling.Teacher;
import ClassroomScheduling.TimeSpan.StudentTimeSpan;
import ClassroomScheduling.TimeSpan.TimeSpan;

import java.util.ArrayList;

public class TeacherIsComfortableConstraint extends WeakConstraint {

    @Override
    public int Evaluate(Schedule schedule) {

        int res = 0;

        for (ArrayList<TimeSpan> day : schedule.getProgram()) {
            for (TimeSpan timeSpan : day) {
                StudentTimeSpan tempi = (StudentTimeSpan) timeSpan;
                Teacher currentTeacher = tempi.getTeacher();
                if (currentTeacher.statusAt(timeSpan).isAvailable() && !currentTeacher.statusAt(timeSpan).isComfortable())
                    res++;
            }
        }

        return res * cost;
    }
}
