package bin;

import bin.functions.Database;
import bin.functions.Functions;
import bin.functions.Menu;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Functions functions = new Functions();
        Database database;
        Menu menu = new Menu();
        database = menu.Program_start(functions);
        if(database != null)
        menu.Program_Run(functions,database);
    }
}
