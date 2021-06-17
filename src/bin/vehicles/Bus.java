package bin.vehicles;

import java.io.Serializable;

public class Bus extends Vehicle implements Serializable {
    private final String Bus_Type;
    private final int Capacity;
    private final boolean Seat_for_Guide;

    public Bus(int Identification_number,String model,int eng_HP,double rental_cost_per_Day,String bus_Type, int capacity, boolean seat_for_Guide) {
        this.Identification_Number = Identification_number;
        this.Type = "Bus";
        this.Model = model;
        this.Eng_HP = eng_HP;
        this.Rental_cost_per_Day = rental_cost_per_Day;
        this.Rental_availability = true;
        this.Bus_Type = bus_Type;
        this.Capacity = capacity;
        this.Seat_for_Guide = seat_for_Guide;
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
                "\n- Bus type : " + Bus_Type +
                "\n- Capacity : " + Capacity +
                "\n- Seat for Guide : " + Seat_for_Guide;
    }
}
