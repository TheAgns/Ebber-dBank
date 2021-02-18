package Handler;

import Data.ExportData;
import Data.ImportData;
import Domain.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Connection.JDBC;

public class CustomerHandler {
    private List<Transaction> transactions;
    private Customer customer;

    public CustomerHandler(){

    }
    public CustomerHandler(Customer customer){
        this.transactions = new ArrayList();
        this.customer = customer;
    }

    public Customer getCustomerById(int id) throws SQLException, NoSuchFieldException {
        Customer retVal = null;
        Connection connection = JDBC.getConnection();
        String query = "SELECT PersonId from Konti where PersonId = " + id;
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        if(retVal == null){
            throw new NoSuchFieldException("No customers with the given ID");
        }
        return retVal;
    }
    ImportData importData = new ImportData();
    Scanner scanner;
    List<Customer> customerList = new ArrayList<Customer>();

    public void changeBalance(int desposit, int choice) throws SQLException {
        //customerList = importData.fillList();
        Connection connection = JDBC.getConnection();
            String query = "UPDATE customerInfo SET current_balance = (current_balance+"+desposit+") WHERE person_ID = " + choice+";";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();

        }


    public void despositMoney() throws SQLException {
        ExportData exportData = new ExportData();
        Customer customer = new Customer();
        int choice = 0;
        int despositAmount = 0;
        System.out.println("Choose person ID:");
        scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        System.out.println("Amount to desposit?");
        despositAmount = scanner.nextInt();
        changeBalance(despositAmount, choice);
        int medlemId = exportData.saveDataCustomer(customer);
        customer.setId(medlemId);
    }
    public void changeBalanceMinus(int withdraw, int choice) throws SQLException {
        Connection connection = JDBC.getConnection();
        String query = "UPDATE customerInfo SET current_balance = (current_balance-"+withdraw+") WHERE person_ID = " + choice+";";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
    }

    public void withdrawMoney() throws SQLException {
        ExportData exportData = new ExportData();
        Customer customer = new Customer();
        int choice = 0;
        int despositAmount = 0;
        System.out.println("Choose person ID:");
        scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        System.out.println("Amount to withdraw?");
        despositAmount = scanner.nextInt();
        changeBalanceMinus(despositAmount, choice);
        int medlemId = exportData.saveDataCustomer(customer);
        customer.setId(medlemId);
    }
    public void checkTransactions() throws SQLException {
        List<Transaction> transactions = new ArrayList<Transaction>();
        Connection connection = JDBC.getConnection();





        System.out.println(transactions);
    }

    public void transferMoney() {
    }
}
