package by.it.shekh.jd03_03.beans;

public class FacadePictures {
    long id_pictures;
    String picture_path;
    long id_facade;

    public FacadePictures() {

    }

    public FacadePictures(long id_pictures, String picture_path, long id_facade) {
        this.id_pictures = id_pictures;
        this.picture_path = picture_path;
        this.id_facade = id_facade;
    }

    public long getId_pictures() {
        return id_pictures;
    }

    public void setId_pictures(long id_pictures) {
        this.id_pictures = id_pictures;
    }

    public String getPicture_path() {
        return picture_path;
    }

    public void setPicture_path(String picture_path) {
        this.picture_path = picture_path;
    }

    public long getId_facade() {
        return id_facade;
    }

    public void setId_facade(long id_facade) {
        this.id_facade = id_facade;
    }

    @Override
    public String toString() {
        return "FacadePictures{" +
                "id_pictures=" + id_pictures +
                ", picture_path='" + picture_path + '\'' +
                ", id_facade=" + id_facade +
                '}';
    }
}
