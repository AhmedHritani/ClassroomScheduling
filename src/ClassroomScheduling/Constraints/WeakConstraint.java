package ClassroomScheduling.Constraints;

import ClassroomScheduling.Schedule.Schedule;

public class WeakConstraint implements Constraint{


     //Represent The Cost of violating this Constraint
     int cost;



    @Override
    public boolean check(Schedule schedule) {
        return false;
    }
}
