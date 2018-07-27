package by.test.SCAND.java.bean;

public class Clients {
    public Clients() {
    }
    private int idclients;
    private String roles;

    public Clients(int idclients, String roles) {
        this.idclients = idclients;
        this.roles = roles;
    }

    public int getIdclients() {
        return idclients;
    }

    public void setIdclients(int idclients) {
        this.idclients = idclients;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "idclients=" + idclients +
                ", roles='" + roles + '\'' +
                '}';
    }
}
