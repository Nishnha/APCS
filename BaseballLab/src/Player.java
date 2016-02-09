/**
 * Created by Nishant Sinha on 1/26/2016.
 *
 * Class to create a player object
 */
public class Player {
    // instance variables
    private String name, position; // The name and position of the player
    private double battingPercent; // The batting percentage of the player (from 0 to 1)

    // Default constructors
    public Player() { // New players are called newbie, their position is the bench, and their batting average is 0
        name = "newbie";
        position = "bench";
        battingPercent = 0.0;
    }

    public Player(String name, String position, double battingPercent) { // Overloaded constructor to set the name,
        this.name = name;                                                // position, and batting percentage
        this.position = position;
        this.battingPercent = battingPercent;
    }

    // Accessors
    public String getName() { // Returns the name of the player as a string
        return name;
    }

    public String getPosition() { // Returns the position of the player as a string
        return position;
    }

    public double getBattingPercent() { // Returns the batting percentage of the player as a double
        return battingPercent;
    }

    // Mutators
    public void setName(String name) { // Sets the name of the player. Takes in a string parameter
        this.name = name;
    }

    public void setPosition(String position) { // Sets the position of the player. Takes a string parameter
        this.position = position;
    }

    public void setBattingPercent(double battingPercent) { // Sets the batting percentage of the player, take a double
        this.battingPercent = battingPercent;
    }

    // toString
    @Override
    public String toString() { // Returns the name, position, and batting percentage as a formatted string
        return this.name + ", \t\t" + this.position + ", \t\t" + this.battingPercent + ";";
    }
}
