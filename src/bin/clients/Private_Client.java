package bin.clients;

import java.io.Serializable;

public class Private_Client extends Client implements Serializable {
    private String Name;
    private String Surname;
    private String ID_Number;

    public void setName(String name) {
        Name = name;
    }
    public void setSurname(String surname) {
        Surname = surname;
    }
    public void setID_Number(String ID_Number) {
        this.ID_Number = ID_Number;
    }
    public Private_Client(String Name, String Surname, String ID_Number) {
        setName(Name);
        setSurname(Surname);
        setID_Number(ID_Number);
        setNow_Renting(false);
        setRental_Start_Date(null);
        setRental_Days(0);
        setRental_Paid(false);
    }
    @Override
    public String toString(){
        if(Now_Renting){
            return "Private Client :" +
                    "\n- Name : " + Name +
                    "\n- Surname : " + Surname +
                    "\n- ID Number : " + ID_Number +
                    "\n- Now Renting : Yes" +
                    "\n- Rental Start Date : " + Rental_Start_Date +
                    "\n- Rental Days : " + Rental_Days +
                    "\n- Rental Paid : " + Rental_Paid;
        }
        else{
            return "Private Client :" +
                    "\n- Name : " + Name +
                    "\n- Surname : " + Surname +
                    "\n- ID Number : " + ID_Number +
                    "\n- Now Renting : No";
        }
    }
}
