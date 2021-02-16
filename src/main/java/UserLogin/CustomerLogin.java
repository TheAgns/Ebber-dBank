package UserLogin;

import Controller.CustomerController;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerLogin {
    CustomerController customerController = new CustomerController();
    Scanner scanner;
    String correctUsername;
    String correctPassword;
    String username;
    String password;

    public CustomerLogin() {
        this.scanner = new Scanner(System.in);
        this.correctUsername = "customer";
        this.correctPassword = "customer";
        this.username = "";
        this.password = "";
    }

    public void login() throws SQLException {
        System.out.println("Enter username: ");
        this.username = this.scanner.nextLine();
        System.out.println("Enter password: ");
        this.password = this.scanner.nextLine();
        if (this.username.equals(this.correctUsername) && this.password.equals(this.correctPassword)) {
            this.customerController.runProgram();
        } else {
            System.out.println("Forkert username eller password");
        }

    }
}
