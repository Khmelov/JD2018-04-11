package by.it.kashayed.jd03_03.bean;

public class Cars {
    public Cars() {
    }

    private int id;
    private String model;
    private String year;
    private String prive;
    private int owner_id;

    public Cars(int id, String model, String year, String prive, int owner_id) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.prive = prive;
        this.owner_id = owner_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPrive() {
        return prive;
    }

    public void setPrive(String prive) {
        this.prive = prive;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", prive='" + prive + '\'' +
                ", owner_id=" + owner_id +
                '}';
    }
}
