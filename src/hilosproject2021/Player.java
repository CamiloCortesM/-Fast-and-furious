/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilosproject2021;

/**
 *
 * @author 57320
 */
public class Player {
    private String name;
    private int id;
    private String username;
    private String Country;
    private String City;
    private String Car;

    public String getCar() {
        return Car;
    }

    public void setCar(String Carro) {
        this.Car = Carro;
    }

   
    public Player(String name, int id, String username, String Country,String City,String Car) {
        this.name = name;
        this.id = id;
        this.username = username;
        this.Country = Country;
        this.City = City;
        this.Car = Car;
    }
    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }
    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Localitation) {
        this.Country = Localitation;
    }
    
    
}
