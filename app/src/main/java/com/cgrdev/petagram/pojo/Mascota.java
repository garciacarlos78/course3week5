package com.cgrdev.petagram.pojo;

public class Mascota {

    private int id;
    private int pictureId;
    private String name;
    private int rating;

    public Mascota() {}

    public Mascota (int id, int pictureId, String name) {
        this.id         = id;
        this.pictureId  = pictureId;
        this.name       = name;
        this.rating     = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


}
