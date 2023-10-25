import java.util.Scanner;

/**
* Utility Class to recieve input from the user
*
* @ author Ben Heynes
* @ version v.1.01
*/
public class Input
{
    /**
     * Default constructor which creates the object of the class Driver.
     *
     */
    public Input()
    {

    }

    /**
     * Accepts a character input from the user.
     *
     * @param displayMessage          A String value to be diplayed to the user prior to accepting input.
     * @param charPos                 An Integer value representing index of the char from the input provided to return to the program.
     * @return                        A character value representing a chacter at a given index stipulated, from a String provided by the user.
     */
    public char acceptCharInput(String displayMessage, int charPos)
    {
        Scanner input = new Scanner(System.in);
        System.out.println(displayMessage);
        char newChar = input.nextLine().charAt(charPos);
        return newChar;
    }

    /**
     * Accepts a double input from the user.
     *
     * @param displayMessage          A String value to be diplayed to the user prior to accepting input.
     * @return                        A double value provided by the user.
     */
    public double acceptDoubleInput(String displayMessage)
    {
        Scanner input = new Scanner(System.in);
        System.out.println(displayMessage);
        double newDouble = Double.parseDouble(input.nextLine());
        return newDouble;
    }

    /**
     * Accepts an integer input from the user.
     *
     * @param displayMessage          A String value to be diplayed to the user prior to accepting input.
     * @return                        An integer value provided by the user.
     */
    public int acceptIntegerInput(String displayMessage)
    {
        Scanner input = new Scanner(System.in);
        System.out.println(displayMessage);
        int newInt = Integer.parseInt(input.nextLine());
        return newInt;
    }

    /**
     * Accepts a String input from the user.
     *
     * @param displayMessage          A String value to be diplayed to the user prior to accepting input.
     * @return                        A String value provided by the user.
     */
    public String acceptStringInput(String displayMessage)
    {
        Scanner input = new Scanner(System.in);
        System.out.println(displayMessage);
        String newString = input.nextLine();
        return newString;
    } 
}
