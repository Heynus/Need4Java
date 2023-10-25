/**
* Class which stores a Vehicle attributes
* @ author Ben Heynes
* @ version v.1.01
*/
public class Vehicle
{
    private String vehicleType;
    private int boost;
    private int maxFuel;
    private int maxDamage;
    private int fuelLevel;
    private int damageLevel;

    /**
     * Default constructor which creates the object of the class Vehicle.
     *
     */
    public Vehicle()
    {
        vehicleType = "Unknown";
        boost = 1;
        maxFuel = 1;
        maxDamage = 1;
        fuelLevel = this.maxFuel;
        damageLevel = 0;
    }

    /**
     * Non-Default constructor which creates the object of the class Vehicle.
     *
     * @param impact                Accepts the impact as an integer.
     * @param desciption            Accepts description as String.
     * @param symbol                Accepts symbol to represent obstacle as a character.
     */
    public Vehicle(String vehicleType, int boost, int maxFuel, int maxDamage)
    {
        this.vehicleType = vehicleType;
        this.boost = boost;
        this.maxFuel = maxFuel;
        this.maxDamage = maxDamage;
        this.fuelLevel = maxFuel;
        this.damageLevel = 0;
    }

    /**
     * Display method to return the state of the object.
     *
     * @return              The state of the object as a string.
     */
    public String display()
    {
        return (vehicleType + "," + boost + "," + maxFuel + "," + maxDamage + "," + fuelLevel + "," + damageLevel);
    }

    /**
     * Display method to return the state of the object in a way that is easily interpretable in game.
     *
     * @return              The state of the object as a string that is easily interpretable in game.
     */
    public String displayGameValues()
    {
        return ("Vehicle: " + this.vehicleType + " - Fuel: " + this.fuelLevel + "/" + this.maxFuel + ", Damage: " + this.damageLevel + "/" + this.maxDamage);
    }

    /**
     * Mutator method to adjust the damage level of the object by a given amount
     *
     * @param   damageTaken         The amount of damage taken by the vehicle as an integer.
     */
    public void adjustDamage(int damageTaken)
    {
        this.damageLevel += damageTaken;
    }

    /**
     * Mutator method to adjust the fuel level of the object by a given amount
     *
     * @param   fuelChange         The value of fuel to change as an integer.
     */
    public void adjustFuel(int fuelChange)
    {
        this.fuelLevel += fuelChange;
    }

    /**
     * Accessor method to get the boost of the vehicle.
     *
     * @return              The boost of the vehicle as an integer.
     */
    public int getBoost()
    {
        return this.boost;
    }

    /**
     * Accessor method to get the current damage level of the vehicle.
     *
     * @return              The current damage level of the vehicle as an integer.
     */
    public int getDamageLevel()
    {
        return this.damageLevel;
    }

    /**
     * Accessor method to get the current fuel level of the vehicle.
     *
     * @return              The current fuel level of the vehicle as an integer.
     */
    public int getFuelLevel()
    {
        return this.fuelLevel;
    }

    /**
     * Accessor method to get the maximum damage of the vehicle.
     *
     * @return              The maximum damage of the vehicle as an integer.
     */ 
    public int getMaxDamage()
    {
        return this.maxDamage;
    }

    /**
     * Accessor method to get the maximum fuel of the vehicle.
     *
     * @return              The maximum fuel of the vehicle as an integer.
     */ 
    public int getMaxFuel()
    {
        return this.maxFuel;
    }

    /**
     * Accessor method to get the  vehicle type.
     *
     * @return              The vehicle type as a string.
     */ 
    public String getVehicleType()
    {
        return this.vehicleType;
    }

    /**
     * Mutator method to set the boost of the vehicle.
     *
     * @param   boost   An integer representing the boost of the vehicle.
     */
    public void setBoost(int boost)
    {
        this.boost = boost;
    }

    /**
     * Mutator method to set the current damage level of the vehicle.
     *
     * @param   damageLevel      An integer representing the current damage level of the vehicle.
     */
    public void setDamageLevel(int damageLevel)
    {
        this.damageLevel = damageLevel;
    }

    /**
     * Mutator method to set the current fuel level of the vehicle.
     *
     * @param   fuelLevel      An integer representing the current fuel level of the vehicle.
     */
    public void setFuelLevel(int fuelLevel)
    {
        this.fuelLevel = fuelLevel;
    }   

    /**
     * Mutator method to set the maximum damage level of the vehicle.
     *
     * @param   maxDamage      An integer representing the maximum damage level of the vehicle.
     */
    public void setMaxDamage(int maxDamage)
    {
        this.maxDamage = maxDamage;
    }

    /**
     * Mutator method to set the maximum fuel level of the vehicle.
     *
     * @param   maxFuel      An integer representing the maximum fuel level of the vehicle.
     */
    public void setMaxFuel(int maxFuel)
    {
        this.maxFuel = maxFuel;
    }

    /**
     * Mutator method to set the  vehicle type.
     *
     * @param   vehicleType     A String representing the vehicle type.
     */
    public void setVehicleType(String vehicleType)
    {
        this.vehicleType = vehicleType;
    }
}
