import java.util.Random;

/**
 * Project1 Name: NFL Draft
 *
 * @author Jesus Cortez Date: 9.20.15 Professor: Chatterjee
 */
public class nflDraft {

    public static void main(String[] args) {
        System.out.println(" Welcome To The Mini NFL Draft!!");
        System.out.println();
        String[][] sortedTeams = Teams_And_Winning_Percentage();
        Assign_round_to_players(sortedTeams);
        //calling some methods into the main 
    }

    public static String[][] Teams_And_Winning_Percentage() {

        String[][] team = new String[8][2];
        //creating a double array to hold team names and winning percentages

        team[0][0] = "Raiders";
        team[0][1] = String.valueOf(Math.random() * 100);
        team[1][0] = "Ney York Giants";
        team[1][1] = String.valueOf(Math.random() * 100);
        team[2][0] = "Green Bay Packers";
        team[2][1] = String.valueOf(Math.random() * 100);
        team[3][0] = "New England Patriots";
        team[3][1] = String.valueOf(Math.random() * 100);
        team[4][0] = "San Francisco 49ers";
        team[4][1] = String.valueOf(Math.random() * 100);
        team[5][0] = "Dallas Cowboys";
        team[5][1] = String.valueOf(Math.random() * 100);
        team[6][0] = "Seattle Seahawks";
        team[6][1] = String.valueOf(Math.random() * 100);
        team[7][0] = "Denver Broncos";
        team[7][1] = String.valueOf(Math.random() * 100);
        System.out.println(" Teams And Their Winning Percentages: ");

        //this for loop will print out the both indexes 'i' & 'j' of the 2D Array
        for (int i = 0; i < team.length; i++) {
            for (int j = 0; j < team[i].length; j++) {
                System.out.println(" " + team[i][j]);
            }
            System.out.println();
        }

        System.out.println(" After Sorting: ");
        // the sorting will arrange the teams from lowest winning percentage to highest winning percentage
        int teamCount = 0;
        int place = 0;
        //while the counter is lesser than 7, the loop will compare the arrays of percentage to sort them
        while (teamCount != 7) {
            if (Double.parseDouble(team[teamCount][1]) < Double.parseDouble(team[teamCount + 1][1])) {
                teamCount++;
            } else {
                String tempTeam = team[teamCount][0];
                String tempValue = team[teamCount][1];

                team[teamCount][0] = team[teamCount + 1][0];
                team[teamCount][1] = team[teamCount + 1][1];

                team[teamCount + 1][0] = tempTeam;
                team[teamCount + 1][1] = tempValue;
                teamCount = 0;
            }

        }

        //this for-loop just prints out the sorted 2D array of the teams  
        for (teamCount = 0; teamCount < 8; teamCount++) {

            place++;
            System.out.println(" The " + team[teamCount][0] + " are ranked " + place);
        }

        System.out.println();
        return team;

    }

    // the shuffle_my_Array method will sort an array randomly 
    static void shuffle_my_Array(String[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // swappinng elements 
            String new_swap = array[index];
            array[index] = array[i];
            array[i] = new_swap;
        }
    }

    // the Assign_round_to_players method controls the rounds and prints out the drafts of each team 
    public static void Assign_round_to_players(String[][] teams) {
        boolean flag;

        int counter = 0;
        int roundCounter1 = 0;
        int roundCounter2 = 0;
        int roundCounter3 = 0;
        int roundCounter4 = 0;

        String[] round1 = new String[8]; //will store the players for round 1
        String[] round2 = new String[8]; //will store the players for round 2
        String[] round3 = new String[8]; //will store the players for round 3
        String[] round4 = new String[8]; //will store the players for round 4

        Random Generator = new Random();


        String[] players = {"Tom Brady", "Eli Manning", "Peyton Manning", "Andrew Luck", "Tim Tebow", "Rob Gronkowski", "Tony Romo",
            "Aaron Rodgers", "Brett Favre", "Joe Flaco", "Adrian Peterson", "Marshawn lynch", "Drew Brees", "Robert Griffen III",
            "DeMarco Murray", "Sam Bradford", "Odell Beckham Jr.", "Dez Bryant", "Randall Cobb", "Antonio Brown", "Calvin Johnson",
            "A.J.Green", "Jimmy Graham", "Greg Olsen", "Eddie Lacy", "Philip Rivers", "Russell Wilson", "Ben Roethlisberger",
            "Carson Palmer", "Matt Ryan", "Nick Foles", "Matthew Stafford"};

        //for-loop will assign the players a round and keep count of players per round
        for (int i = 0; i < players.length; i++) {
            counter++;
            int value = 0;
            flag = true;
            // the boolean flag will help detect any more than 8: 1's, 2's, 3's, or 4's 
            while (flag) {

                value = Generator.nextInt(4) + 1;
                if (value == 1) {
                    if (roundCounter1 < 8) {    // this loop inserts 8 players into array for round 1
                        round1[roundCounter1] = players[i];
                        roundCounter1++;        //counter increments to keep count
                        flag = false;           //flag becomes false to restart loop
                    }
                } else if (value == 2) {
                    if (roundCounter2 < 8) {    // this loop inserts 8 players into array for round 2
                        round2[roundCounter2] = players[i];
                        roundCounter2++;        //counter increments to keep count
                        flag = false;           //flag becomes false to restart loop

                    }
                } else if (value == 3) {
                    if (roundCounter3 < 8) {    // this loop inserts 8 players into array for round 3
                        round3[roundCounter3] = players[i];
                        roundCounter3++;        //counter increments to keep count
                        flag = false;           //flag becomes false to restart loop

                    }
                } else if (value == 4) {
                    if (roundCounter4 < 8) {    // this loop inserts 8 players into array for round 4
                        round4[roundCounter4] = players[i];
                        roundCounter4++;        //counter increments to keep count
                        flag = false;           //flag becomes false to restart loop

                    }
                }
            }

            //this line prints out the players with their assigned draft round
            System.out.println(" " + players[i] + " has been selected to be drafted in Round: " + value);

        }

        //method call to shuffle round1 array
        shuffle_my_Array(round1);
        System.out.println();
        //for-loop runs and printouts the shuffled array for round1 next to the sorted teams by ranking
        for (int i = 0; i < round1.length; i++) {

            System.out.println(" The " + teams[i][0] + " have Selected " + round1[i] + " for Round 1");
        }

        //method call to shuffle round2 array
        shuffle_my_Array(round2);
        System.out.println();
        //for-loop runs and printouts the shuffled array for round2 next to the sorted teams by ranking
        for (int i = 0; i < round2.length; i++) {
            System.out.println(" The " + teams[i][0] + " have Selected " + round2[i] + " for Round 2");
        }

        //method call to shuffle round3 array
        shuffle_my_Array(round3);
        System.out.println();
        //for-loop runs and printouts the shuffled array for round3 next to the sorted teams by ranking
        for (int i = 0; i < round3.length; i++) {
            System.out.println(" The " + teams[i][0] + " have Selected " + round3[i] + " for Round 3");
        }

        //method call to shuffle round4 array
        shuffle_my_Array(round4);
        System.out.println();
        //for-loop runs and printouts the shuffled array for round4 next to the sorted teams by ranking
        for (int i = 0; i < round4.length; i++) {
            System.out.println(" The " + teams[i][0] + " have Selected " + round4[i] + " for Round 4");
        }
        System.out.println();

    }
}
