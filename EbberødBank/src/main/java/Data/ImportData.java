package Data;

import Domain.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Connection.JDBC;

public class ImportData {
    public static List<Customer> fillList() throws SQLException {
        Customer customer = new Customer();
        ExportData exportData = new ExportData();
        List<Customer> medlemListe = new ArrayList<Customer>();
        Statement stmt = null;
        ResultSet res = null;
        String sql = "select * from bankData.Konti";
        Connection con = JDBC.getConnection();
        stmt = con.createStatement();
        res = stmt.executeQuery(sql);
        while (res.next()) {
            int accountBalance = res.getInt("Balance");
            String FirstName = res.getString("FirstName");
            String LastName = res.getString("LastName");
            int medlemId = res.getInt(1);
            customer = new Customer(medlemId,accountBalance,FirstName,LastName);
            medlemListe.add(customer);
        }
        return medlemListe;
    }
}
