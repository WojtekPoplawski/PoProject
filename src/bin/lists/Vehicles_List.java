package bin.lists;
import bin.vehicles.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Vehicles_List implements Serializable {
    ArrayList<Vehicle> vehicles_list = new ArrayList<>();
    public Vehicles_List() {
    }
    public void Add_to_Vehicles_List(Vehicle vehicle){
        vehicles_list.add(vehicle);
    }
    public void Remove_Vehicle(Vehicle vehicle){
        vehicles_list.remove(vehicle);
    }
    public void Remove_Vehicle(int index){
        try {
            vehicles_list.remove(index);
        }catch (IndexOutOfBoundsException exception){
            System.out.println("Incorrect index.");
        }
    }
    public Vehicle Get_Vehicle_from_List(int index){
        return vehicles_list.get(index);
    }
    public int Number_of_Vehicles(){
        return vehicles_list.size();
    }
    public void Get_All_Vehicles(){
        int index = 0;
        System.out.println("Vehicles List ("+ Number_of_Vehicles() +" vehicles): ");
        for (Vehicle vehicle : vehicles_list) {
            System.out.println(index + ". " + vehicle);
            index++;
        }
    }
    public void Search_for_available_Vehicles(boolean availability){
        int index = 0;
        System.out.println("Vehicles List : ");
        for (Vehicle vehicle : vehicles_list) {
            if (vehicle.isRental_availability() == availability){
                System.out.println(index + ". " + vehicle);
            }
        }
    }
    public void Search_For_Vehicle_by_Type(String Type){
        int index = 0;
        System.out.println(Type + "List : ");
        for (Vehicle vehicle : vehicles_list) {
            if (vehicle.getType().equals(Type)) {
                System.out.println(index + ". " + vehicle);
            }
            index++;
        }
    }
    public void Search_For_Vehicle_by_Identification_Number(int Identification_Number){
        int index = 0;
        System.out.println("Vehicle with Identification Number : " + Identification_Number + " List : ");
        for (Vehicle vehicle : vehicles_list) {
            if (vehicle.getIdentification_Number() == Identification_Number) {
                System.out.println(index + ". " + vehicle);
            }
            index++;
        }
    }
    public void Search_For_Vehicle_by_Model(String Model){
        int index = 0;
        System.out.println(Model + "List : ");
        for (Vehicle vehicle : vehicles_list) {
            if (vehicle.getModel().equals(Model)) {
                System.out.println(index + ". " + vehicle);
            }
            index++;
        }
    }
    public void Search_For_Vehicle_by_Eng_HP_higher(int Eng_HP){
        int index = 0;
        System.out.println("Vehicle with Engine Horsepower : " + Eng_HP + " List : ");
        for (Vehicle vehicle : vehicles_list) {
            if (vehicle.getEng_HP() >= Eng_HP) {
                System.out.println(index + ". " + vehicle);
            }
            index++;
        }
    }
    public void Search_For_Vehicle_by_Eng_HP_lower(int Eng_HP){
        int index = 0;
        System.out.println("Vehicle with Engine Horsepower : " + Eng_HP + " List : ");
        for (Vehicle vehicle : vehicles_list) {
            if (vehicle.getEng_HP() <= Eng_HP) {
                System.out.println(index + ". " + vehicle);
            }
            index++;
        }
    }
    public void Search_For_Vehicle_by_Cost(Double Cost){
        int index = 0;
        System.out.println("Vehicle with cost per day lower than " + Cost + " List : ");
        for (Vehicle vehicle : vehicles_list) {
            if (vehicle.getRental_cost_per_Day() <= Cost) {
                System.out.println(index + ". " + vehicle);
            }
            index++;
        }
    }
}
