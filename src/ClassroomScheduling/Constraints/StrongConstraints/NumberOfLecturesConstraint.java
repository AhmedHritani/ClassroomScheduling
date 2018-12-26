package ClassroomScheduling.Constraints.StrongConstraints;

import ClassroomScheduling.Schedule.Schedule;
import ClassroomScheduling.StudentsGroup.StudentsGroup;
import ClassroomScheduling.TimeSpan.StudentTimeSpan;
import ClassroomScheduling.TimeSpan.TimeSpan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NumberOfLecturesConstraint implements  StrongConstraint{

    private int maximumNumberOfLectures;

    public NumberOfLecturesConstraint(int maximumNumberOfLectures) {
        this.maximumNumberOfLectures = maximumNumberOfLectures;
    }


    @Override
    public boolean check(Schedule schedule) {

        Map<StudentsGroup, Integer> counterMap = new HashMap<>();

        for (ArrayList<TimeSpan> timeSpans : schedule.getProgram()) {
            for (TimeSpan timeSpan : timeSpans) {

                int value = 0;

                if(counterMap.containsKey(((StudentTimeSpan)timeSpan).getStudentsGroup()))
                    value = counterMap.get(((StudentTimeSpan)timeSpan).getStudentsGroup());

                counterMap.put(((StudentTimeSpan)timeSpan).getStudentsGroup(), value+1);

                if(counterMap.get(((StudentTimeSpan)timeSpan).getStudentsGroup()) > maximumNumberOfLectures)
                    return false;
            }
        }


        return true;
    }
}
