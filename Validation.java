/**
* Utility Class to validate Strings
*
* @ author Ben Heynes
* @ version v.1.01
*/
public class Validation
{
    
    /**
     * Default constructor which creates the object of the class Validation
     *
     */
    public Validation()
    {

    }

    /**
     * Checks if a given String is blank
     *
     * @param value         A String value to be checked
     * @return              A boolean value representing whether the string is blank or not.
     */
    public boolean isBlank(String value)
    {
        boolean blank = false;

        if(value.trim().length() == 0)
            blank = true;
        
        return blank;
    }

    /**
     * Checks whether a given String value's length is within a given range.
     *
     * @param min           An Integer value representing the lower end of the range (inclusive).
     * @param max           An Integer value representing the upper end of the range (inclusive).
     * @param value         A String value to be checked.
     * @return              boolean value representing whether the String value's length is within the required range.
     */
    public boolean withinRange(int min, int max, String value)
    {
        boolean inRange = true;
        if(value.trim().length() < min || value.trim().length() > max)
            inRange = false;

        return inRange;
    }

    /**
     * Checks if a given intger is within a given range.
     *
     * @param min           An Integer value representing the lower end of the range (inclusive).
     * @param max           An Integer value representing the upper end of the range (inclusive).
     * @param value         An integer value to be checked.
     * @return              boolean value representing whether the String value's length is within the required range.
     */
    public boolean withinIntRange(int min, int max, int value)
    {
        boolean inRange = true;
        if (value < min || value > max)
            inRange = false;
        
        return inRange;
    }
}
