/**
* Class to allow generation and manipulation of the variables and objects required to play the game.
*
* @ author Ben Heynes
* @ version v.1.01
*/
public class GameLogic
{
    private static final String VEHICLE_FILE = "vehicles.txt";
    private VehicleList vehicleList;
    private Difficulty difficulty;
    private Highway highway;
    private Vehicle chosenVehicle;
    private String playerName;
    private int vehicleLane;
    private int vehiclePos;
    
    /**
     * Default constructor which creates the object of the class GameLogic.
     *
     */
    public GameLogic()
    {
        vehicleList = new VehicleList();
        difficulty = new Difficulty();
        highway = new Highway();
        chosenVehicle = new Vehicle();
        playerName = "Unknown";
        vehiclePos = 0;
        vehicleLane = 0;
    }

    /**
     * Non-Default constructor which creates the object of the class GameLogic.
     *
     * @param    vehicleList         Accepts a list of vehicles as an arraylist of Vehicle objects.
     * @param    difficulty          Accepts the difficulty settings as a Difficulty object.
     * @param    highway             Accepts highway to be used as a Highway object.
     * @param    chosenVehicle       Accepts vehicle to be used in game as a Vehicle object.
     * @param    playerName          Accepts the name of the player as a String
     */
    public GameLogic(VehicleList vehicleList, Difficulty difficulty, Highway highway, Vehicle chosenVehicle, String playerName)
    {
        this.vehicleList = vehicleList;
        this.difficulty = difficulty;
        this.highway = highway;
        this.chosenVehicle = chosenVehicle;
        this.playerName = playerName;
        vehiclePos = 0;
        vehicleLane = 0;
    }

    /**
     * Non-Default constructor which creates the object of the class GameLogic.
     *
     * @param    vehicleList         Accepts a list of vehicles as an arraylist of Vehicle objects.
     * @param    difficulty          Accepts the difficulty settings as a Difficulty object.
     * @param    highway             Accepts highway to be used as a Highway object.
     * @param    chosenVehicle       Accepts vehicle to be used in game as a Vehicle object.
     * @param    playerName          Accepts the name of the player as a String.
     * @param    vehicleLane         Accepts the lane the vehicle is in as an integer.
     * @param    vehiclePos          Accepts the position of the vehicle along the highway as an integer.
     */
    public GameLogic(VehicleList vehicleList, Highway highway, Vehicle chosenVehicle, String playerName, int vehicleLane, int vehiclePos)
    {
        this.vehicleList = vehicleList;
        this.highway = highway;
        this.chosenVehicle = chosenVehicle;
        this.playerName = playerName;
        this.vehicleLane = vehicleLane;
        this.vehiclePos = vehiclePos;
    }

    /**
     * Mutator method to apply the impact of a given Obstacle object to the Vehicle object used in game when the vehicle is located on that object.
     *
     */
    public void applyImpact()
    {
        int impact = this.highway.getSpecificObstacle(this.vehicleLane, this.vehiclePos).getImpact();
        if (impact > 10)
        {
           this.chosenVehicle.adjustDamage(impact);
           System.out.println("You hit " + this.highway.getSpecificObstacle(this.vehicleLane, this.vehiclePos).getDescription() + "!!");
        }
        else if(impact > 0)
        {
            this.chosenVehicle.adjustFuel(impact);
            if (this.chosenVehicle.getFuelLevel() > this.chosenVehicle.getMaxFuel())
                this.chosenVehicle.setFuelLevel(this.chosenVehicle.getMaxFuel());
        } 
    }

    /**
     * Requests user to select given difficulty level and creates a Difficulty object to hold these values for this instance of the game.
     *
     */
    public void chooseDifficulty()
    {
        Input console = new Input();
        boolean progress = false;
        do{
            String difficultyChoice = console.acceptStringInput("Please choose your difficulty:\n\nEnter 1 for Easy \nEnter 2 for Moderate \nEnter 3 for Hard").trim();
            
            switch (difficultyChoice)
            {
                case "1":
                    this.difficulty.setDifficultyEasy();
                    progress = true;
                    break;
                case "2":
                    this.difficulty.setDifficultyModerate();
                    progress = true;
                    break;
                case "3":
                    this.difficulty.setDifficultyHard();
                    progress = true;
                    break;
                default:
                    System.out.println("!!Entry Invalid, try again!!\n");
                    break;
            }
        }while(progress == false);

        System.out.println("\nYou have chosen " + difficulty.display() + "\n");
    }

    /**
     * Requests user to select a movement of their vehicle in game and invokes methods to carry out the selection.
     *
     */
    public void chooseMove()
    {
        Input console = new Input();
        String moveVehicle = console.acceptStringInput("Please choose your move:\n\nEnter 1 to move forward \nEnter 2 to swerve up \nEnter 3 to swerve down \nEnter 4 to use boost").trim();    
        switch (moveVehicle)
        {
            case "1":
                moveForward();
                break;

            case "2":
                moveUp();
                break;
                    
            case "3":
                moveDown();
                break;
            case "4":
                moveBoost();
                break;
            default:
                System.out.println("\n!!Entry Invalid, try again!!\n");
        }
        System.out.println(displayGame());
    }
    
    /**
     * Requests user to select a Vehicle object from an arraylist of Vehicle objects and 
     * uses mutator method to assign it to a Vehicle object held by the GameLogic object. 
     *
     */
    public void chooseVehicle()
    {
        Input console = new Input();
        Validation valid = new Validation();
        System.out.println("It is Now time to choose your get away vehicle.\n" +
                            "Please see vehicle options below\n");
        System.out.println(this.vehicleList.displayVehicleOptions());
        int vehicleChoice = 0;
        boolean progress = false;
        do{
            try
            {
                vehicleChoice = Integer.parseInt(console.acceptStringInput("Please Enter the Number of the Vehicle you choose:").trim());
                if(valid.withinIntRange(1, this.vehicleList.getVehicleListSize(), vehicleChoice))
                {
                    setChosenVehicle(this.vehicleList.getSpecificVehicle((vehicleChoice - 1)));
                    System.out.println("\nYou Have Chosen " + this.chosenVehicle.getVehicleType() + " as your get away vehicle\n");
                    progress = true;
                }

                else
                    System.out.println("!!That option does not exist. Please choose a valid vehicle!!\n");
            }
            
            catch(NumberFormatException e)
            {
               System.out.println("!!Entry Invalid. Please enter a valid number to choose your vehicle!!\n"); 
            }
        }while(progress == false);
    }

    /**
     * Method to assign values to the obstacles held within a Highway object to a given requirement.
     *
     * @param     length      An integer value representing the length of the Highway object.
     * @param     count       An integer value representing the number of randomly generate Obstacle objects with an impact value to include in the Highway object.
     * return                 A Highway object with the specified length and number of randomly generated Obstacle objects with impact values.
     */
    public Highway createHighway(int length, int count)
    {
        this.highway.setLanesLength(length);
        for (int i = 0; i < 3; i++)
        {
            for(int j = 0; j < length; j++)
                this.highway.setSpecificObstacle(i, j, new Obstacle());
        }

        int counter = count;
        
        do{
            for (int y = 3; y < length; y++)
            {
                for(int x = 0; x < 3; x++)
                {
                    int obstacleChance = (int)((Math.random() * 3 )+1);

                    if(obstacleChance == 1 && counter > 0 && highway.getSpecificObstacle(x, y).getSymbol() == '-')
                    {
                        int randNum = (int)((Math.random() * 10) + 1);
                            
                        if(randNum <= 3)
                            this.highway.setSpecificObstacle(x, y, highway.createFuel());
                        else if(randNum >3 && randNum <= 7)
                            this.highway.setSpecificObstacle(x, y, highway.createRoadblock());
                        else if(randNum > 7 && randNum <= 9)
                            this.highway.setSpecificObstacle(x, y, highway.createSpikes());
                        else
                            this.highway.setSpecificObstacle(x, y, highway.createManhole());
                        counter--;
                    }
                }
            }
        }while(counter > 0);

        this.highway.setSpecificSymbol(this.vehicleLane, this.vehiclePos, '@');

        return this.highway;
    }
    
    /**
     * Display method to return the state of the object.
     *
     * @return              The state of the object as a string.
     */
    public void display()
    {
        System.out.println("Availble Vehicles: \n" + vehicleList.display() + this.difficulty.display() + this.highway.displaySymbols() + this.chosenVehicle.display());
    }

    /**
     * Display method to return the state of the object in a way that is easily interpretable in game and meets given requirements.
     *
     * @return              The state of the object as a string that is easily interpretable in game and meets given requirements.
     */
    public String displayGame()
    {
        return (this.chosenVehicle.displayGameValues() + " Distance Covered: " + this.vehiclePos + "/" + this.highway.getNumberOfPositions() + "\n"
                + "Key - F = +10 fuel, B = 20 damage, S = 45 damage, O = 65 damage\n"  
                + this.highway.displayGameSymbols(this.vehiclePos));
    }

    /**
     * Method to request the user enter a string value between 3 and 12 characters long and uses approrpiate methods to 
     * accept and validate the entry before assigning the value to the object using appropriate mutator method.
     *
     */
    public void enterPlayerName()
    {
        Input inp = new Input();
        Validation valid = new Validation();

        String name = "";
        boolean progress = false;
        do{
            name = inp.acceptStringInput("Please Enter Your Name (must be between 3 and 12 characters inclusive):");
            if(valid.isBlank(name))
                System.out.println("Name cannot be blank");
            else if(valid.withinRange(3, 12, name))
                progress = true;
            else
                System.out.println("Name must be between 3 and 12 characters long");
        }while(progress == false);

        setPlayerName(name);
        System.out.println("\nWelcome " + this.playerName + " I hope you are ready to race!\n");
    }

    /**
     * Accessor method to get the vehicle used in the game.
     *
     * @return              The chosen vehicle as a Vehicle object.
     */
    public Vehicle getChosenVehicle()
    {
        return this.chosenVehicle;
    }
    
    /**
     * Accessor method to get the difficulty used in the game.
     *
     * @return              The difficulty as a Difficulty object.
     */
    public Difficulty getDifficulty()
    {
        return this.difficulty;
    }
    
    /**
     * Accessor method to get the highway used in the game.
     *
     * @return              The highway as a Highway object.
     */
    public Highway getHighway()
    {
        return this.highway;
    }

    /**
     * Accessor method to get the player name.
     *
     * @return              The player name as a String.
     */
    public String getPlayerName()
    {
        return this.playerName;
    }

    /**
     * Accessor method to get the index of the lane the vehicle is currently in.
     *
     * @return              The index of the lane the vehicle is currently in as an Integer.
     */
    public int getVehicleLane()
    {
        return this.vehicleLane;
    }  

    /**
     * Accessor method to get the vehicle list used in the game.
     *
     * @return              The vehicle list as a VehicleList object.
     */
    public VehicleList getVehicleList()
    {
        return this.vehicleList;
    }   

    /**
     * Accessor method to get the index of the position along the highway the vehicle is currently in.
     *
     * @return              The index of the position along the highway the vehicle is currently in as an Integer.
     */
    public int getVehiclePos()
    {
        return this.vehiclePos;
    }
    
    /**
     * Method to allow for movement of vehicle symbol along highway and interaction between Obstacle objects and Vehicle object as required.
     *
     * @param     laneChange            Integer value representing the direction of lane change.
     * @param     posChange             Integer value amount of positions to move forward.
     * @param     fuelChange            Integer value representing the amount of fuel to be deducted for each movement.
     */
    private void moveVehicle(int laneChange, int posChange, int fuelCost)
    {
        boolean flag1 = true;
        int i = 1;
        while((i <= posChange) && ((this.vehiclePos + 1) < (this.highway.getNumberOfPositions())) && (flag1 == true))
        {
            i++;
            this.highway.setSpecificSymbol((this.vehicleLane + laneChange), (this.vehiclePos + 1), '@');
            this.highway.setSpecificSymbol(this.vehicleLane, this.vehiclePos, '-');
            setVehicleLane((this.vehicleLane + laneChange));
            setVehiclePos((this.vehiclePos + 1));
            applyImpact();
            if(this.chosenVehicle.getDamageLevel() >= this.chosenVehicle.getMaxDamage())
                flag1 = false;
        }
        
        this.chosenVehicle.adjustFuel(fuelCost);   
    }

    /**
     * Method to allow for the boost value of the chosen Vehicle object to be applied and the vehicle position moved as appropriate.
     *
     */
    private void moveBoost()
    {
        moveVehicle(0, this.chosenVehicle.getBoost(), -3);
    }
    
    /**
     * Method to move the vehicle position down 1 lane and forward one position.
     *
     */
    private void moveDown()
    {
        try{
            moveVehicle(1, 1, -2);
        }
        catch(ArrayIndexOutOfBoundsException​ e)
        {
            System.out.println("!!You are in the lower most lane and cannot swerve Down, please pick another option!!\n");
        }
    }

    /**
     * Method to move the vehicle forward one position.
     *
     */
    private void moveForward()
    {
        moveVehicle(0, 1, -1);
    }

    /**
     * Method to move the vehicle up one position and forward one position.
     *
     */
    private void moveUp()
    {   
        try{ 
            moveVehicle(-1, 1, -2);
        }
        catch(ArrayIndexOutOfBoundsException​ e)
        {
            System.out.println("!!You are in the upper most lane an cannot swerve up, please pick another option!!\n");
        }
    }

    /**
     * Method to pass the relevant values from the chosen difficulty to the highway and vehicle objects used in the game.
     *
     */
    public void passGameDifficulty()
    {
        setVehicleLane((int)(Math.random() * 3));
        setVehiclePos(0);
        chosenVehicle.setDamageLevel(0);
        createHighway(this.difficulty.getRandomHighwayLength(), this.difficulty.getNumObstacles());
        this.chosenVehicle.setFuelLevel(this.chosenVehicle.getMaxFuel());
        System.out.println(displayGame());
    }

    /**
     * Method to play the game byt requesting the user provide input to move vehicle along highway and
     * having the program perform the require functions.
     *
     */
    public void playGame()
    {
        Input inp = new Input();
        String endString = "";
        boolean retry = true;
        do
        {
            passGameDifficulty();
            boolean keepGoing = true;
            while(keepGoing == true)
            {
                chooseMove();
                if(this.chosenVehicle.getFuelLevel() <= 0)
                {
                    endString = ("Unlucky " + this.playerName + "!! Your Vehicle has run out of fuel and you have been captured by the police!!\n"
                                            + "- Distance covered = " + this.vehiclePos + " places\n" + "- Damage Taken = " + this.chosenVehicle.getDamageLevel());
                    System.out.println(endString);
                    keepGoing = false;
                }
                else if(this.chosenVehicle.getDamageLevel() >= this.chosenVehicle.getMaxDamage())
                {
                    endString = ("Unlucky " + this.playerName + "!! Your Vehicle has been destroyed and you have been captured by the police!!\n"
                                    + "- Distance covered = " + this.vehiclePos + " places\n" + "- Damage Taken = " + this.chosenVehicle.getDamageLevel() + "\n"
                                    + "- Fuel remaining = " + this.chosenVehicle.getFuelLevel() + " left");
                    System.out.println(endString);
                    keepGoing = false;
                }
                else if(this.vehiclePos == (this.highway.getNumberOfPositions() - 1))
                {
                    endString = ("Congratulations " + this.playerName + "!! You have escaped the Police and live to race another day!!\n"
                                    + "- Distance covered = " + this.vehiclePos + " places\n" + "- Damage Taken = " + this.chosenVehicle.getDamageLevel() + "\n"
                                    + "- Fuel remaining = " + this.chosenVehicle.getFuelLevel() + " left");
                    System.out.println(endString);
                    keepGoing = false;
                }
            }
            boolean flag = true;
            while(flag == true)
            {
                String choice = inp.acceptStringInput("Would you like to try again with the same settings?\n\nEnter 1 re-try \nEnter 2 to exit the game").trim();
                switch(choice)
                {
                    case "1":
                        flag = false;
                        break;
                    case "2":
                        retry = false;
                        flag = false;
                        break;
                    default:
                        System.out.println("!!Entry Invalid. Please Try Again!!\n");
                }
            }
        }while(retry == true);
        
        write(endString);
    }
    
    /**
     * Reads information from the vehicles.txt file to the program creates appropriate Vehicle Objects
     * and adds them to the VehicleList object.
     *
     * @return          A string representing the contents of the file.
     */
    public void readVehicleList()
    {
        FileIO vehicleFile = new FileIO(VEHICLE_FILE);
        String[] vehiclesArr = vehicleFile.readFile().split("\\n");
        for(int i = 0; i < vehiclesArr.length; i++)
        {
            String [] vehicleAttributes = vehiclesArr[i].split(",");
            if (vehicleAttributes.length == 4)
                this.vehicleList.createVehicle(vehicleAttributes[0], Integer.parseInt(vehicleAttributes[1]), Integer.parseInt(vehicleAttributes[2]), Integer.parseInt(vehicleAttributes[3]));
           else 
            System.out.println("Error Reading Vehicle File");
        }   
    }

    /**
     * Mutator method to set the vehicle to be used in game.
     *
     * @param   chosenVehicle    A Vehicle Object representing the vehcile to be used in game
     */
    public void setChosenVehicle(Vehicle chosenVehicle)
    {
        this.chosenVehicle = chosenVehicle;
    }
    
    /**
     * Mutator method to set the difficulty.
     *
     * @param   difficulty    A Difficulty object representing the difficulty to be used in game.
     */
    public void setDifficulty(Difficulty difficulty)
    {
        this.difficulty = difficulty;
    }

    /**
     * Mutator method to set the highway to be used in game
     *
     * @param   highway    A Highway object representing the highway to be used in game.
     */
    public void setHighway(Highway highway)
    {
        this.highway = highway;
    }
    
    /**
     * Mutator method to set the player name.
     *
     * @param   playerName    A String representing the name of the player.
     */
    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }

    /**
     * Mutator method to set the lane the vehicle is located in.
     *
     * @param   vehicleLane    An Integer representing the lane the vehicle is currently in.
     */
    public void setVehicleLane(int vehiclelane)
    {
        this.vehicleLane = vehiclelane;
    }

    /**
     * Mutator method to set the vehicle list to be used in game
     *
     * @param   vehicleList    A VehicleList object representing the vehicle list available in game.
     */
    public void setVehicleList(VehicleList vehicleList)
    {
        this.vehicleList = vehicleList;
    }

    /**
     * Mutator method to set the position the vehicle is located along the highway.
     *
     * @param   vehiclePos    An Integer representing the position the vehicle is located along the highway.
     */
    public void setVehiclePos(int vehiclePos)
    {
        this.vehiclePos = vehiclePos;
    }

    /**
     * Starts the game and contains the logic to use appropriate methods to control the highway and chosen vehicle.
     * continues the game until the user traverses the highway, runs out of fuel or suffers too much damage.
     * prints the outcome to output.txt file.
     * 
     */
    public void startGame()
    {
        enterPlayerName();
        chooseDifficulty();
        chooseVehicle();
        this.chosenVehicle.setMaxFuel((int)(this.difficulty.getMaxFuelRatio() * this.chosenVehicle.getMaxFuel()));
        playGame();
    }

    /**
     * Method to write a String to output.txt file
     *
     * @param   contents    A String to be written to the output.txt file
     */
    public void write(String contents)
    {
        FileIO io = new FileIO("output.txt");
        io.writeFile(contents);
    }
}

