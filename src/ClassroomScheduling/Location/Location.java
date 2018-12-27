package ClassroomScheduling.Location;

abstract public class Location {

    private final int id;
    protected String name;

    public Location(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
