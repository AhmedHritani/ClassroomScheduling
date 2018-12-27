package ClassroomScheduling.Constraints.WeakConstraints;

import ClassroomScheduling.Constraints.Constraint;
import ClassroomScheduling.Schedule.Schedule;

public abstract class WeakConstraint implements Constraint {


     //Represent The Cost of violating this Constraint

    protected int cost;

    public int getCost() {
        return cost;
    }

    public abstract int Evaluate(Schedule schedule);
}
