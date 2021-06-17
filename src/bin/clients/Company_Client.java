package bin.clients;

import java.io.Serializable;

public class Company_Client extends Client implements Serializable {
    private String Title;
    private String Company_ID;
    private int Insurance_Number;

    public void setTitle(String title) {
        Title = title;
    }
    public void setCompany_ID(String company_ID) {
        Company_ID = company_ID;
    }
    public void setInsurance_Number(int insurance_Number) {
        Insurance_Number = insurance_Number;
    }
    public Company_Client(String title, String company_ID, int insurance_Number) {
        setTitle(title);
        setCompany_ID(company_ID);
        setInsurance_Number(insurance_Number);
        setRental_Start_Date(null);
        setRental_Days(0);
        setNow_Renting(false);
        setRental_Paid(false);
    }
    public String toString(){
        if(Now_Renting){
            return "Company Client :" +
                    "\n- Title : " + Title +
                    "\n- Company ID : " + Company_ID +
                    "\n- Insurance Number : " + Insurance_Number +
                    "\n- Now Renting : Yes" +
                    "\n- Rental Start Date : " + Rental_Start_Date +
                    "\n- Rental Days : " + Rental_Days +
                    "\n- Rental Paid : " + Rental_Paid;
        }
        else{
            return "Company Client :" +
                    "\n- Title : " + Title +
                    "\n- Company ID : " + Company_ID +
                    "\n- Insurance Number : " + Insurance_Number +
                    "\n- Now Renting : No";
        }
    }
}
