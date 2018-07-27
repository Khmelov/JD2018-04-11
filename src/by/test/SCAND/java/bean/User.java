package by.test.SCAND.java.bean;

public class User {
    public User() {
    }
    private int iduser;
    private String name;
    private String address;
    private String phone;
    private int clients_idclients;

    public User(int iduser, String name, String address, String phone, int clients_idclients) {
        this.iduser = iduser;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.clients_idclients = clients_idclients;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getClients_idclients() {
        return clients_idclients;
    }

    public void setClients_idclients(int clients_idclients) {
        this.clients_idclients = clients_idclients;
    }

    @Override
    public String toString() {
        return "User{" +
                "iduser=" + iduser +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", clients_idclients=" + clients_idclients +
                '}';
    }
}
