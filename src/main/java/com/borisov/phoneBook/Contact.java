package com.borisov.phoneBook;

public class Contact {
    private Integer id;
    private String firstName;
    private String lastName;
    private String phone;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", FirstName=" + firstName +
                ", LastName=" + lastName +
                ", Phone_Number=" + phone +

                '}';
    }
}
