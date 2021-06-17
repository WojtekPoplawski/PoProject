package bin.lists;

import java.io.Serializable;
import java.util.ArrayList;

public class Rental_List implements Serializable {
    ArrayList<Rental> rental_list = new ArrayList<>();

    public Rental_List() {
    }
    public void Get_rental_list(){
        System.out.println("Rental list (" + Number_of_rentals() + " rentals) : ");
        int index = 0;
        for (Rental rental : rental_list) {
            System.out.println(index + " . " + rental);
            index++;
        }
    }
    public void Add_to_rental_list(Rental rental){
        rental_list.add(rental);
    }
    public void Remove_from_rental_list(int index){
        rental_list.remove(index);
    }
    public void Remove_from_rental_list(Rental rental){
        rental_list.remove(rental);
    }
    public Rental Get_rental_from_list(int index){
        return rental_list.get(index);
    }
    public int Number_of_rentals(){
        return rental_list.size();
    }
}
