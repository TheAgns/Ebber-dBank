package Controller;

import UserLogin.CustomerLogin;

import java.sql.SQLException;
import java.util.Scanner;

public class MainController {
    CustomerLogin customerLogin = new CustomerLogin();
    int choice = 0;
    Scanner scanner;
    public MainController(){
        this.scanner = new Scanner(System.in);
    }
    public void runProgram() throws SQLException {
        while(this.choice != 9){
            System.out.println("For customer press 1, for manager press 2");
            this.choice = this.scanner.nextInt();
            if(this.choice == 1){
                this.customerLogin.login();
            }else{
                System.out.println("Choose the correct number");
            }

        }
    }
}
