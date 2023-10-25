/**
* Main Class allowing user to start the game "Need for Java".
*
* @ author Ben Heynes
* @ version v.1.01
*/
public class Game
{
    
    /**
    * Method to start the program.
    *
    * @ param args          An array of Strings representing command line arguments.
    */
    public static void main(String[] args)
    {
        GameLogic newGame = new GameLogic();
        newGame.readVehicleList();
        
        System.out.println( "=============================================================================\n" +
                            "                   Welcome to Need For Java !!!\n" +
                            "In this game you are a notorious street racer fresh off another race win.\n" +
                            "Unfortunately, your most recent race has brought some unwanted attention\n" +
                            "from the local authorities who are now hot on your tail!!\n" +
                            "Your objective is to use your racing skills to traverse the highway and \n" +
                            "escape the Police before your car is destroyed or you run out of fuel.\n" +
                            "Along the way you will encounter a number of obstacles that you will\n" +
                            "have to avoid and you may even find some extra fuel if you’re lucky.\n" +
                            "Make it to the end of the highway and you will live to race another day.\n" +
                            "Fail and you may lose everything.\n" +
                            "Good Luck and remember it doesn’t matter if you win by an inch or a mile,\n" +
                            "Winning is winning any true racer knows that!\n" +
                            "=============================================================================");
        
        Input userinp = new Input();
        boolean flag = true;
        do
        {
            String option = userinp.acceptStringInput(("                            Menu\n" +
                                                        "* To test your skills and start a new game - Enter 1\n" +
                                                        "* If you are too scared and want to exit - Enter 2\n"));
            switch(option)
            {
                case "1":
                    newGame.startGame();
                    flag = false;
                    break;
                case "2":
                    flag = false;
                    break;
                default:
                    System.out.println("!!Entry Invalid. Please Try Again!!");
            }
        }while(flag == true);

        System.out.println("That's a shame.  Once you get some courage come back and give it a go. Goodbye for now.");
    }
}
