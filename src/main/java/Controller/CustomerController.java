package Controller;

import Handler.CustomerHandler;
import UI.CustomerMenu;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerController {
    Scanner scanner = new Scanner(System.in);
    CustomerMenu customerMenu = new CustomerMenu();
    CustomerHandler customerHandler = new CustomerHandler();
    public void runProgram() throws SQLException {
        int choice = 0 ;
        int exit = 9;
        while(choice != exit){
            customerMenu.printMenu();
            choice = scanner.nextInt();
            switch (choice){
                case 1: customerHandler.despositMoney();
                break;
                case 2: customerHandler.withdrawMoney();
                break;
                case 3: customerHandler.checkBalance();
            }

        }
    }
}
