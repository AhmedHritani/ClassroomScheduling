package ClassroomScheduling.TimeSpan;

public class TimeSpan implements Comparable {

    protected float startingTime, endingTime;

    public TimeSpan(float startingTime, float endingTime) throws InvalidTimeSpanException {
        if (startingTime < endingTime)
            throw new InvalidTimeSpanException();
        this.startingTime = startingTime;
        this.endingTime = endingTime;
    }

    public TimeSpan(TimeSpan timeSpan) throws InvalidTimeSpanException {
        this(timeSpan.startingTime, timeSpan.endingTime);
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

    public float getDuration(){
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
        if ((startingTime <= timeSpan.startingTime && timeSpan.startingTime <= endingTime) || (timeSpan.startingTime <= startingTime && startingTime <= timeSpan.endingTime))
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
