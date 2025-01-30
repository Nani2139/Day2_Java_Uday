package org.example;
import org.example.SentimentAnalyzer;

import java.util.Arrays;

public class DatasetCreator {

    public static String[] generateDataset(String review, String[][] featureSet, String[] posOpinionWords, String[] negOpinionWords) {
        int[] featureOpinions = SentimentAnalyzer.detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
        String[] dataset = new String[featureSet.length];

        for (int i = 0; i < featureSet.length; i++) {
            String feature = featureSet[i][0];
            int opinion = featureOpinions[i];

            if (opinion == 1) {
                dataset[i] = feature + " : Positive";
            } else if (opinion == -1) {
                dataset[i] = feature + " : Negative";
            } else {
                dataset[i] = feature + " : Neutral";
            }
        }
        return dataset;
    }
}

