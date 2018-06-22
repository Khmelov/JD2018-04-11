package by.it.kashayed.jd03_03.bean;

public class Owners {
    public Owners() {
    }

    private int id;
    private String owners;

    public Owners(int id, String owners) {
        this.id = id;
        this.owners = owners;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwners() {
        return owners;
    }

    public void setOwners(String owners) {
        this.owners = owners;
    }

    @Override
    public String toString() {
        return "Owners{" +
                "id=" + id +
                ", owners='" + owners + '\'' +
                '}';
    }
}
