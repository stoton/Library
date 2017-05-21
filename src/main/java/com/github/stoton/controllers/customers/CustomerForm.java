package com.github.stoton.controllers.customers;

import com.github.stoton.domain.Address;
import com.github.stoton.domain.Customer;


public class CustomerForm {
    private String firstName;
    private String lastName;
    private String pesel;
    private Address address;

    public CustomerForm(String firstName, String lastName, String pesel, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.address = address;
    }

    public CustomerForm() {}

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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Customer convertToCustomer() {
        Customer customer = new Customer();
        customer.setFirstName(this.firstName);
        customer.setLastName(this.lastName);
        customer.setPesel(this.pesel);
        customer.setAddress(this.address);
        return customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerForm that = (CustomerForm) o;

        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (pesel != null ? !pesel.equals(that.pesel) : that.pesel != null) return false;
        return address != null ? address.equals(that.address) : that.address == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (pesel != null ? pesel.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "CustomerForm{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", address=" + address +
                '}';
    }
}
