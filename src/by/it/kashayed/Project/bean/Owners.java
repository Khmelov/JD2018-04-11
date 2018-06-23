package by.it.kashayed.Project.bean;

public class Owners {
    public Owners() {
    }

    private int id;
    private String owner;

    public Owners(int id, String owner) {
        this.id = id;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Owners{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                '}';
    }
}
