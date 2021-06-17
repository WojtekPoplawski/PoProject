package bin.lists;

import bin.clients.Client;
import bin.vehicles.Vehicle;

import java.io.Serializable;

public class Rental implements Serializable {
    private final Client client;
    private final Vehicle vehicle;

    public Rental(Client client, Vehicle vehicle) {
        this.client = client;
        this.vehicle = vehicle;
    }
    @Override
    public String toString() {
        return "\nRental : " +
                "\n - " + client +
                "\n - " + vehicle;
    }
    public Client getClient() {
        return client;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
}
