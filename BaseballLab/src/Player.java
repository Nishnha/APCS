/**
 * Created by 2000023268 on 1/26/2016.
 */
public class Player {
    // instantiation variables
    private String name, position;
    private double battingPercent;

    // Default constructor
    public Player() {
        name = null;
        position = null;
        battingPercent = 0.0;
    }

    public Player(String name, String position, double battingPercent) {
        this.name = name;
        this.position = position;
        this.battingPercent = battingPercent;
    }

    // Accessors
    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getBattingPercent() {
        return battingPercent;
    }

    // Mutators
    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setBattingPercent(double battingPercent) {
        this.battingPercent = battingPercent;
    }

    // toString
    @Override
    public String toString() {
        return this.name + ", \t" + this.position + ", \t\t" + this.battingPercent + ";";
    }
}
