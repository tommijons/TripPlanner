package sample;

import java.util.Date;

public class Hotel {
    private String name;
    private String location;
    private String url;
    private int rating;
    private int price;


    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getUrl() {
        return url;
    }

    public int getRating() {
        return rating;
    }

    public int getPrice() {
        return price;
    }

    public Hotel(String name, String location, String url, int rating, int price) {
        this.name = name;
        this.location = location;
        this.url = url;
        this.rating = rating;
        this.price = price;
    }
}
