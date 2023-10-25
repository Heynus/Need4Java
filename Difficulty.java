/**
* Class which stores the variables to set the difficulty
*
* @ author Ben Heynes
* @ version v.1.01
*/
public class Difficulty
{
    private String level;
    private int randomHighwayLength;
    private double maxFuelRatio;
    private int numObstacles;

    /**
     * Default constructor which creates the object of the class Difficulty.
     *
     */
    public Difficulty()
    {
        level = "Unknown";
        randomHighwayLength = 0;
        maxFuelRatio = 0.0;
        numObstacles = 0;
    }

    /**
     * Non-Default constructor which creates the object of the class Difficulty.
     *
     * @param level                 Accepts the difficulty level as a string.
     * @param randomHighwayLength   Accepts Highway length as an integer.
     * @param maxFuelRatio          Accepts maximum fuel ration as a double.
     * @param numObstacles          Accepts the number of Obstacles as an Integer.
     *
     */
    public Difficulty(String level, int randomHighwayLength, double maxFuelRatio, int numObstacles)
    {
        this.level = level;
        this.randomHighwayLength = randomHighwayLength;
        this.maxFuelRatio = maxFuelRatio;
        this.numObstacles = numObstacles;
    }

    /**
     * Display method to return the state of the object.
     *
     * @return              The state of the object as a string.
     */
    public String display()
    {
        return (this.level + " Difficulty - Highway Length: " + this.randomHighwayLength + ", Maximum Vehicle Fuel: " + ((int)(this.maxFuelRatio * 100)) + "%, Number of Obstacles: " + numObstacles);
    }

    /**
     * Accessor method to get the level description.
     *
     * @return              The level description as a String.
     */
    public String getLevel()
    {
        return this.level;
    }

    /**
     * Accessor method to get the maximum fuel ratio.
     *
     * @return              The maximum fuel ratio as a double.
     */
    public double getMaxFuelRatio()
    {
        return this.maxFuelRatio;
    }

    /**
     * Accessor method to get the number of Obstacles.
     *
     * @return              The number of Obstacles as a integer.
     */
    public int getNumObstacles()
    {
        return this.numObstacles;
    }

    /**
     * Accessor method to get highway length.
     *
     * @return              The highway length  as an integer.
     */
    public int getRandomHighwayLength()
    {
        return this.randomHighwayLength;
    }

    /**
     * Mutator method to set the fields of a Difficulty object to easy values.
     *
     */
    public void setDifficultyEasy()
    {
        setLevel("Easy");
        setRandomHighwayLength((int)((Math.random() * (16 - 10)) + 10));
        setMaxFuelRatio(1);
        setNumberObstacles(12);
    }

    /**
     * Mutator method to set the fields of a Difficulty object to moderate values.
     *
     */
    public void setDifficultyModerate()
    {
        setLevel("Moderate");
        setRandomHighwayLength((int)((Math.random() * (31 - 15)) + 15));
        setMaxFuelRatio(0.8);
        setNumberObstacles(24);
    }

    /**
     * Mutator method to set the fields of a Difficulty object to hard values.
     *
     */
    public void setDifficultyHard()
    {
        setLevel("Hard");
        setRandomHighwayLength((int)((Math.random() * (50-30)) + 30));
        setMaxFuelRatio(0.5);
        setNumberObstacles(45);
    }

    /**
     * Mutator method to set the level.
     *
     * @param   level    The level as a String
     */
    public void setLevel(String level)
    {
        this.level = level;
    }

    /**
     * Mutator method to set the maximum fuel ratio.
     *
     * @param   maxFuelRatio    The maximum fuel ration as a double.
     */
    public void setMaxFuelRatio(double maxFuelRatio)
    {
        this.maxFuelRatio = maxFuelRatio;
    }

    /**
     * Mutator method to set the number of obstacles.
     *
     * @param   numObstacles    The number of obstacles as an integer.
     */
    public void setNumberObstacles(int numObstacles)
    {
        this.numObstacles = numObstacles;
    }

    /**
     * Mutator method to set the highway length.
     *
     * @param   randomHighwayLength    The highway length as an integer.
     */
    public void setRandomHighwayLength(int randomHighwayLength)
    {
        this.randomHighwayLength = randomHighwayLength;
    }
    
}
