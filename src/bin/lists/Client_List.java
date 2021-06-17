package bin.lists;
import bin.clients.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client_List implements Serializable {
    List<Client> client_list = new ArrayList<>();
    public Client_List() {
    }
    public void Add_to_Client_List(Client client){
        client_list.add(client);
    }
    public void Remove_Client(int index){
        client_list.remove(index);
    }
    public Client Get_Client_from_List(int index){
        return client_list.get(index);
    }
    public int Number_of_Clients(){
        return client_list.size();
    }
    public void Get_All_Clients(){
        int index = 0;
        System.out.println("Client List (" + Number_of_Clients() + " clients): ");
        for (Client client : client_list) {
            System.out.println(index + ". " + client);
            index++;
        }
    }
    public void Search_for_Client_Renting(boolean now_renting){
        for (Client client : client_list) {
            if(client.isNow_Renting() == now_renting){
                System.out.println(client);
            }
        }
    }
    public void Search_for_Client_Rental_Paid(boolean rental_paid){
        for (Client client : client_list) {
            if (client.isNow_Renting() && client.isRental_Paid() == rental_paid){
                System.out.println(client);
            }
        }
    }
}
