package ClassroomScheduling.Algorithms;

import ClassroomScheduling.Course;
import ClassroomScheduling.Location.Location;
import ClassroomScheduling.Schedule.Schedule;
import ClassroomScheduling.TimeSpan.TimeSpan;

import java.util.ArrayList;

public class Scheduler {

    static ArrayList<Schedule> GetNextMoves(Schedule schedule, ArrayList<Course> courses, ArrayList<Location> locations){
        ArrayList<Schedule> nextMoves=new ArrayList<>();
        for (Course course : courses) {
            ArrayList<Course> remainingCourses= (ArrayList<Course>) courses.clone();
            remainingCourses.remove(course);
            for (Location location : locations) {

//                TimeSpan
//                Schedule newSchedule=schedule.MakeMove()
            }
        }
        return nextMoves;
    }

    static ArrayList<Schedule> GetPossibleMoves(ArrayList<Schedule> moves){
        ArrayList<Schedule> possibleMoves=new ArrayList<>();
        //Filter
        return possibleMoves;
    }

}
