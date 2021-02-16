package Handler;

import Domain.Customer;

import java.sql.SQLException;

public interface CustomerHandlerI {
    Customer getCustomerById(int id) throws SQLException, NoSuchFieldException;

    void changeBalance(int desposit, int choice) throws SQLException;

    void despositMoney() throws SQLException;

    void withdrawMoney();

    void checkBalance();
}
