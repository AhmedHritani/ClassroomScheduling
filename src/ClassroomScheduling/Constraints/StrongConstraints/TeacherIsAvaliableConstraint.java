package ClassroomScheduling.Constraints.StrongConstraints;

import ClassroomScheduling.Schedule.Schedule;
import ClassroomScheduling.Teacher;
import ClassroomScheduling.TimeSpan.StudentTimeSpan;
import ClassroomScheduling.TimeSpan.TimeSpan;

import java.util.ArrayList;

public class TeacherIsAvaliableConstraint implements StrongConstraint {

    @Override
    public boolean check(Schedule schedule) {

        Schedule.Days days[] = Schedule.Days.values();

        for (int i = 0; i < schedule.getProgram().size(); i++) {
            ArrayList<TimeSpan> timeSpans = schedule.getDay(i);
            for (TimeSpan timeSpan : timeSpans) {

                StudentTimeSpan tempi = (StudentTimeSpan)timeSpan;

                Teacher currentTeacher = tempi.getTeacher();

                if(!currentTeacher.statusAt(days[i], timeSpan).isAvailable())
                    return false;
            }
        }

        return true;
    }
}
