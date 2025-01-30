package org.example;
public class APIResponseParser {
    public static Book parse(String response) {
        Book book = new Book();

        book.setTitle(parse(response, "<title>", "<"));
        book.setAuthor(parse(response, new String[]{"<author>", "<name>"}, "<"));
        book.setPublicationYear(Integer.parseInt(parse(response, "<original_publication_year type=\"integer\">", "<")));
        book.setAverageRating(Double.parseDouble(parse(response, "<average_rating>", "<")));
        book.setRatingsCount(Integer.parseInt(parse(response, "<ratings_count type=\"integer\">", "<").replace(",", "")));
        book.setImageUrl(parse(response, "<image_url>", "<"));

        return book;
    }

    private static String parse(String response, String startRule, String endRule) {
        int start = response.indexOf(startRule) + startRule.length();
        int end = response.indexOf(endRule, start);
        return response.substring(start, end).trim();
    }

    private static String parse(String response, String[] startRules, String endRule) {
        int start = 0;
        for (String startRule : startRules) {
            start = response.indexOf(startRule, start) + startRule.length();
        }
        int end = response.indexOf(endRule, start);
        return response.substring(start, end).trim();
    }
}
