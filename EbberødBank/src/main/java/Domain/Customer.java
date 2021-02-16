package Domain;

public class Customer {
    private int id;
    private int accountBalance;
    private String firstName;
    private String lastName;

    public Customer(int id, int accountBalance, String firstName, String lastName) {
        this.id = id;
        this.accountBalance = accountBalance;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer() {
        this.id = id;
        this.accountBalance = accountBalance;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Domain.Customer{" +
                "id=" + id +
                ", accountBalance=" + accountBalance +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
