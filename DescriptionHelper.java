/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * @author yasin.hussein
 */
public class DescriptionHelper {
   private DescriptionHelper() {
        throw new AssertionError("DescriptionHelper should not be instantiated.");
    }
    public static String getThirstDescription(Camel camel){
        int Thirst = camel.getThirst();
        if(Thirst >= 2 && Thirst <= 5){
            return "Thirsty";
        }
        else{
            return "Not Thirsty";
        }
    }
    public static String getHungerDescription(Camel camel){
       int Hunger = camel.getHunger();
        if(Hunger >= 2 && Hunger <= 5){
            return "Hungry";
        }
        else{
            return "Not Hungry";
        }
       
    }
    public static String getEnergyDescription(Camel camel){
        int Energy = camel.getEnergy();
        if(Energy >= 2 && Energy <= 5){
            return "Tired";
        }
        else{
            return "Not Tired";
        }
    }
    public static String getThirstDescription(Rider rider){
        int Thirst = rider.getThirst();
        if(Thirst >= 2 && Thirst <= 5){
            return "Thirsty";
        }
        else{
            return "Not Thirsty";
        }
    }
    public static String getHungerDescription(Rider rider){
        int Thirst = rider.getThirst();
        if(Thirst >= 2 && Thirst <= 5){
            return "Thirsty";
        }
        else{
            return "Not Thirsty";
        }
    }
    public static String getEnergyDescription(Rider rider){
        int Energy = rider.getEnergy();
        if(Energy >= 2 && Energy <= 5){
            return "Tired";
        }
        else{
            return "Not Tired";
        }
    }
   public static String getStatus(Rider rider) {
        String name = rider.getName();
        String thirstDescription = getThirstDescription(rider);
        String hungerDescription = getHungerDescription(rider);
        String energyDescription = getEnergyDescription(rider);
        
        return name + " is " + thirstDescription + ", " + hungerDescription + ", and " + energyDescription + ".";
    }

    public static String getStatus(Camel camel) {
        String name = camel.getName();
        String thirstDescription = getThirstDescription(camel);
        String hungerDescription = getHungerDescription(camel);
        String energyDescription = getEnergyDescription(camel);
        
        return name + " is " + thirstDescription + ", " + hungerDescription + ", and " + energyDescription + ".";
    }
}
