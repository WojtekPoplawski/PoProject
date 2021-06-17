package bin.vehicles;

import java.io.Serializable;

public class Truck extends Vehicle implements Serializable {
    private final double Permissible_Gross_Weight;
    private final int Number_of_Axles;
    private final boolean Differential_Lock;

    public Truck(int Identification_number,String model,int eng_HP,double rental_cost_per_Day, double permissible_Gross_Weight, int number_of_Axles, boolean differential_Lock) {
        this.Identification_Number = Identification_number;
        this.Type = "Truck";
        this.Model = model;
        this.Eng_HP = eng_HP;
        this.Rental_cost_per_Day = rental_cost_per_Day;
        this.Rental_availability = true;
        this.Permissible_Gross_Weight = permissible_Gross_Weight;
        this.Number_of_Axles = number_of_Axles;
        this.Differential_Lock = differential_Lock;
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
                "\n- Permissible gross weight : " + Permissible_Gross_Weight +
                "\n- Number of axles : " + Number_of_Axles +
                "\n- Differential lock : " + Differential_Lock;
    }
}
