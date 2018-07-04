package by.it.shekh.project.java.beans;

public class FacadePictures {
    Long id_pictures;
    String picture_path;
    Long id_facade;

    public FacadePictures() {

    }

    public FacadePictures(Long id_pictures, String picture_path, Long id_facade) {
        this.id_pictures = id_pictures;
        this.picture_path = picture_path;
        this.id_facade = id_facade;
    }

    public Long getId_pictures() {
        return id_pictures;
    }

    public void setId_pictures(Long id_pictures) {
        this.id_pictures = id_pictures;
    }

    public String getPicture_path() {
        return picture_path;
    }

    public void setPicture_path(String picture_path) {
        this.picture_path = picture_path;
    }

    public Long getId_facade() {
        return id_facade;
    }

    public void setId_facade(Long id_facade) {
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
