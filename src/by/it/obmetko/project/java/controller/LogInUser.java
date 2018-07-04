package by.it.obmetko.project.java.controller;


import by.it.obmetko.project.java.DAO.beens.User;

public class LogInUser {
    public static User currentUser;

    private static LogInUser instance;
    private LogInUser(User user){currentUser=user;}

    public static LogInUser getInstance(User user) {
        if(instance==null) instance=new LogInUser(user);
        return instance;
    }
    public static void resetInstance() {
         instance=null;
        currentUser=null;
    }

}