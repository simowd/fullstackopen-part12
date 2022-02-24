package arquitectura.software.mssale.model;

public class Customer {
    private Integer customerId;
    private String name;
    private String lastName;
    private String email;

    public Customer() {
    }

    public Customer(Integer customerId, String name, String lastName, String email) {
        this.customerId = customerId;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}