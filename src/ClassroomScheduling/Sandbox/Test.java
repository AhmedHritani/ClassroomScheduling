package ClassroomScheduling.Sandbox;

import ClassroomScheduling.Schedule.Schedule;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String args[]){

        Schedule.Days[] test = Schedule.Days.values();

        for (Schedule.Days days : test) {
            System.out.println(days);
        }
    }
}
