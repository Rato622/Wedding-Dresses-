/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pojos;

/**
 *
 * @author user
 */
public class Register {
    
    private String clientId;
    private String name;
    private String surname;
    private int age;
    private String gender; 
    private String cellNo;
    private String email;
    private String address;

    public Register(String clientId, String name, String surname, int age, String gender, String cellNo, String email, String address) {
        this.clientId = clientId;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.cellNo = cellNo;
        this.email = email;
        this.address = address;
    }

    
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCellNo() {
        return cellNo;
    }

    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
