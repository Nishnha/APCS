/**
 * Created by 2000023268 on 1/26/2016.
 */
import java.util.ArrayList;
import java.util.Arrays;

public class Team {
    // Instance variables
    private ArrayList<Player> team = new ArrayList<Player> ();

    // Constructors
    public Team () {
    }

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
    public boolean equals(ArrayList<Team> team1, ArrayList<Team> team2) {
        boolean isEqual = true;
        for (int i = 0; i < team1.size(); i++) {
            if ( team1.get(i) != team2.get(i) ) {
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
    public double highestBattingAvg() {
        double highest = 0.0;
        for (Player player : team) {
            if (player.getBattingPercent() > highest)
                highest = player.getBattingPercent();
        }
        return highest;
    }

    // lowestBattingAvg
    public double lowestBattingAvg() {
        double lowest = 1.0;
        for (Player player : team) {
            if (player.getBattingPercent() < lowest)
                lowest = player.getBattingPercent();
        }
        return lowest;
    }

    // sortByBattingAvg
    public ArrayList<Player> sortByBattingAvg() {
        Team sortedTeam = Team ();
        int length = team.size();
        boolean swapped = true;
        Player temp;

        while (swapped) {
            swapped = false;
            for (int i = 0; i < length-1; i++) {
                if ( team.get(i).getBattingPercent() > team.get(i+1).getBattingPercent() ) {
                    temp = team.get(i+1);
                    team.set( i+1,team.get(i) );
                    team.set(i, temp);

                    sortedTeam.add( team.get(i) );

                    swapped = true;
                }

                //sortedTeam.add( team.get(i) );
            }
            length--;
        }

        return sortedTeam;
    }

    // overallBattingAvg

    // isPlayer

    // allPos
}
