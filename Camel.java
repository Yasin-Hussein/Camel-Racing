package Game;
import java.util.Random;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yasin.hussein
 */
public class Camel {
    private int Thirst;
    private int Energy;
    private int Hunger;
    private String name;
    
    public Camel(String name) {
        this.name = name;
        this.Thirst = generateRandomValue();
        this.Hunger = generateRandomValue();
        this.Energy = generateRandomValue();
    }
    
    Camel(String name, int thirst, int hunger, int energy){
        this.name = name;
        thirst = Thirst;
        hunger = Hunger;
        energy = Energy;
    }
    public String getName(){
        return name;
    }
    public int getThirst(){
        return Thirst;
    }
    public void adjustThirst(int value) {
        Thirst = validateValue(Thirst + value);
    }
    public int getEnergy(){
        return Energy;
    }
    public void adjustEnergy(int value) {
        Energy = validateValue(Energy + value);
    }
    public int getHunger(){
        return Hunger;
    }
    public void adjustHunger(int value) {
        Hunger = validateValue(Hunger + value);
    }
    public String getStatus() {
        return "Camel Status:\n" +
                "Thirst: " + Thirst + "\n" +
                "Hunger: " + Hunger + "\n" +
                "Energy: " + Energy;
    }
    // Helper method to ensure values are within the correct range
    private int validateValue(int value) {
        if (value < 0) {
            return 0;
        } else if (value > 100) {
            return 100;
        } else {
            return value;
        }
    }

    // Helper method to generate random values
    private int generateRandomValue() {
        return new Random().nextInt(101); // Random value between 0 and 100
    }
}
