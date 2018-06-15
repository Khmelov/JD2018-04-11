package by.it.sharin.jd03_01;

public class C_Init {

    static final String dbUrl = "jdbc:mysql://127.0.0.1:2016/";

    static final String dbUser = "root";

    static final String dbPassword = "";

    static  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    public static void main(String[] args) {

    }
}
