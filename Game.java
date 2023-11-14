/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.Random;
/**
 *
 * @author yasin.hussein
 */
import java.util.Random;
import java.util.Scanner;

public class Game {

    private Camel camel;
    private Rider rider;
    private double difficultyModifier;
    private int distanceTraveled;
    private int pursuerDistance;
    private int distanceBetweenPursuersAndRider;
    private int currentDay;
    private String timeOfDay;
    private String weather;
    private String location;
    private Random randomGenerator;

    public Game(int difficulty, Camel camel, Rider rider) {
        this.difficultyModifier = difficulty;
        this.camel = camel;
        this.rider = rider;
        this.randomGenerator = new Random();
        // Initialize other instance variables as needed
    }

    private boolean checkCamelCanTravel() {
        if (camel.getEnergy() <= 0 || camel.getHunger() >= 100 || camel.getThirst() >= 100) {
            System.out.println("Your camel is too tired, hungry, or thirsty to continue.");
            return false;
        }
        return true;
    }

    private boolean checkRiderIsDead() {
        if (rider.getEnergy() <= 0 || rider.getHunger() >= 100 || rider.getThirst() >= 100) {
            System.out.println("You have starved, dehydrated, or died of exhaustion.");
            return true;
        }
        return false;
    }

    private void getNewLocation() {
        int randomLocation = randomGenerator.nextInt(15);
        if (randomLocation <= 1) {
            location = "Oasis";
        } else if (randomLocation <= 3) {
            location = "Ruins";
        } else if (randomLocation <= 5) {
            location = "River Bank";
        } else if (randomLocation <= 11) {
            location = "Desert Plains";
        } else {
            location = "Desert Hills";
        }
    }

    private void getNewWeather() {
        int randomWeather = randomGenerator.nextInt(10);
        if (randomWeather == 0) {
            weather = "Sandstorm";
        } else if (randomWeather == 1) {
            weather = "Raining";
        } else if (randomWeather == 2) {
            weather = "Cloudy";
        } else if (randomWeather >= 3 && randomWeather <= 5) {
            weather = "Warm";
        } else {
            weather = "Extremely Hot";
        }
    }

    private void getNewTimeOfDay() {
        if (timeOfDay.equals("Morning")) {
            timeOfDay = "Afternoon";
        } else if (timeOfDay.equals("Afternoon")) {
            timeOfDay = "Evening";
        } else if (timeOfDay.equals("Evening")) {
            timeOfDay = "Night";
        } else if (timeOfDay.equals("Night")) {
            timeOfDay = "Morning";
            currentDay++;
        }
    }

    private String getPursuerDistanceDescription() {
        if (distanceBetweenPursuersAndRider <= 10) {
            return "Pursuers are dangerously close!";
        } else if (distanceBetweenPursuersAndRider <= 20) {
            return "Pursuers are closing in.";
        } else {
            return "Pursuers are far behind.";
        }
    }

    private void outputTurnInformation() {
        System.out.println("Time of Day: " + timeOfDay);
        System.out.println("Current Day: " + currentDay);
        System.out.println("Miles Traveled: " + distanceTraveled + " miles");
        System.out.println("Current Location: " + location);
        System.out.println("Current Weather: " + weather);
        System.out.println("Camel Status: " + camel.getStatus());
        System.out.println("Rider Status: " + rider.getStatus());
    }

    private void processTurn() {
        System.out.println("It's a new turn. What will you do?");
        System.out.println("1. Rest");
        System.out.println("2. Search for Food");
        System.out.println("3. Search for Water");
        System.out.println("4. Travel Carefully");
        System.out.println("5. Travel Regularly");
        System.out.println("6. Ride All Out");

        int choice = getUserChoice(1, 6);

        if (choice == 1) {
            processRest();
        } else if (choice == 2) {
            processFoodSearch();
        } else if (choice == 3) {
            processWaterSearch();
        } else if (choice == 4) {
            processTravelCarefully();
        } else if (choice == 5) {
            processTravelRegularly();
        } else if (choice == 6) {
            processRideAllOut();
        }
    }

    private void processRest() {
        rider.adjustEnergy(20);
        camel.adjustEnergy(20);
    }

    private void processFoodSearch() {
        int foundFood = randomGenerator.nextInt(21);
        if (foundFood < 10) {
            rider.adjustHunger(-10);
        }
    }

    private void processWaterSearch() {
        int foundWater = randomGenerator.nextInt(21);
        if (foundWater < 10) {
            rider.adjustThirst(-10);
        }
    }

    private void processTravelCarefully() {
        int traveledDistance = randomGenerator.nextInt(6) + 5;
        distanceTraveled += traveledDistance;
        rider.adjustEnergy(-traveledDistance * 2);
        camel.adjustEnergy(-traveledDistance);
        camel.adjustThirst(-traveledDistance);
    }

    private void processTravelRegularly() {
        int traveledDistance = randomGenerator.nextInt(11) + 10;
        distanceTraveled += traveledDistance;
        rider.adjustEnergy(-traveledDistance * 2);
        camel.adjustEnergy(-traveledDistance);
        camel.adjustThirst(-traveledDistance);
    }

    private void processRideAllOut() {
        int traveledDistance = randomGenerator.nextInt(16) + 15;
        distanceTraveled += traveledDistance;
        rider.adjustEnergy(-traveledDistance * 2);
        camel.adjustEnergy(-traveledDistance);
        camel.adjustThirst(-traveledDistance);
    }

    private void processPursuers() {
        int pursuersDistanceChange = randomGenerator.nextInt(4) + 4;
        pursuerDistance -= pursuersDistanceChange;
        distanceBetweenPursuersAndRider += pursuersDistanceChange;
    }

    private int getUserChoice(int min, int max) {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);

        while (choice < min || choice > max) {
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice < min || choice > max) {
                    System.out.println("Invalid choice. Please enter a valid option.");
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric option.");
                scanner.next(); // Consume the invalid input
            }
        }

        return choice;
    }

    public void start() {
        System.out.println("Welcome to the Camel Racing!");
        System.out.println("Please select a difficulty:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");

        int difficulty = getUserChoice(1, 3);
        currentDay = 1;
        timeOfDay = "Morning";

        // You can implement the main game loop here
        while (true) {
            // Game logic for each turn
            if (checkCamelCanTravel() && !checkRiderIsDead()) {
                getNewLocation();
                getNewWeather();
                getNewTimeOfDay();
                processTurn();
                processPursuers();
                outputTurnInformation();
            } else {
                // End the game if the camel can't travel or the rider is dead
                System.out.println("Game Over");
                break;
            }
        }
    }
}
