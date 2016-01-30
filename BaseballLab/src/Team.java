/**
 * Created by 2000023268 on 1/26/2016.
 */
import java.util.ArrayList;

public class Team {
    // Instance variables
    private ArrayList<Player> team = new ArrayList<Player> ();

    // Constructors
    public Team (ArrayList<Player> players) {
        for (Player p : players) {
            team.add(p);
        }
    }

    // Accessors
    public Player getPlayer(int player) {
        return team.get(player);
    }

    // Mutators
    public void setPlayer(int pos, Player player) {
        team.set(pos, player);
    }

    // toString
    @Override
    public String toString() {
        StringBuilder listOfPlayers = new StringBuilder();
        for (Player p : team) {
            listOfPlayers.append(p);
            listOfPlayers.append("\n");
        }
        return listOfPlayers.toString();
    }

    // equals
    public boolean equals(Team compared) {
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
    public boolean hasPitcher() {
        boolean hasPitcher = false;
        for (Player p : team) {
            if ( p.getPosition().equals("pitcher") )
                hasPitcher = true;
        }
        return hasPitcher;
    }

    // highestBattingAvg
    public String highestBattingAvg() {
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
    public String lowestBattingAvg() {
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
    public Team sortByBattingAvg() {
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

    // isPlayer

    // allPos
}
