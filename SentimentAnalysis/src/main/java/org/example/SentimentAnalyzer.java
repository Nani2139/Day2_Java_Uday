package org.example;
import java.util.Arrays;

public class SentimentAnalyzer {

    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords, String[] negOpinionWords) {
        int[] featureOpinions = new int[featureSet.length];

        review = review.toLowerCase();

        for (int i = 0; i < featureSet.length; i++) {
            for (String feature : featureSet[i]) {
                int opinion = getOpinionOnFeature(review, feature, posOpinionWords, negOpinionWords);
                if (opinion != 0) {
                    featureOpinions[i] = opinion;
                    break;
                }
            }
        }
        return featureOpinions;
    }

    private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);
        if (opinion == 0) {
            opinion = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
        }
        return opinion;
    }

    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        String pattern = feature + " was ";
        int index = review.indexOf(pattern);
        if (index != -1) {
            int start = index + pattern.length();
            for (String posWord : posOpinionWords) {
                if (review.startsWith(posWord, start)) return 1;
            }
            for (String negWord : negOpinionWords) {
                if (review.startsWith(negWord, start)) return -1;
            }
        }
        return 0;
    }

    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        String[] sentences = review.split("\\.");
        for (String sentence : sentences) {
            for (String posWord : posOpinionWords) {
                if (sentence.contains(posWord + " " + feature)) return 1;
            }
            for (String negWord : negOpinionWords) {
                if (sentence.contains(negWord + " " + feature)) return -1;
            }
        }
        return 0;
    }
}
