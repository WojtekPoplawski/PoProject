package bin.functions;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public Database Program_start(Functions functions) throws IOException, ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        Database database = null;
        String option;
        do {
            System.out.println(
                    """
                            Menu :\s
                              1. Create database file.
                              2. Read database file.
                              3. Use standard database file.
                              X. Exit program.
                            Option :\s"""
            );
            option = in.next();
            switch (option){
                case "1":
                    System.out.println("Enter database file name :");
                    String path = in.next();
                    database = functions.Create_database(path);
                    option = "x";
                    break;
                case "2":
                    System.out.println("Enter database file name :");
                    path = in.next();
                    database = functions.Read_database(path);
                    option = "x";
                    break;
                case "3":
                    System.out.println("Program will create standard database.");
                    database = functions.Read_database("Std_database");
                    option = "x";
                    break;
                case "x":
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Incorrect option. Please choose from available.");
                    break;
            }
        }while(!"x".equals(option));
        return database;
    }
    public void Program_Run(Functions functions,Database database) throws IOException {
        Scanner in = new Scanner(System.in);
        String first_option,second_option;
        System.out.println("Database "+ database.path + " file loaded.");
        do{
            System.out.println("""
                    Menu :\s
                      1. Manage vehicle list.
                      2. Manage client list.
                      3. Manage rental list.
                      X. Exit program.
                    Option :\s""");
            first_option = in.next();
            switch (first_option){
                case "1":
                {
                    do{
                        System.out.println("""
                                Menu :
                                  1. Show vehicle list.
                                  2. Add Car to list.
                                  3. Add Truck to list.
                                  4. Add Bus to list.
                                  5. Remove vehicle from list.
                                  6. Search list by identification number.
                                  7. Search list by type.
                                  8. Search list by model
                                  9. Search list for vehicles with horsepower lower than stated.
                                  10. Search list for vehicles with horsepower higher than stated.
                                  11. Search list for vehicles with cost lower than stated.
                                  12. Search list for available to rent vehicles.
                                  13. Search list for unavailable to rent vehicles.
                                  C. Go back to menu.""");
                        second_option = in.next();
                        switch (second_option) {
                            case "1" -> functions.Show_Vehicle_List(database.vehicles_list);
                            case "2" -> functions.Add_new_car(database.vehicles_list);
                            case "3" -> functions.Add_new_truck(database.vehicles_list);
                            case "4" -> functions.Add_new_bus(database.vehicles_list);
                            case "5" -> functions.Remove_vehicle_from_list(database.vehicles_list);
                            case "6" -> functions.Show_vehicles_by_ID(database.vehicles_list);
                            case "7" -> functions.Show_vehicles_by_type(database.vehicles_list);
                            case "8" -> functions.Show_vehicles_by_model(database.vehicles_list);
                            case "9" -> functions.Show_vehicles_by_Eng_HP_lower(database.vehicles_list);
                            case "10" -> functions.Show_vehicles_by_Eng_HP_higher(database.vehicles_list);
                            case "11" -> functions.Show_vehicles_by_cost(database.vehicles_list);
                            case "12" -> functions.Show_available_vehicles(database.vehicles_list);
                            case "13" -> functions.Show_unavailable_vehicles(database.vehicles_list);
                            case "c" -> {
                                System.out.println("Saving changes.");
                                functions.Save_database(database.path, database);
                            }
                            default -> System.out.println("Incorrect option. Please choose from available.");
                        }
                    }while (!"c".equals(second_option));
                    break;
                }
                case "2":
                {
                    do {
                        System.out.println("""
                                Menu :
                                  1. Show client list.
                                  2. Add private client.
                                  3. Add company client.
                                  4. Remove client from list.
                                  5. Search for now renting clients.
                                  6. Search for not renting clients.
                                  7. Search for clients with paid rental.
                                  8. Search for clients with not paid rental.
                                  C. Go back to menu.""");
                        second_option = in.next();
                        switch (second_option) {
                            case "1" -> functions.Show_Client_list(database.client_list);
                            case "2" -> functions.Add_New_Private_Client(database.client_list);
                            case "3" -> functions.Add_New_Company_Client(database.client_list);
                            case "4" -> functions.Remove_client_from_list(database.client_list);
                            case "5" -> functions.Show_renting_clients(database.client_list);
                            case "6" -> functions.Show_not_renting_clients(database.client_list);
                            case "7" -> functions.Show_paid_clients(database.client_list);
                            case "8" -> functions.Show_not_paid_clients(database.client_list);
                            case "c" -> {
                                System.out.println("Saving changes.");
                                functions.Save_database(database.path, database);
                            }
                            default -> System.out.println("Incorrect option. Please choose from available.");
                        }
                    }while (!"c".equals(second_option));
                    break;
                }
                case "3":
                {
                    do {
                        System.out.println("""
                                Menu :
                                  1. Show rental list.
                                  2. Add new rental.
                                  3. Set rental as paid.
                                  4. End rental.
                                  C. Go back to menu.""");
                        second_option = in.next();
                        switch (second_option) {
                            case "1" -> functions.Show_rental_list(database.rental_list);
                            case "2" -> functions.Add_Rental(database.rental_list, database.client_list, database.vehicles_list);
                            case "3" -> functions.Rental_Paid(database.rental_list);
                            case "4" -> functions.End_Rental(database.rental_list);
                            case "c" -> {
                                System.out.println("Saving changes.");
                                functions.Save_database(database.path, database);
                            }
                            default -> System.out.println("Incorrect option. Please choose from available.");
                        }
                    }while (!"c".equals(second_option));
                    break;
                }
                case "x":
                    try {
                        functions.Save_database(database.path, database);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }while (!"x".equals(first_option));
    }

}
