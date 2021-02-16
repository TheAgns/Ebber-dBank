package Data;
import Domain.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Connection.JDBC;

public class ExportData {
    public int saveDataCustomer(Customer customer) throws SQLException {
        int medlemId = 0;
        ResultSet rs = null;
        Connection connection = JDBC.getConnection();
        String query = " INSERT INTO konti (FirstName, LastName, Balance)"
                + " values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, customer.getFirstName());
        preparedStatement.setString(2, customer.getLastName());
        preparedStatement.setInt(3,customer.getAccountBalance());
        preparedStatement.executeUpdate();
//TODO : fetch medlemId from order table
        rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {
            medlemId = rs.getInt(1);
        }
        return medlemId;
    }
}
