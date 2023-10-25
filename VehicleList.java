import java.util.ArrayList;

/**
* Class which stores a list of Vehicles and that can be used in the Game
*
* @ author Ben Heynes
* @ version v.1.01
*/
public class VehicleList
{
    private ArrayList<Vehicle> vehicles;

    /**
     * Default constructor which creates the object of the class VehicleList.
     *
     */
    public VehicleList()
    {
        vehicles = new ArrayList<Vehicle>();
    }

    /**
     * Non-Default constructor which creates the object of the class Driver.
     *
     * @param vehicles          Accepts a list of vehicles as an ArrayList of Vehicle Objects.
     */
    public VehicleList(ArrayList<Vehicle> vehicles)
    {
        this.vehicles = vehicles;
    }

    /**
     * Display method to return the state of the object.
     *
     * @return              The state of the object as a string.
     */
    public String display()
    {
        String vehicleList = "";
        for (Vehicle value : this.vehicles)
            vehicleList += (value.display() + "\n") ;

        return vehicleList;
    }

    /**
     * Display method to return a numbered list with the attributes of the vehicles held in the object.
     *
     * @return              A numbered list of the vehicles held in the object and their attributes.
     */
    public String displayVehicleOptions()
    {
        String vehicleOpts = "";
        int optNum = 1;
        for (Vehicle value : this.vehicles)
        {
          vehicleOpts += (optNum + ". " + value.getVehicleType() + " - Max Fuel = " + value.getMaxFuel() + ", Max Damage = " + value.getMaxDamage() +
          ", Boost Distance = " + value.getBoost() + "\n");
          optNum ++;
        }
        
        return vehicleOpts;
    }

    /**
     * Creates a new Vehicle Object and adds to the list helf in the Object
     *
     * @param vehicleType              The Type of vehicle as a string.
     * @param boost                    The boost of a vehicel as an integer.
     * @param maxFuel                  The maximum fuel of a vehicle as an integer.
     * @param maxDamage                The maximum damage of a vehicle as an integer.
     */
    public void createVehicle(String vehicleType, int boost, int maxFuel, int maxDamage)
    {
        vehicles.add(new Vehicle(vehicleType, boost, maxFuel, maxDamage));
    }

    /**
     * Returns the size of the ArrayList
     *
     * @return                         The size of the ArrayList as an integer.
     */
    public int getVehicleListSize()
    {
        return this.vehicles.size();
    }

    /**
     * Accessor method to get the list of Vehicles.
     *
     * @return              An arraylist of Vehicle objects held in the Object.
     */
    public ArrayList<Vehicle> getVehicles()
    {
        return this.vehicles;
    }

    /**
     * Accessor method to get a specific Vehicle Object from the list
     *
     * @param index         An integer representing the index of an object in the arrayList.
     * 
     * @return              A specific vehicle object from the vehicle list.
     */
    public Vehicle getSpecificVehicle(int index)
    {
        return this.vehicles.get(index);
    }

    /**
     * Mutator method to set a specific Vehicle Object in the list
     *
     * @param index         An integer representing the index of an object in the arrayList.
     * @param vehicle       A vehicle object
     */
    public void setSpecificVehicle(int index, Vehicle vehicle)
    {
        this.vehicles.set(index, vehicle);
    }

    /**
     * Mutator method to set the arraylist to an alternate arraylist.
     *
     * @param vehicles        An arraylist of vehicle objects.
     */
    public void setVehicles(ArrayList<Vehicle> vehicles)
    {
        this.vehicles = vehicles;
    }
}
