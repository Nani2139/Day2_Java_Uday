package org.example;
import org.example.APIResponseParser;
public class Main {
    public static void main(String[] args) {
        String response = "<work>" +
                "<ratings_count type=\"integer\">1,16,315</ratings_count>" +
                "<original_publication_year type=\"integer\">1854</original_publication_year>" +
                "<average_rating>3.79</average_rating>" +
                "<best_book type=\"Book\">" +
                "<title>Walden</title>" +
                "<author><name>Henry David Thoreau</name></author>" +
                "<image_url>http://images.gr-assets.com/books/1465675526m/16902.jpg</image_url>" +
                "</best_book>" +
                "</work>";

        Book book = APIResponseParser.parse(response);

        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Publication Year: " + book.getPublicationYear());
        System.out.println("Average Rating: " + book.getAverageRating());
        System.out.println("Ratings Count: " + book.getRatingsCount());
        System.out.println("Image URL: " + book.getImageUrl());
    }
}