package ClassroomScheduling.Constraints.StrongConstraints;

import ClassroomScheduling.Schedule.Schedule;
import ClassroomScheduling.Teacher;
import ClassroomScheduling.TimeSpan.StudentTimeSpan;
import ClassroomScheduling.TimeSpan.TimeSpan;
import javafx.util.Pair;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;

public class TeacherCoherence implements StrongConstraint {

    @Override
    public boolean Check(Schedule schedule) {
        HashMap<Pair<Teacher, Integer>, ArrayList<TimeSpan>> teachersDay = new HashMap<>();
        for (ArrayList<TimeSpan> day : schedule.getProgram()) {
            for (TimeSpan timeSpan : day) {

                Pair<Teacher,Integer> teacherDayKey=new Pair<>(((StudentTimeSpan) timeSpan).getTeacher(), timeSpan.getDay());

                if (!teachersDay.containsKey(teacherDayKey))
                    teachersDay.put(teacherDayKey, new ArrayList<>());
                boolean teacherIsAvailable = true;
                for (TimeSpan teacherTimeSpan : teachersDay.get(teacherDayKey))
                    if (teacherTimeSpan.Coincides(timeSpan)) {
                        teacherIsAvailable = false;
                        break;
                    }
                if (teacherIsAvailable)
                    teachersDay.get(teacherDayKey).add(timeSpan);
                else
                    return false;
            }
        }
        return true;
    }
}
