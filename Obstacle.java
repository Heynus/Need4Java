/**
* Class which stores a Obstacle attributes
*
* @ author Ben Heynes
* @ version v.1.01
*/
public class Obstacle
{
    private int impact;
    private String description;
    private char symbol;
    
    /**
     * Default constructor which creates the object of the class Obstacle.
     *
     */
    public Obstacle()
    {
        impact = 0;
        description = "Unknown";
        symbol = '-';
    }

    /**
     * Non-Default constructor which creates the object of the class Obstacle.
     *
     * @param impact                Accepts the impact as an integer.
     * @param desciption            Accepts description as String.
     * @param symbol                Accepts symbol to represent obstacle as a character.
     */
    public Obstacle(int impact, String description, char symbol)
    {
        this.impact = impact;
        this.description = description;
        this.symbol = symbol;
    }

    /**
     * Display method to return the state of the object.
     *
     * @return              The state of the object as a string.
     */
    public String display()
    {
        return ("impact = " + impact + " Description: " + description + " Symbol: " + symbol);
    }

    /**
     * Accessor method to get the description of the obstacle.
     *
     * @return              The description of the obstacle as a String.
     */
    public String getDescription()
    {
        return this.description;
    }
    
    /**
     * Accessor method to get the impact of the obstacle.
     *
     * @return              The impact as an integer.
     */
    public int getImpact()
    {
        return this.impact;
    }

    /**
     * Accessor method to get symbol of the obstacle
     *
     * @return              The symbol of the obstacle as a character.
     */
    public char getSymbol()
    {
        return this.symbol;
    }

    /**
     * Mutator method to set the description of the obstacle.
     *
     * @param   description   The description of the obstacle as a string.
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Mutator method to set the impact of the obstacle.
     *
     * @param   impact    The impact of the obstacle as an integer.
     */
    public void setImpact(int impact)
    {
        this.impact = impact;
    }

    /**
     * Mutator method to set the symbol of the obstacle.
     *
     * @param   symbol   The symbol of the obstacle as a character.
     */
    public void setSymbol(char symbol)
    {
        this.symbol = symbol;
    }
    
}
