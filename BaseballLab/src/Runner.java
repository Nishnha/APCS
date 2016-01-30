import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by 2000023268 on 1/26/2016.
 */
public class Runner {
    public static void main(String[] args) {

        // Initialize Players
        Player nish   = new Player("Nish",     "pitcher",      .420);
        Player pam    = new Player("Whitlock", "catcher",      .900);
        Player galen  = new Player("Galen",    "first base",   .220);
        Player mike   = new Player("Mike",     "second base",  .222);
        Player rachel = new Player("Rachel",   "third base",   .313);
        Player logan  = new Player("Logan",    "shortstop",    .003);
        Player ben    = new Player("Ben",      "center field", .450);
        Player eric   = new Player("Eric",     "left field",   .230);
        Player tony   = new Player("Tony",     "outfield",     .140);
        Player nish2  = new Player();

        // Make ArrayLists of players
        ArrayList<Player> team1 = new ArrayList<> ( Arrays.asList
                (galen, nish, pam, logan, ben, eric, mike, tony, rachel)
        );
        ArrayList<Player> team2 = new ArrayList<> ( Arrays.asList
                (nish, galen, logan, pam, ben, mike, eric, tony, rachel)
        );

        // Make teams
        Team winrars = new Team (team1);
        Team losars  = new Team (team2);
        Team copies = new Team (team1);

        // Tests

        System.out.println( "Program made by Nishant Sinha");
        System.out.println( "\nTeam winrar consists of:");
        System.out.println( winrars.toString() );

        System.out.println( "The teams losars and winrars are the same: " + winrars.equals(losars) );
        System.out.println( "The teams losars and copies are the same: " + winrars.equals(copies) );

        System.out.println( "\nTeam winrar has a pitcher: " + winrars.hasPitcher() );
        System.out.println( "Set the position of nish to shortstop");
        nish.setPosition("shortstop");
        System.out.println( "Team winrar has a pitcher: " + winrars.hasPitcher() );

        System.out.println( "\nReplace nish with nish2");
        winrars.setPlayer(1, nish2);
        System.out.println( "The player at position 1 is: " + winrars.getPlayer(1) );

        System.out.println( "\nSet values for nish2");
        nish2.setName("Nish2");
        nish2.setPosition("pitcher");
        nish2.setBattingPercent(.420);
        System.out.println( nish2.toString() );

        System.out.println( "\nTeam winrar sorted by batting average is: \n" + winrars.sortByBattingAvg().toString() );

        System.out.println( "\nThe player with the highest batting average is " + winrars.highestBattingAvg() );
        System.out.println( "The player with the lowest batting average is " + winrars.lowestBattingAvg() );

        System.out.println( "\nThe overall batting average for team winrar is: " + winrars.overallBattingAvg() );

        System.out.println( "\nPam is a player on team winrar: " + winrars.isPlayer("Pam") );
        System.out.println( "Whitlock is a player on team winrar: " + winrars.isPlayer("Whitlock") );

        System.out.println( "\nAll positions on team winrar differ: " + winrars.allPosDiffer() );
        System.out.println( "Set the position of galen to catcher.");
        galen.setPosition("catcher");
        System.out.println( "All positions on team winrar differ: " + winrars.allPosDiffer() );
    }
}
