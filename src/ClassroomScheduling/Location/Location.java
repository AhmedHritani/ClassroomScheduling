package ClassroomScheduling.Location;

abstract public class Location {

    public Location(String name) {
        this.name = name;
    }

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Add function to get
}
