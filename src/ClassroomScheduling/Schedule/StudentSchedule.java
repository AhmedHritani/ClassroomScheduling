package ClassroomScheduling.Schedule;

import ClassroomScheduling.Availability.Availability;
import ClassroomScheduling.Availability.StudentGroupAvailability;
import ClassroomScheduling.Location.Location;
import ClassroomScheduling.TimeSpan.StudentTimeSpan;
import ClassroomScheduling.TimeSpan.TimeSpan;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentSchedule extends Schedule {

//    private HashMap<Location, ArrayList<TimeSpan>> locationsSchedule;

    public StudentSchedule() {
        super();
   //     this.locationsSchedule = new HashMap<>();
    }

    public StudentSchedule(StudentSchedule schedule) {
        super(schedule);
     //   locationsSchedule = (HashMap<Location, ArrayList<TimeSpan>>) schedule.locationsSchedule.clone();
    }

    @Override
    public Schedule MakeMove(TimeSpan timeSpan) {
        Schedule updatedSchedule = new StudentSchedule(this);

        updatedSchedule.AddTimeSpan(timeSpan);
        return updatedSchedule;
    }

    @Override
    public Availability statusAt(TimeSpan timeSpan) {
        boolean availability = true;
        ArrayList<TimeSpan> coincidingTimeSpans = CoincidingTimeSpans(timeSpan);

        for (TimeSpan coincidingTimeSpan : coincidingTimeSpans) {
            if (((StudentTimeSpan) coincidingTimeSpan).getStudentsGroup().equals(((StudentTimeSpan) timeSpan).getStudentsGroup())) {
                availability = false;
                break;
            }
        }
        return (Availability) new StudentGroupAvailability(availability);
    }

    @Override
    public void AddTimeSpan(TimeSpan timeSpan) {
        super.AddTimeSpan(timeSpan);

    }

//    private void AddTimeSpanToLocation(TimeSpan timeSpan) {
//        Location location = ((StudentTimeSpan) timeSpan).getLocation();
//        ArrayList<TimeSpan> currentLocationSchedule = null;
//        if (locationsSchedule.containsKey(location))
//            currentLocationSchedule = locationsSchedule.get(location);
//        else
//            currentLocationSchedule = new ArrayList<>();
//        currentLocationSchedule.add(timeSpan);
//        locationsSchedule.put(location, currentLocationSchedule);
//    }
//
//    private boolean CheckLocationsAvailabilityAt(Location location, TimeSpan timeSpan) {
//        if (locationsSchedule.containsKey(location))
//            return true;
//        else {
//            ArrayList<TimeSpan> currentLocationSchedule = locationsSchedule.get(location);
//            for (TimeSpan span : currentLocationSchedule)
//                if (span.Coincides(timeSpan))
//                    return false;
//            return true;
//        }
//    }
}
