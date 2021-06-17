package bin.vehicles;

import java.io.Serializable;

public class Car extends Vehicle implements Serializable {
    private final int Number_of_Doors;
    private final int Trunk_Capacity;
    private final boolean GPS_included;

    public Car(int Identification_Number,String model,int eng_HP,double rental_cost_per_Day,int number_of_Doors, int trunk_Capacity, boolean GPS_included) {
        this.Identification_Number = Identification_Number;
        this.Type = "Car";
        this.Model = model;
        this.Eng_HP = eng_HP;
        this.Rental_cost_per_Day = rental_cost_per_Day;
        this.Rental_availability = true;
        this.Number_of_Doors = number_of_Doors;
        this.Trunk_Capacity = trunk_Capacity;
        this.GPS_included = GPS_included;
    }

    @Override
    public String toString() {
        return "Vehicle : " +
                "\n- Identification number : " + Identification_Number +
                "\n- Type : " + Type +
                "\n- Model : " + Model +
                "\n- Eng HP : " + Eng_HP +
                "\n- Rental cost per day : " + Rental_cost_per_Day +
                "\n- Rental availability : " + Rental_availability +
                "\n- Number of Doors : " + Number_of_Doors +
                "\n- Trunk Capacity : " + Trunk_Capacity +
                "\n- GPS included : " + GPS_included ;
    }
}
