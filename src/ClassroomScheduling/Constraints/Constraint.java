package ClassroomScheduling.Constraints;

import ClassroomScheduling.Schedule.Schedule;

public interface Constraint {

    public boolean check(Schedule schedule);

}
