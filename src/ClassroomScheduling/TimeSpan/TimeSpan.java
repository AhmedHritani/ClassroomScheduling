package ClassroomScheduling.TimeSpan;

import java.time.DayOfWeek;

public class TimeSpan implements Comparable {

    protected float startingTime, endingTime;
    private DayOfWeek day;

    public TimeSpan(float startingTime, float endingTime, DayOfWeek day) throws InvalidTimeSpanException {
        if (startingTime < endingTime)
            throw new InvalidTimeSpanException();
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.day = day;
    }

    public TimeSpan(TimeSpan timeSpan) throws InvalidTimeSpanException {
        this(timeSpan.startingTime, timeSpan.endingTime, timeSpan.day);
    }

    public int getDay() {
        return (day.ordinal()+1)%7;
    }

    public float getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(float startingTime) {
        this.startingTime = startingTime;
    }

    public float getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(float endingTime) {
        this.endingTime = endingTime;
    }

    public float getDuration() {
        return endingTime - startingTime;
    }

    @Override
    public int compareTo(Object o) {
        if (o == this) return 0;
        else if (this.getClass() == o.getClass())
            return Float.compare(startingTime, ((TimeSpan) o).startingTime);
        else
            return 0;
    }

    public boolean Coincides(TimeSpan timeSpan) {
        if (this.getDay() == timeSpan.getDay() &&((startingTime <= timeSpan.startingTime && timeSpan.startingTime <= endingTime) || (timeSpan.startingTime <= startingTime && startingTime <= timeSpan.endingTime)))
            return true;
        else
            return false;
    }

    public class InvalidTimeSpanException extends Exception {
        InvalidTimeSpanException() {
            super("Invalid TimeSpan Exception");
        }
    }
}
