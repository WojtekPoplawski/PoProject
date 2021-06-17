package bin.functions;

import bin.lists.Client_List;
import bin.lists.Rental_List;
import bin.lists.Vehicles_List;
import java.io.Serializable;

public class Database implements Serializable {
    public Vehicles_List vehicles_list;
    public Rental_List rental_list;
    public Client_List client_list;
    public String path;

    public Database(Vehicles_List vehicles_list, Rental_List rental_list, Client_List client_list,String path) {
        this.vehicles_list = vehicles_list;
        this.rental_list = rental_list;
        this.client_list = client_list;
        this.path = path;
    }

}
