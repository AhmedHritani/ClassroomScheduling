package ClassroomScheduling.Availability;

public class StudentGroupAvailability implements Availability{
    final private boolean available;

    public StudentGroupAvailability(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }
}
