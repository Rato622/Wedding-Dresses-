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
public class Client 
{
    
    private int clientId;
    private String name;
    private String surname;
    private int age;
     private String gender;
    private int cellNo;
    private String streetName;
    private int houseNo;
    private String city;
     private String email;
    private int zipCode;
    
   

    public Client() {
    }

    public Client(int clientId,String name, String surname, int age,String gender,int cellNo,String StreetName, int houseNo, String city,String emai, int zipCode) {
      this.clientId = clientId;
    this.name=name;
    this.surname =surname;
    this.age=age;
    this.gender = gender;
    this.cellNo =cellNo;
   this.streetName =streetName;
   this.houseNo = houseNo;
   this.city = city;
     this.email = emai;
   this.zipCode = zipCode;
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

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streString) {
        this.streetName = streetName;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCellNo() {
        return cellNo;
    }

    public void setCellNo(int cellNo) {
        this.cellNo = cellNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
    
    
}
