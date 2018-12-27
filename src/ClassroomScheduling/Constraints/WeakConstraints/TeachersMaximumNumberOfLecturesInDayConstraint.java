package ClassroomScheduling.Constraints.WeakConstraints;

import ClassroomScheduling.Schedule.Schedule;
import ClassroomScheduling.Teacher;
import ClassroomScheduling.TimeSpan.StudentTimeSpan;
import ClassroomScheduling.TimeSpan.TimeSpan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TeachersMaximumNumberOfLecturesInDayConstraint extends WeakConstraint {

    @Override
    public int Evaluate(Schedule schedule) {

        Map<Teacher, Integer> counter = new HashMap<>();

        int res = 0;

        for (ArrayList<TimeSpan> timeSpans : schedule.getProgram()) {
            for (TimeSpan timeSpan : timeSpans) {

                StudentTimeSpan tempi = (StudentTimeSpan)timeSpan;

                int value = 0;

                if(counter.containsKey(tempi.getTeacher()))
                    value = counter.get(tempi.getTeacher());

                value++;

                counter.put(tempi.getTeacher(), value);

                if(value > tempi.getTeacher().getMaximumNumberOfLeacturesInDay())
                    res++;

            }
        }

        return res * cost;
    }
}
