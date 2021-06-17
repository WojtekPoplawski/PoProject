package bin.functions;

import bin.clients.*;
import bin.lists.Rental;
import bin.lists.Rental_List;
import bin.lists.Vehicles_List;
import bin.vehicles.*;
import bin.lists.Client_List;
import java.io.*;
import java.util.Scanner;

public class Functions implements Serializable{
    public void Add_New_Private_Client(Client_List client_list){
        Scanner in = new Scanner(System.in);
        String Name,Surname,ID_Number;
        System.out.print("Name : ");
        Name = in.next();
        System.out.print("Surname : ");
        Surname = in.next();
        System.out.print("ID Number : ");
        ID_Number = in.next();
        Private_Client Client = new Private_Client(Name,Surname,ID_Number);
        client_list.Add_to_Client_List(Client);
        System.out.print("Client has been added. \n");
    }
    public void Add_New_Company_Client(Client_List client_list){
        Scanner in = new Scanner(System.in);
        String Title,Company_ID;
        int Insurance_Number;
        System.out.print("Title : ");
        Title = in.nextLine();
        System.out.print("Company ID : ");
        Company_ID = in.nextLine();
        System.out.print("Insurance Number : ");
        Insurance_Number = in.nextInt();
        Company_Client Client = new Company_Client(Title,Company_ID,Insurance_Number);
        client_list.Add_to_Client_List(Client);
        System.out.print("Client has been added.\n");
    }
    public void Show_Client_list(Client_List client_list){
        client_list.Get_All_Clients();
    }
    public void Show_rental_list(Rental_List rental_list){
        rental_list.Get_rental_list();
    }
    public void End_Rental(Rental_List rental_list){
        Scanner in = new Scanner(System.in);
        int index;
        System.out.println("Enter rental index : ");
        index = in.nextInt();
        if (rental_list.Get_rental_from_list(index).getClient().isRental_Paid()){
            rental_list.Get_rental_from_list(index).getVehicle().setRental_availability(true);
            rental_list.Get_rental_from_list(index).getClient().Edit_Client("",0,false,false);
            rental_list.Remove_from_rental_list(index);
            System.out.print("Rental has been removed.");
        }
        else
            System.out.println("Before ending rental it has to be paid. ");
    }
    public void Add_Rental(Rental_List rental_list,Client_List client_list, Vehicles_List vehicles_list){
        Scanner in = new Scanner(System.in);
        String Rental_Start_Date;
        int Rental_Days,index_client,index_vehicle;
        System.out.print("Enter index of renting client : ");
        while (!in.hasNextInt()) in.next();
        index_client = in.nextInt();
        System.out.print("Enter index of renting vehicle : ");
        while (!in.hasNextInt()) in.next();
        index_vehicle = in.nextInt();
        System.out.print("Rental start date : ");
        Rental_Start_Date = in.next();
        System.out.print("Rental days : ");
        Rental_Days = in.nextInt();
        try {
            Rental rental = new Rental(client_list.Get_Client_from_List(index_client),vehicles_list.Get_Vehicle_from_List(index_vehicle));
            rental.getClient().Edit_Client(Rental_Start_Date,Rental_Days,true,false);
            rental.getVehicle().setRental_availability(false);
            rental_list.Add_to_rental_list(rental);
            System.out.println("Rental has been added.");
        }catch(IndexOutOfBoundsException indexOutOfBoundsException){
            System.out.print("Client or vehicle index is incorrect. Rental is not created.\n");
        }
    }
    public void Rental_Paid(Rental_List rental_list){
        Scanner in = new Scanner(System.in);
        int index_client;
        System.out.print("Enter index of rental : ");
        while (!in.hasNextInt()) in.next();
        index_client = in.nextInt();
        rental_list.Get_rental_from_list(index_client).getClient().setRental_Paid(true);
        System.out.println("Rental has been paid.");
    }
    public void Add_new_car(Vehicles_List vehicles_list){
        Scanner in = new Scanner(System.in);
        String Model;
        int Eng_HP;
        int Identification_Number;
        int Number_of_doors;
        int Trunk_Capacity;
        String GPS_availability;
        boolean GPS = false,Temp = false;
        double Rental_cost_per_day;
        System.out.print("Identification Number : ");
        while (!in.hasNextInt()) {
            System.out.println("Enter number : ");
            in.next();
        }
        Identification_Number = in.nextInt();
        System.out.print("Model : ");
        Model = in.next();
        System.out.print("Engine Horsepower : ");
        while (!in.hasNextInt()) {
            System.out.println("Enter number : ");
            in.next();
        }
        Eng_HP = in.nextInt();
        System.out.print("Rental cost per day : ");
        while (!in.hasNextDouble()) {
            System.out.println("Enter number : ");
            in.next();
        }
        Rental_cost_per_day = in.nextDouble();
        System.out.print("Number of doors : ");
        while (!in.hasNextInt()) {
            System.out.println("Enter number : ");
            in.next();
        }
        Number_of_doors = in.nextInt();
        System.out.print("Trunk capacity : ");
        while (!in.hasNextInt()) {
            System.out.println("Enter number : ");
            in.next();
        }
        Trunk_Capacity = in.nextInt();
        do{
            System.out.print("GPS availability : \n 1. Yes \n 2. No\nOption : ");
            GPS_availability = in.next();
            if (GPS_availability.equals("1")){
                GPS = true;
                Temp = true;
            }
            else if (GPS_availability.equals("2")){
                Temp = true;
            }
            else {
                System.out.print("Please choose between 1 or 2. \n");
            }
        }while (!Temp);
        Car car = new Car(Identification_Number,Model,Eng_HP,Rental_cost_per_day,Number_of_doors,Trunk_Capacity,GPS);
        vehicles_list.Add_to_Vehicles_List(car);
        System.out.println("Vehicle has been added.");
    }
    public void Add_new_truck(Vehicles_List vehicles_list){
        Scanner in = new Scanner(System.in);
        String Model;
        int Eng_HP;
        int Identification_Number;
        String Differential;
        int Number_of_Axles;
        boolean temp = false,Differential_Lock = false;
        double Rental_cost_per_day,Permissible_Gross_Weight;
        System.out.print("Identification Number : ");
        while (!in.hasNextInt()) {
            System.out.println("Enter number : ");
            in.next();
        }
        Identification_Number = in.nextInt();
        System.out.print("Model : ");
        Model = in.next();
        System.out.print("Engine Horsepower : ");
        while (!in.hasNextInt()) {
            System.out.println("Enter number : ");
            in.next();
        }
        Eng_HP = in.nextInt();
        System.out.print("Rental cost per day : ");
        while (!in.hasNextDouble()) {
            System.out.println("Enter number : ");
            in.next();
        }
        Rental_cost_per_day = in.nextDouble();
        System.out.print("Permissible Gross Weight : ");
        while (!in.hasNextInt()) {
            System.out.println("Enter number : ");
            in.next();
        }
        Permissible_Gross_Weight = in.nextInt();
        System.out.print("Number of Axles : ");
        while (!in.hasNextDouble()) {
            System.out.println("Enter number : ");
            in.next();
        }
        Number_of_Axles = in.nextInt();
        do{
            System.out.print("Differential Lock availability : \n 1. Yes \n 2. No\nOption : ");
            Differential = in.next();
            if (Differential.equals("1")){
                Differential_Lock = true;
                temp = true;
            }
            else if (Differential.equals("2")){

                temp = true;
            }
            else {
                System.out.print("Please choose between 1 or 2. \n");
            }
        }while (!temp);
        Truck truck = new Truck(Identification_Number,Model,Eng_HP,Rental_cost_per_day,Permissible_Gross_Weight,Number_of_Axles,Differential_Lock);
        vehicles_list.Add_to_Vehicles_List(truck);
        System.out.println("Vehicle has been added.");
    }
    public void Add_new_bus(Vehicles_List vehicles_list){
        Scanner in = new Scanner(System.in);
        String Model,Bus_type;
        int Eng_HP;
        int Identification_Number;
        String Guide;
        int Capacity;
        boolean temp = false,Seat_for_guide = false;
        double Rental_cost_per_day;
        System.out.print("Identification Number : ");
        while (!in.hasNextInt()) {
            System.out.println("Enter number : ");
            in.next();
        }
        Identification_Number = in.nextInt();
        System.out.print("Model : ");
        Model = in.next();
        System.out.print("Engine Horsepower : ");
        while (!in.hasNextInt()) {
            System.out.println("Enter number : ");
            in.next();
        }
        Eng_HP = in.nextInt();
        System.out.print("Rental cost per day : ");
        while (!in.hasNextDouble()) {
            System.out.println("Enter number : ");
            in.next();
        }
        Rental_cost_per_day = in.nextDouble();
        System.out.print("Bus type : ");
        Bus_type = in.next();
        System.out.print("Capacity : ");
        while (!in.hasNextInt()) {
            System.out.println("Enter number : ");
            in.next();
        }
        Capacity = in.nextInt();
        do{
            System.out.print("Seat for guide availability : \n 1. Yes \n 2. No\nOption : ");
            Guide = in.next();
            if (Guide.equals("1")){
                Seat_for_guide = true;
                temp = true;
            }
            else if (Guide.equals("2")){

                temp = true;
            }
            else {
                System.out.print("Please choose between 1 or 2. \n");
            }
        }while (!temp);
        Bus bus = new Bus(Identification_Number,Model,Eng_HP,Rental_cost_per_day,Bus_type,Capacity,Seat_for_guide);
        vehicles_list.Add_to_Vehicles_List(bus);
        System.out.println("Vehicle has been added.");
    }
    public void Show_Vehicle_List(Vehicles_List vehicles_list){
        vehicles_list.Get_All_Vehicles();
    }
    public void Show_renting_clients(Client_List client_list){
        client_list.Search_for_Client_Renting(true);
    }
    public void Show_not_renting_clients(Client_List client_list){
        client_list.Search_for_Client_Renting(false);
    }
    public void Show_paid_clients(Client_List client_list){
        client_list.Search_for_Client_Rental_Paid(true);
    }
    public void Show_not_paid_clients(Client_List client_list){
        client_list.Search_for_Client_Rental_Paid(false);
    }
    public void Save_database(String path,Database database)throws IOException{
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path + ".bin"))) {
            outputStream.writeObject(database);
            outputStream.flush();
        }
    }
    public Database Read_database(String path)throws IOException,ClassNotFoundException{
        ObjectInputStream inputStream = null;
        Database database = null;
        try {
            try {
                inputStream = new ObjectInputStream(new FileInputStream(path + ".bin"));
            }catch (FileNotFoundException exception){
                System.out.println("Database file not found.");
            }
            try {
                if (inputStream != null) {
                    database = (Database)inputStream.readObject();
                }
            }
            catch (InvalidClassException invalidClassException){
                System.out.println("Database file is incorrect. ");
            }
            catch(NullPointerException nullPointerException){
                System.out.println("Program will create " + path + " database file.");
                database = new Database(new Vehicles_List(),new Rental_List(),new Client_List(),path);
            }
        } catch (EOFException exception){
            System.out.println("End of File.");
        }
        finally {
            if (inputStream!=null)
                inputStream.close();
        }
        return database;
    }
    public void Remove_vehicle_from_list(Vehicles_List vehicles_list){
        Scanner in = new Scanner(System.in);
        int index;
        System.out.println("Enter index of vehicle to delete : ");
        index = in.nextInt();
        try {
            vehicles_list.Remove_Vehicle(index);
            System.out.println("Vehicle has been removed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Database Create_database(String path){
        Database database = new Database(new Vehicles_List(),new Rental_List(),new Client_List(),path);
        try {
            Save_database(database.path, database);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return database;
    }
    public void Show_vehicles_by_type(Vehicles_List vehicles_list){
        Scanner in = new Scanner(System.in);
        String option;
        System.out.println("""
                Select type :\s
                  - 1. Car
                  - 2. Truck
                  - 3. Bus
                Option :""");
        option = in.next();
        switch (option) {
            case "1" -> vehicles_list.Search_For_Vehicle_by_Type("Car");
            case "2" -> vehicles_list.Search_For_Vehicle_by_Type("Truck");
            case "3" -> vehicles_list.Search_For_Vehicle_by_Type("Bus");
            default -> System.out.println("Incorrect option. Please choose from available.");
        }
    }
    public void Show_vehicles_by_ID(Vehicles_List vehicles_list){
        System.out.println("\nEnter identification number :");
        Scanner in = new Scanner(System.in);
        while (!in.hasNextInt()) in.next();
        vehicles_list.Search_For_Vehicle_by_Identification_Number(in.nextInt());
    }
    public void Show_vehicles_by_model(Vehicles_List vehicles_list){
        System.out.println("Enter model :");
        Scanner in = new Scanner(System.in);
        vehicles_list.Search_For_Vehicle_by_Model(in.next());
    }
    public void Show_vehicles_by_Eng_HP_higher(Vehicles_List vehicles_list){
        System.out.println("Enter engine horsepower :");
        Scanner in = new Scanner(System.in);
        while (!in.hasNextInt()) in.next();
        vehicles_list.Search_For_Vehicle_by_Eng_HP_higher(in.nextInt());
    }
    public void Show_vehicles_by_Eng_HP_lower(Vehicles_List vehicles_list){
        System.out.println("Enter engine horsepower :");
        Scanner in = new Scanner(System.in);
        while (!in.hasNextInt()) in.next();
        vehicles_list.Search_For_Vehicle_by_Eng_HP_lower(in.nextInt());
    }
    public void Show_vehicles_by_cost(Vehicles_List vehicles_list){
        System.out.println("Enter cost :");
        Scanner in = new Scanner(System.in);
        while (!in.hasNextDouble()) in.next();
        vehicles_list.Search_For_Vehicle_by_Cost(in.nextDouble());
    }
    public void Show_available_vehicles(Vehicles_List vehicles_list){
        vehicles_list.Search_for_available_Vehicles(true);
    }
    public void Show_unavailable_vehicles(Vehicles_List vehicles_list){
        vehicles_list.Search_for_available_Vehicles(false);
    }
    public void Remove_client_from_list(Client_List client_list){
        Scanner in = new Scanner(System.in);
        int index;
        System.out.println("Enter index of client to delete : ");
        index = in.nextInt();
        try {
            client_list.Remove_Client(index);
            System.out.println("Client has been removed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
