package ClassroomScheduling.Constraints.StrongConstraints;

import ClassroomScheduling.Schedule.Schedule;
import ClassroomScheduling.StudentsGroup.StudentsGroup;
import ClassroomScheduling.TimeSpan.StudentTimeSpan;
import ClassroomScheduling.TimeSpan.TimeSpan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MaximumLecturesCount implements StrongConstraint {

    private int maximumNumberOfLectures;

    public MaximumLecturesCount(int maximumNumberOfLectures) {
        this.maximumNumberOfLectures = maximumNumberOfLectures;
    }


    @Override
    public boolean Check(Schedule schedule) {

        Map<StudentsGroup, Integer> counterMap = new HashMap<>();

        for (ArrayList<TimeSpan> day : schedule.getProgram()) {
            for (TimeSpan timeSpan : day) {

                int value = 0;

                StudentsGroup group = ((StudentTimeSpan) timeSpan).getStudentsGroup();

                if (counterMap.containsKey(group))
                    value = counterMap.get(group);
                value++;

                if (value > maximumNumberOfLectures)
                    return false;

                counterMap.put(group, value);

                for (StudentsGroup child : group.getChildren()) {
                    int childValue = 0;
                    if (counterMap.containsKey(child))
                        childValue = counterMap.get(child);

                    childValue++;

                    if (childValue > maximumNumberOfLectures)
                        return false;

                    counterMap.put(child, childValue);

                }

            }
        }
        return true;
    }
}
