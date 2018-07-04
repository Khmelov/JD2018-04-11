package by.it.shumilov.project.java.beans;

public class Avto {
    private long id;
    private String mark;
    private String model;
    private String color;
    private String nvin;
    private int year;
    private String ngos;
    private double rate;
    private String foto;

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Avto(){}

    public Avto(long id, String mark, String model, String color, String nvin, int year, String ngos, double rate, String foto) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.color = color;
        this.nvin = nvin;
        this.year = year;
        this.ngos = ngos;
        this.rate = rate;
        this.foto = foto;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNvin() {
        return nvin;
    }

    public void setNvin(String nvin) {
        this.nvin = nvin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getNgos() {
        return ngos;
    }

    public void setNgos(String ngos) {
        this.ngos = ngos;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Avto{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", nvin='" + nvin + '\'' +
                ", year=" + year +
                ", ngos='" + ngos + '\'' +
                ", rate=" + rate +
                ", foto='" + foto + '\'' +
                '}';
    }
}
