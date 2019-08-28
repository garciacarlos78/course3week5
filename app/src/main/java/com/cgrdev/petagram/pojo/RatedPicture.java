package com.cgrdev.petagram.pojo;

public class RatedPicture {

    int pictureId;
    int rate;

    public RatedPicture(int pictureId) {
        this.pictureId  = pictureId;
        this.rate       = 0;
    }

    public RatedPicture (int pictureId, int rate) {
        this.pictureId  = pictureId;
        this.rate       = rate;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void like () {
        this.rate++;
    }
}
