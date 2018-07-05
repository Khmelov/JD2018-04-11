package by.it.kashayed.Project.java.bean;

public class Owner {
    public Owner() {
    }
    private int id;
    private String login;
    private String email;
    private String pass;
    private String name;
    private int owners_id;

    public Owner(int id, String login, String email, String pass, String name, int owners_id) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.pass = pass;
        this.name = name;
        this.owners_id = owners_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOwners_id() {
        return owners_id;
    }

    public void setOwners_id(int owners_id) {
        this.owners_id = owners_id;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", name='" + name + '\'' +
                ", owners_id=" + owners_id +
                '}';
    }
}
