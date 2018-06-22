package by.it.shumilov.jd03_02.beans;

public class Avto {
    long id;
    String mark;
    String model;
    String color;
    String nvin;
    int year;
    String ngos;
    double rate;

    public Avto(){}

    public Avto(long id, String mark, String model, String color, String nvin, int year, String ngos, double rate) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.color = color;
        this.nvin = nvin;
        this.year = year;
        this.ngos = ngos;
        this.rate = rate;
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
        return "Avto{id="+ id+
                ", mark=" +mark+
                ", model="+model+
                ", color="+color+
                ", nvin="+nvin+
                ", year="+year+
                ", ngos="+ngos+
                ", rate="+rate+
                "}";
    }
}
