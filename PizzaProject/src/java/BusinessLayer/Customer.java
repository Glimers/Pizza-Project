/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DatabaseLayer.DatabaseBean;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author ethan
 */
@Named(value="cust")
@Stateless
public class Customer {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private int houseNumber;
    private String street;
    private String province;
    private String postalCode;
    private int delivery;

    public Customer() {
        //this.firstName = "";
        
    }

   /* public Customer(String firstName, String lastName, String phoneNumber, String email, int houseNumber, String street, String province, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.houseNumber = houseNumber;
        this.street = street;
        this.province = province;
        this.postalCode = postalCode;
    } //this constructor will be used for deliveries

    public Customer(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.houseNumber = 0;
        this.street = "";
        this.province = "";
        this.postalCode = "";
    } //this constructor will be used for pickup orders*/

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getDelivery() {
        return delivery;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }
    
    
    
    
    
}
