package ClassroomScheduling.Constraints.WeakConstraints;

import ClassroomScheduling.Schedule.Schedule;
import ClassroomScheduling.TimeSpan.TimeSpan;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SpacesBetweenLeacturesForStudentsConstraint extends WeakConstraint {

    @Override
    public int Evaluate(Schedule schedule) {

        int res = 0;

        for (ArrayList<TimeSpan> timeSpans : schedule.getProgram()) {
            Set<Pair<Float, Float>> sorter = new TreeSet<>();

            for (TimeSpan timeSpan : timeSpans) {
                sorter.add(new Pair<>(timeSpan.getStartingTime(), timeSpan.getEndingTime()));
            }

            Pair<Float, Float> last = null;

            for (Pair<Float, Float> floatFloatPair : sorter) {
                if(last == null){
                    last = floatFloatPair;
                    continue;
                }
                if(floatFloatPair.getKey() != last.getKey() && floatFloatPair.getValue() != last.getValue()){
                    res += floatFloatPair.getKey() - last.getValue();
                }
            }

        }

        return res * cost;
    }
}
