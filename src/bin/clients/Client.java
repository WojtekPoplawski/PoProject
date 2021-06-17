package bin.clients;

import java.io.Serializable;

public abstract class Client implements Serializable {
    String Rental_Start_Date;
    int Rental_Days;
    boolean Now_Renting;
    boolean Rental_Paid;

    public void setRental_Start_Date(String rental_Start_Date) {
        Rental_Start_Date = rental_Start_Date;
    }
    public void setRental_Days(int rental_Days) {
        Rental_Days = rental_Days;
    }
    public boolean isNow_Renting() {
        return Now_Renting;
    }
    public void setNow_Renting(boolean now_Renting) {
        Now_Renting = now_Renting;
    }
    public boolean isRental_Paid() {
        return Rental_Paid;
    }
    public void setRental_Paid(boolean rental_Paid) {
        Rental_Paid = rental_Paid;
    }
    public void Edit_Client (String rental_Start_Date,int rental_Days,boolean now_Renting,boolean rental_Paid){
        setRental_Start_Date(rental_Start_Date);
        setRental_Days(rental_Days);
        setNow_Renting(now_Renting);
        setRental_Paid(rental_Paid);
    }
}
