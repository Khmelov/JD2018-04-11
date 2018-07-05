package by.it.shekh.project.java.beans;

public class Order {
    Long idOrders;
    String date;
    Long id_users;

    public Order(){
    }

    public Order(Long idOrders, String date, Long id_users) {
        this.idOrders = idOrders;
        this.date = date;
        this.id_users = id_users;
    }

    public Long getIdOrders() {
        return idOrders;
    }

    public void setIdOrders(Long idOrders) {
        this.idOrders = idOrders;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getId_users() {
        return id_users;
    }

    public void setId_users(long id_users) {
        this.id_users = id_users;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrders=" + idOrders +
                ", date='" + date + '\'' +
                ", id_users=" + id_users +
                '}';
    }
}
