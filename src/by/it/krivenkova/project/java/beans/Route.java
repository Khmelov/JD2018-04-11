package by.it.krivenkova.project.java.beans;

public class Route {

    private long id;
    private String depTown;
    private String depDate;
    private String depTime;
    private String arrTown;
    private double price;
    private int numTickets;
    private long users_id;

    public Route() {
    }

    public Route(long id, String depTown, String depDate, String depTime, String arrTown, double price, int numTickets, long users_id) {
        this.id = id;
        this.depTown = depTown;
        this.depDate = depDate;
        this.depTime = depTime;
        this.arrTown = arrTown;
        this.price = price;
        this.numTickets = numTickets;
        this.users_id = users_id;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepTown() {
        return depTown;
    }

    public void setDepTown(String depTown) {
        this.depTown = depTown;
    }

    public String getDepDate() {
        return depDate;
    }

    public void setDepDate(String depDate) {
        this.depDate = depDate;
    }

    public String getDepTime() {
        return depTime;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public String getArrTown() {
        return arrTown;
    }

    public void setArrTown(String arrTown) {
        this.arrTown = arrTown;
    }

    public int getNumTickets() {
        return numTickets;
    }

    public void setNumTickets(int numTickets) {
        this.numTickets = numTickets;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", depTown='" + depTown + '\'' +
                ", depDate=" + depDate +
                ", depTime=" + depTime +
                ", arrTown=" + arrTown +
                ", price=" + price +
                ", numTickets='" + numTickets + '\'' +
                ", users_id=" + users_id +
                '}';
    }
}
