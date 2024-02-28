package com.driver;

import java.util.Scanner;

public class Design {
    private String name;
    private String category;
    private String designerUsername;
    private double rating;

    public Design(String name, String category, String designerUsername) {
        this.name = name;
        this.category = category;
        this.designerUsername = designerUsername;
        this.rating = 0.0; // Default rating
    }

    public static Design createDesignFromUserInput(String name, String category, String designerUsername, double rating) {
        Design design = new Design(name, category, designerUsername);
        design.setRating(rating);
        return design;
    }

    public void setRating(double rating) {
        if (rating < 0.0) {
            throw new IllegalArgumentException("Rating cannot be negative");
        }
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    public String getKey() {
        return name + "_" + category + "_" + designerUsername;
    }

    public void displayDesignDetails() {
        System.out.println("Design Key: " + getKey());
        System.out.println("Rating: " + getRating());
        System.out.println("Performed Math Operation on Rating: " + performMathOperation());
    }

    public double performMathOperation() {
        return 2 * rating;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Design Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Design Category:");
        String category = scanner.nextLine();

        System.out.println("Enter Designer's Username:");
        String designerUsername = scanner.nextLine();

        System.out.println("Enter Design Rating:");
        double rating = scanner.nextDouble();

        Design design = Design.createDesignFromUserInput(name, category, designerUsername, rating);
        design.displayDesignDetails();

        scanner.close();
    }
}