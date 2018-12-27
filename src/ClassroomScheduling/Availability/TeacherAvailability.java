package ClassroomScheduling.Availability;

public class TeacherAvailability implements Availability {
    final private boolean available, comfortable;

    public TeacherAvailability(Status status) {
        switch (status) {
            case UNAVAILABLE: {
                available = false;
                comfortable = false;
                break;
            }
            case COMFORTABLE: {
                available = true;
                comfortable = true;
                break;
            }
            case UNCOMFORTABLE: {
                available = true;
                comfortable = false;
                break;
            }
            default:{
                available=comfortable=true;
            }
        }
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean isComfortable() {
        return comfortable;
    }

    public enum Status {COMFORTABLE, UNCOMFORTABLE, UNAVAILABLE}
}