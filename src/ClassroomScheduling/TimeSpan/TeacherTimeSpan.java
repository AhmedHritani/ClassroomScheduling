package ClassroomScheduling.TimeSpan;

public class TeacherTimeSpan extends TimeSpan {

    enum Status{COMFORTABLE,UNCOMFORTABLE,UNAVAILABLE}

    private boolean available, comfortable;

    public TeacherTimeSpan(float startingTime, float endingTime, Status status) throws InvalidTimeSpanException {
        super(startingTime, endingTime);
        switch (status){
            case UNAVAILABLE:  { available=false; comfortable=false; break; }
            case COMFORTABLE:  { available=true;  comfortable=true;  break; }
            case UNCOMFORTABLE:{ available=true;  comfortable=false; break; }
        }
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean isComfortable() {
        return comfortable;
    }

}
