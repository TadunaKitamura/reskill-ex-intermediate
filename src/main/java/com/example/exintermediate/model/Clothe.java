package com.example.exintermediate.model;

public class Clothe {

    private Integer id;
    private String category;
    private String genre;
    private Integer gender;
    private String color;
    private Integer price;
    private String size;

    public Clothe() {
    }

    public Clothe(Integer id, String category, String genre, Integer gender, String color, Integer price, String size) {
        this.id = id;
        this.category = category;
        this.genre = genre;
        this.gender = gender;
        this.color = color;
        this.price = price;
        this.size = size;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

}
