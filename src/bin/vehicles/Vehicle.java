package bin.vehicles;

import java.io.Serializable;

public abstract class Vehicle implements Serializable {
    int Identification_Number;
    String Type;
    String Model;
    int Eng_HP;
    double Rental_cost_per_Day;
    boolean Rental_availability;

    public int getIdentification_Number() {
        return Identification_Number;
    }
    public String getType() {
        return Type;
    }
    public String getModel() {
        return Model;
    }
    public int getEng_HP() {
        return Eng_HP;
    }
    public double getRental_cost_per_Day() {
        return Rental_cost_per_Day;
    }
    public boolean isRental_availability() {
        return Rental_availability;
    }
    public void setRental_availability(boolean rental_availability) {
        Rental_availability = rental_availability;
    }
}
