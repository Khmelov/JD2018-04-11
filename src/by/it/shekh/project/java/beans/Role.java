package by.it.shekh.project.java.beans;

public class Role {
    long id_roles;
    String role;

    public Role(){

    }

    public Role(long id_roles, String role) {
        this.id_roles = id_roles;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id_roles=" + id_roles +
                ", role='" + role + '\'' +
                '}';
    }

    public long getId_roles() {
        return id_roles;
    }

    public void setId_roles(long id_roles) {
        this.id_roles = id_roles;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
