import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by 2000023268 on 1/26/2016.
 */
public class Runner {
    public static void main(String[] args) {

        // Initialize Players
        Player galen  = new Player("Galen",    "first base",   .220);
        Player pam    = new Player("Whitlock", "catcher",      .9001);
        Player nish   = new Player("Nish",     "pitcher",      .420);
        Player logan  = new Player("Logan",    "shortstop",    .002);
        Player ben    = new Player("Ben",      "center field", .450);
        Player eric   = new Player("Eric",     "left field",   .230);
        Player mike   = new Player("Mike",     "second base",  .222);
        Player tanta  = new Player("Tanta",    "right field",  .690);
        Player tony   = new Player("Tony",     "outfield",     .140);
        Player rachel = new Player("Rachel",   "third base",   .313);

        // Make ArrayLists of players
        ArrayList<Player> team1 = new ArrayList<> ( Arrays.asList
                (galen, nish, pam, logan, ben, eric, mike, tanta, tony, rachel)
        );
        ArrayList<Player> team2 = new ArrayList<> ( Arrays.asList
                (nish, galen, logan, pam, ben, mike, eric, tanta, tony, rachel)
        );

        // Make teams
        Team winrars = new Team (team1);
        Team losars  = new Team (team2);
        Team copies = new Team (team1);

        // Tests
//        System.out.println( "Player \t Position \t\t Batting Percentage \n");
//        System.out.println( winrars.toString() );
//
//        System.out.println( "Team winrar has a pitcher: " + winrars.hasPitcher() );
//
//        System.out.println( "The player at position 3 is: " + winrars.getPlayer(3) );

        System.out.println( "Team winrar sorted by batting average is: \n" + winrars.sortByBattingAvg().toString() );

        System.out.println( "The player with the highest batting average is " + winrars.highestBattingAvg() );
        System.out.println( "The player with the lowest batting average is " + winrars.lowestBattingAvg() );

        System.out.println( "The teams losars and winrars are the same: " + winrars.equals(losars) );
        System.out.println( "The teams losars and copies are the same: " + winrars.equals(copies) );
    }
}
