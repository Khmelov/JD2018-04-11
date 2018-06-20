package by.it.kurmaz.jd03_03.beans;

public class Order {
    private long id;
    private boolean completed;
    private int users_ID;

    public Order(long id, boolean completed, int users_ID) {
        this.id = id;
        this.completed = completed;
        this.users_ID = users_ID;
    }

    public Order() {}

    public long getId() {
        return id;
    }

    public boolean isCompleted() {
        return completed;
    }

    public int getUsers_ID() {
        return users_ID;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setUsers_ID(int users_ID) {
        this.users_ID = users_ID;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", completed=" + completed +
                ", users_ID=" + users_ID +
                '}';
    }
}
