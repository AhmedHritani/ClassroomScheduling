package ClassroomScheduling.Algorithms;

import ClassroomScheduling.Course;
import ClassroomScheduling.Location.Location;
import ClassroomScheduling.Schedule.Schedule;
import ClassroomScheduling.Schedule.StudentSchedule;
import ClassroomScheduling.TimeSpan.StudentTimeSpan;
import ClassroomScheduling.TimeSpan.TimeSpan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Scheduler {

    private Comparator openSetComparator = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            return Integer.compare(((State) o1).getfScore(), ((State) o2).getfScore());
        }
    };

    public Schedule AStar(ArrayList<Course> courses, ArrayList<Location> locations) {

        TreeSet<State> closedSet = new TreeSet<State>();
        PriorityQueue<State> openSet = new PriorityQueue<State>(openSetComparator);

        State start = new State(0, 0, new StudentSchedule(), courses);
        openSet.add(start);
        while (!openSet.isEmpty()) {
            State currentState = openSet.poll();
            if (currentState.getRemainingCourses().isEmpty())
                return currentState.getSchedule();
            else {
                closedSet.add(currentState);
                ArrayList<State> possibleMoves = currentState.GetPossibleMoves(locations);
                for (State possibleMove : possibleMoves) {
                    if (closedSet.contains(possibleMove))
                        continue;
                    else {
                        int tentativeGScore = currentState.GetGScore() + 1;
                        if (!openSet.contains(possibleMove))
                            openSet.add(possibleMove);
                        else if (tentativeGScore > possibleMove.GetGScore())
                            continue;
                        else {
                            possibleMove.SetGScore(tentativeGScore);
                            possibleMove.setfScore(tentativeGScore + 0);
                        }
                    }
                }
            }
        }
        return null;
    }


    public class State {
        private int gScore, fScore;
        private Schedule schedule;
        private ArrayList<Course> remainingCourses;

        public State(int gScore, int fScore, Schedule schedule, ArrayList<Course> remainingCourses) {
            this.gScore = gScore;
            this.fScore = fScore;
            this.schedule = schedule;
            this.remainingCourses = remainingCourses;
        }

        public int GetGScore() {
            return gScore;
        }

        public void SetGScore(int gScore) {
            this.gScore = gScore;
        }

        public int getfScore() {
            return fScore;
        }

        public void setfScore(int fScore) {
            this.fScore = fScore;
        }

        public Schedule getSchedule() {
            return schedule;
        }

        public ArrayList<Course> getRemainingCourses() {
            return remainingCourses;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            result.append(schedule.toString());
            return result.toString();
        }

        public ArrayList<State> GetPossibleMoves(ArrayList<Location> locations) {
            ArrayList<State> nextMoves = this.GetNextMoves(locations);
            ArrayList<State> possibleMoves = new ArrayList<>();
            //Filter in possible moves
            return nextMoves;
        }

        public ArrayList<State> GetNextMoves(ArrayList<Location> locations) {
            ArrayList<State> nextMoves = new ArrayList<State>();
            for (Course course : getRemainingCourses()) {
                ArrayList<Course> remainingCourses = (ArrayList<Course>) getRemainingCourses().clone();
                remainingCourses.remove(course);
                for (Location location : locations) {
                    for (int day = 0; day < 5; day++) {
                        for (float startingTime = 0; startingTime < 7; startingTime += 0.5) {
                            try {
                                TimeSpan addedLecture = new StudentTimeSpan(startingTime, startingTime + course.getDuration(), day, course, location);
                                Schedule newSchedule = getSchedule().MakeMove(addedLecture);
                                State newState = new State(0, 0, newSchedule, remainingCourses);
                                nextMoves.add(newState);
                            } catch (TimeSpan.InvalidTimeSpanException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
            return nextMoves;
        }
    }
}
