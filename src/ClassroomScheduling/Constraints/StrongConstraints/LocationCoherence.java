package ClassroomScheduling.Constraints.StrongConstraints;

import ClassroomScheduling.Location.Location;
import ClassroomScheduling.Schedule.Schedule;
import ClassroomScheduling.TimeSpan.StudentTimeSpan;
import ClassroomScheduling.TimeSpan.TimeSpan;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class LocationCoherence implements StrongConstraint {

    @Override
    public boolean Check(Schedule schedule) {
        HashMap<Pair<Location, Integer>, ArrayList<TimeSpan>> locationsDay = new HashMap<>();
        for (ArrayList<TimeSpan> day : schedule.getProgram())
            for (TimeSpan timeSpan : day) {

                Pair<Location, Integer> locationDayKey = new Pair<>(((StudentTimeSpan) timeSpan).getLocation(), timeSpan.getDay());

                if (!locationsDay.containsKey(locationDayKey))
                    locationsDay.put(locationDayKey, new ArrayList<>());

                boolean locationIsAvailable = true;

                for (TimeSpan locationsTimeSpan : locationsDay.get(locationDayKey))
                    if (locationsTimeSpan.Coincides(timeSpan)) {
                        locationIsAvailable = false;
                        break;
                    }

                if (!locationIsAvailable)
                    return false;
            }
        return true;
    }
}
