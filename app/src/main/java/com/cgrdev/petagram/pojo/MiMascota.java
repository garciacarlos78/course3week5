package com.cgrdev.petagram.pojo;

import java.util.ArrayList;

public class MiMascota extends Mascota {

    private ArrayList<RatedPicture> ratedPictures;

    public MiMascota () {
        this.ratedPictures = new ArrayList<>();
    }

    public MiMascota(int id, int pictureId, String name) {
        super(id, pictureId, name);
        this.ratedPictures = new ArrayList<>();
    }

    public ArrayList<RatedPicture> getRatedPictures() {
        return ratedPictures;
    }

    public void setRatedPictures(ArrayList<RatedPicture> ratedPictures) {
        this.ratedPictures = ratedPictures;
    }

    public void addRatedPicture (RatedPicture ratedPicture) {
        this.ratedPictures.add(ratedPicture);
    }

}
