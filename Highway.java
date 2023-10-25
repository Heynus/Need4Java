/**
* Class which stores a list of obstacles in order to create a Highway
*
* @ author Ben Heynes
* @ version v.1.01
*/
public class Highway
{
    private Obstacle[][] lanes;

    /**
     * Default constructor which creates the object of the class Highway.
     *
     */
    public Highway()
    {
        lanes = new Obstacle[3][10];  
    }

    /**
     * Non-Default constructor which creates the object of the class Highway.
     *
     * @param lanes         Accepts a list of Obstacles as a 2D array.
     */
    public Highway(Obstacle[][] lanes)
    {
        this.lanes = lanes;
    }

    /**
     * Creates an obstacle object with the attributes for fuel.
     *
     * @return              A new obstacle object with the attributes for fuel.
     */
    public Obstacle createFuel()
    {
        return new Obstacle(10, "Fuel", 'F');
    }

    /**
     * Creates an obstacle object with the attributes for an open manhole.
     *
     * @return              A new obstacle object with the attributes for an open manhole.
     */
    public Obstacle createManhole()
    {
        return new Obstacle(60, "An Open Manhole", 'O');
    }

    /**
     * Creates an obstacle object.
     *
     * @param impact        The impact of the obstacle as an integer.
     * @param description   The description of the obstacle as a string.
     * @param symbol        The symbol to identify the obstacle as a character.
     *
     * @return              A new obstacle object.
     */
    public Obstacle createObstacle(int impact, String description, char symbol)
    {
        return new Obstacle(impact, description, symbol);
    }

    /**
     * Creates an obstacle object with the attributes for a roadblock.
     *
     * @return              A new obstacle object with the attributes for a roadblock.
     */
    public Obstacle createRoadblock()
    {
        return new Obstacle(20, "A Roadblock", 'B');
    }

    /**
     * Creates an obstacle object with the attributes for tyre spikes.
     *
     * @return              A new obstacle object with the attributes for tyre spikes.
     */
    public Obstacle createSpikes()
    {
        return new Obstacle(45, "Tyre Spikes", 'S');
    }

    /**
     * Display method to return the state of the object.
     *
     * @return              The state of the object as a string.
     */
    public String display()
    {
        String displayLanes = "";
        for(Obstacle[] rows : lanes)
            for(Obstacle temp : rows)
            {
                displayLanes += temp.display();
            }
        return displayLanes;
    }

    /**
    * Display method to return the symbols of the vehicles held in the object arranged in 3 rows and only showing 10
    * columns from a given column position up to the end of the list to represent a highway in game.
    *
    * @return              the symbols of the vehicles held in the object as a string.
    */
    public String displayGameSymbols(int pos)
    {
        String displayLanes = "";
        for(Obstacle[] rows : lanes)
        {
            displayLanes += "\n";
            
            if(rows.length > (pos + 10))
            {
                for(int i = pos; i < (pos + 10); i++)
                    displayLanes += (" " + rows[i].getSymbol() + " ");
            }
            else
            {
                for(int x = (rows.length - 10); x < rows.length; x++)
                    displayLanes += (" " + rows[x].getSymbol() + " ");
            }
        }
        displayLanes += "\n";
        return displayLanes;
    }
    
    /**
    * Display method to return only the symbols of the vehicles held in the object.
    *
    * @return              the symbols of the vehicles held in the object as a string.
    */
    public String displaySymbols()
    {
        String displayLanes = "";
        for(Obstacle[] rows : lanes)
        {
            displayLanes += "\n";
            for(Obstacle temp : rows)
            {
                displayLanes += (" " + temp.getSymbol() + " ");
            }
        }
        return displayLanes;
    }

    /**
     * Accessor method to get the obstacle array.
     *
     * @return              The list of obstacles as a 2D array.
     */
    public Obstacle[][] getLanes()
    {
        return this.lanes;
    }

    /**
     * Accessor method to get the number of rows (lanes) in the 2D array.
     *
     * @return              The the number of rows (lanes) as an Integer.
     */
    public int getNumberOfLanes()
    {
        return this.lanes.length;
    }

    /**
     * Accessor method to get the number of columns (positions) in the 2D array.
     *
     * @return              The the number of columns (positions) as an Integer.
     */
    public int getNumberOfPositions()
    {
        return this.lanes[0].length;
    }

    /**
     * Accessor method to get a specific obstacle from the list
     *
     * @param laneNum         An integer representing the index of the row (lane) of the obstacle.
     * @param posNumb         An integer representing the index of the column (position) of the obstacle.
     * 
     * @return                A specific obstacle object from the 2D array.
     */ 
    public Obstacle getSpecificObstacle(int laneNum, int posNum)
    {
        return lanes[laneNum][posNum];
    }

    /**
     * Mutator method to set the list of obstacles.
     *
     * @param   lanes   A 2D array of obstacles representing highway.
     */
    public void setLanes(Obstacle[][] lanes)
    {
        this.lanes = lanes;
    }

    /**
     * Mutator method to set the length of the rows (lanes) of the 2D array of obstacles.
     *
     * @param   length   An integer representing the new length of the rows (lanes).
     */
    public void setLanesLength(int length)
    {
        this.lanes = new Obstacle[3][length];
    }

    /**
     * Mutator method to set the value of a specific obstacle in the 2D array.
     *
     * @param   laneNum       An integer representing the index of the row (lane) of the obstacle object.
     * @param   posNum        An integer representing the index of the column (position) of the obstacle object.
     * @param   newObstacle   An obstacle object.
     */
    public void setSpecificObstacle(int laneNum, int posNum, Obstacle newObstacle)
    {
        this.lanes[laneNum][posNum] = newObstacle;
    }

    /**
     * Mutator method to set the symbol attribute of a specific obstacle in the 2D array.
     *
     * @param   laneNum       An integer representing the index of the row (lane) of the obstacle object.
     * @param   posNum        An integer representing the index of the column (position) of the obstacle object.
     * @param   newSymbol     A character to replace the current characte of the obstacle object.
     */
    public void setSpecificSymbol(int laneNum, int posNum, char newSymbol)
    {
        this.lanes[laneNum][posNum].setSymbol(newSymbol);
    }

}
