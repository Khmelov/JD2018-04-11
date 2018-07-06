package by.it.shumilov.project.java.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
    private long id;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    /*
    for date

    Date c= sdf.parse("2015-05-26");
    String date=sdf.format(c);
    System.out.println(date);

    Date date = new Date();
    String str = new SimpleDateFormat("yyyy-MM-dd").format(date);
     */
    private Date startorder;
    private int tenancy;
    private Date endorder;
    private double cost;
    private int discount;
    private double realcost;
    private long avtos_id;
    private long passports_id;

    public Order(long id, Date startorder, int tenancy, Date endorder, double cost, int discount, double realcost, long avtos_id, long passports_id) {
        this.id = id;
        this.startorder = startorder;
        this.tenancy = tenancy;
        this.endorder = endorder;
        this.cost = cost;
        this.discount = discount;
        this.realcost = realcost;
        this.avtos_id = avtos_id;
        this.passports_id = passports_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartorder() {
        return startorder;
    }

    public void setStartorder(Date startorder) {
        this.startorder = startorder;
    }

    public int getTenancy() {
        return tenancy;
    }

    public void setTenancy(int tenancy) {
        this.tenancy = tenancy;
    }

    public Date getEndorder() {
        return endorder;
    }

    public void setEndorder(Date endorder) {
        this.endorder = endorder;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getRealcost() {
        return realcost;
    }

    public void setRealcost(double realcost) {
        this.realcost = realcost;
    }

    public long getAvtos_id() {
        return avtos_id;
    }

    public void setAvtos_id(long avtos_id) {
        this.avtos_id = avtos_id;
    }

    public long getPassports_id() {
        return passports_id;
    }

    public void setPassports_id(long users_id) {
        this.passports_id = users_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", startorder=" + sdf.format(startorder) +
                ", tenancy=" + tenancy +
                ", endorder=" + endorder +
                ", cost=" + cost +
                ", discount=" + discount +
                ", realcost=" + realcost +
                ", avtos_id=" + avtos_id +
                ", passports_id=" + passports_id +
                '}';
    }
}
