package ClassroomScheduling.TimeSpan;

import java.time.DayOfWeek;

public class TeacherTimeSpan extends TimeSpan {

    enum Status{COMFORTABLE,UNCOMFORTABLE,UNAVAILABLE}

    private boolean available, comfortable;

    public TeacherTimeSpan(float startingTime, float endingTime, DayOfWeek day, Status status) throws InvalidTimeSpanException {
        super(startingTime, endingTime,day);
        switch (status){
            case UNAVAILABLE:  { available=false; comfortable=false; break; }
            case COMFORTABLE:  { available=true;  comfortable=true;  break; }
            case UNCOMFORTABLE:{ available=true;  comfortable=false; break; }
        }
    }

    public TeacherTimeSpan(TeacherTimeSpan teacherTimeSpan) throws InvalidTimeSpanException {
        super(teacherTimeSpan);
        this.available=teacherTimeSpan.available;
        this.comfortable=teacherTimeSpan.comfortable;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean isComfortable() {
        return comfortable;
    }

}
