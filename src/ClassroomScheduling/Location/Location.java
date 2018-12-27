package ClassroomScheduling.Location;

abstract public class Location {

    protected final int id;
    protected String name;
    protected int capacity;

    public Location(int id, int capacity, String name) {
        this.id = id;
        this.capacity = capacity;
        this.name = name;
    }


    public int getCapacity() {
        return capacity;
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
