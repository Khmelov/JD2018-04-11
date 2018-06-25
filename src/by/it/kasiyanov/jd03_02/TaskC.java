package by.it.kasiyanov.jd03_02;


import by.it.kasiyanov.jd03_02.beans.Roles;
import by.it.kasiyanov.jd03_02.beans.TravelOffers;
import by.it.kasiyanov.jd03_02.beans.User;

public class TaskC {
    public static void main(String[] args) {
        Roles roles = new Roles(
                0,
                "Administrator");
        User testUser = new User(
                0,
                "Admin",
                "pAdmin",
                "padmit@it.by",
                1);
        TravelOffers travelOffers = new TravelOffers(
                0,
                "Magnificent sandy beaches",
                "Holiday",
                "Malta",
                "Hilton",
                "5 Stars",
                7,
                445,
                2);
    }
}
