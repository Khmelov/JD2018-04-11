package by.it.kashayed.Project.bean;

public class Owners {
    public Owners() {
    }

    private int id;
    private String roles;

    public Owners(int id, String roles) {
        this.id = id;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Owners{" +
                "id=" + id +
                ", roles='" + roles + '\'' +
                '}';
    }
}
