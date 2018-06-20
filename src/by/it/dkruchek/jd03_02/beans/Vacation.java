package by.it.dkruchek.jd03_02.beans;

public class Vacation {

    long id;
    String dates;
    boolean approved;
    long employees_id;

    public Vacation(long id, String dates, boolean approved, long employees_id) {
        this.id = id;
        this.dates = dates;
        this.approved = approved;
        this.employees_id = employees_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public long getEmployees_id() {
        return employees_id;
    }

    public void setEmployees_id(long employees_id) {
        this.employees_id = employees_id;
    }
}
