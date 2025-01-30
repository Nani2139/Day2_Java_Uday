package org.example;
import org.example.DatasetCreator;

import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Sentiment Analysis...");

        String[] reviews = {
                "Haven't been here in years! Fantastic service and the food was delicious!",
                "The ambiance was great, but the service was slow and the dessert was awful.",
                "Amazing food and friendly staff! The soup was excellent too."
        };

        String[][] featureSet = {
                { "ambiance", "ambience", "atmosphere", "decor" },
                { "dessert", "ice cream", "desert" },
                { "food" },
                { "soup" },
                { "service", "management", "waiter", "waitress", "bartender", "staff", "server" }
        };

        String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome", "delicious" };
        String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };

        for (String review : reviews) {
            System.out.println("Review: " + review);

            String[] dataset = DatasetCreator.generateDataset(review, featureSet, posOpinionWords, negOpinionWords);

            System.out.println("Sentiment Analysis: " + Arrays.toString(dataset));
            System.out.println("--------------------------------------------------");
        }

    }
}