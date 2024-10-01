

import java.util.Objects;
import java.util.UUID;


class Person {
    private String name;
    private int age;
    private String username;
    private String password;

    public Person(String name, int age, String username, String password) {
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(username, person.username) && Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}

class Customer extends Person {
    private String customerID;
    private double balance;


    public Customer(String name, int age, String username, String password) {
        super(name, age, username, password);

        this.customerID = UUID.randomUUID().toString();
        this.balance = 0.0;
    }

    public String getCustomerID() {
        return customerID;
    }

    // Getter and Setter for balance
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Customer{customerID='" + customerID + "', name='" + getName() + "', age=" + getAge() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;

        return (Objects.equals(getUsername(), customer.getUsername()) && Objects.equals(getPassword(), customer.getPassword())) ||
                (Objects.equals(customerID, customer.customerID) && Objects.equals(getPassword(), customer.getPassword()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerID, getUsername(), getPassword());
    }

    public static void main(String[] args) {

        Customer customer1 = new Customer("Abdalla", 30, "Guled123", "Guleed123");
        Customer customer2 = new Customer("samu", 28, "samu123", "password123");
        Customer customer3 = new Customer("Ali", 30, "ali123", "password123");


        System.out.println(customer1);
        System.out.println(customer2);


        customer1.setBalance(500.00);
        System.out.println("Customer1 balance: " + customer1.getBalance());


        if (customer1.equals(customer3)) {
            System.out.println("Customer1 and Customer3 are equal (username/password or customerID/password match).");
        } else {
            System.out.println("Customer1 and Customer3 are not equal.");
        }

        if (customer1.equals(customer2)) {
            System.out.println("Customer1 and Customer2 are equal.");
        } else {
            System.out.println("Customer1 and Customer2 are not equal.");
        }
    }
}
