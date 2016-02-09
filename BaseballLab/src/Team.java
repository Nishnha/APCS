/**
 * Created by Nishant Sinha on 1/26/2016.
 * Bubble sort information found on https://en.wikipedia.org/wiki/Bubble_sort
 *
 * Class to create a team consisting of players
 */
import java.util.ArrayList;
import java.util.HashSet;

public class Team {
    // Instance variables
    private ArrayList<Player> team = new ArrayList<Player> ();

    // Constructors
    public Team (ArrayList<Player> players) {  // Deep copies the players of the entered array
        for (Player p : players) {
            team.add(p);
        }
    }

    // Accessors
    public String getPlayer(int player) {  // Get a player's name given their index in the team
        return team.get(player).getName();
    }

    // Mutators
    public void setPlayer(int pos, Player player) {  // Used to replace a player on the team
        team.set(pos, player);
    }

    // toString
    @Override
    public String toString() {  // Returns the players on a team in a formatted string
        StringBuilder listOfPlayers = new StringBuilder();
        for (Player p : team) {
            listOfPlayers.append(p);
            listOfPlayers.append("\n");
        }
        return listOfPlayers.toString();
    }

    // equals
    public boolean equals(Team compared) { // Check if two teams are equal
        boolean isEqual = true;
        for (int i = 0; i < team.size(); i++) {
            if ( this.getPlayer(i) != compared.getPlayer(i) ) {
                isEqual = false;
                break;
            }
        }
        return isEqual;
    }

    // hasPitcher
    public boolean hasPitcher() {  // Check if a team has a pitcher
        for (Player p : team) {
            if ( p.getPosition().equals("pitcher") )
                return true;
        }
        return false;
    }

    // highestBattingAvg
    public String highestBattingAvg() { // Returns the player with the highest batting average on a team
        double highest = 0.0;
        Player p = null;

        for (Player player : team) {
            if (player.getBattingPercent() > highest) {
                highest = player.getBattingPercent();
                p = player;
            }
        }
        return p.getName() + " with a batting percentage of " + p.getBattingPercent();
    }

    // lowestBattingAvg
    public String lowestBattingAvg() {  // Returns the player with the lowest batting average on a team
        double lowest = 1.0;
        Player p = null;

        for (Player player : team) {
            if (player.getBattingPercent() < lowest) {
                lowest = player.getBattingPercent();
                p = player;
            }
        }
        return p.getName() + " with a batting percentage of " + p.getBattingPercent();
    }

    // sortByBattingAvg
    public Team sortByBattingAvg() { // Returns a copy of the team sorted by batting average
        // Make a deep copy of the ArrayList team so that the original stays unmodified
        ArrayList<Player> sorted = new ArrayList<Player> ();
        sorted.addAll(team);

        int length = team.size();
        boolean swapped = true;
        Player temp;

        // Bubble sort
        while (swapped) {
            swapped = false;
            for (int i = 0; i < length-1; i++) {
                if ( sorted.get(i).getBattingPercent() > sorted.get(i+1).getBattingPercent() ) {
                    // Swap the places of the two players
                    temp = sorted.get(i+1);
                    sorted.set( i+1,sorted.get(i) );
                    sorted.set(i, temp);

                    // If a swap occured, then the while loop will continue
                    swapped = true;
                }
            }
            // Increases the efficiency of the loop since the furthest elements are properly sorted
            length--;
        }

        return new Team(sorted);
    }

    // overallBattingAvg
    public double overallBattingAvg() {  // Returns the overall batting average of a team as a double
        double totalBatting = 0.0;
        int numPlayers = team.size();

        for (Player p : team) {
            totalBatting += p.getBattingPercent();
        }

        return totalBatting / numPlayers;
    }

    // isPlayer
    public boolean isPlayer(String name) {  // Checks if a player is on a team by their name
        boolean isPlayer = false;
        for (Player p : team) {
            if ( p.getName().equals(name) )
                isPlayer = true;
        }
        return isPlayer;
    }

    // allPosDiffer
    public boolean allPosDiffer() {  // Checks if all the positions of the players on a team are different
        HashSet<String> positions = new HashSet<String> ();

        // Adds each position to a hashset, if the position is already added, returns false
        for (Player p : team) {
            if ( positions.add(p.getPosition()) == false )
                return false;
        }
        return true;
    }
}
