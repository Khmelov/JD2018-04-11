package by.it.rogov.jd03_02;



import by.it.rogov.jd03_02.connection.DBConnection;
import by.it.rogov.jd03_02.crud.CrudRole;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class TaskB {
    public static void main(String[] args) throws SQLException {
        int countUsers=0;
        try(Connection connection= DBConnection.getConnection();
            Statement statement=connection.createStatement()
        ){
            String sql =String.format(Locale.US,"SELECT * FROM `users` INNER JOIN `roles` ON `users`.`roles_ID`=`roles`.`ID` ");
            ResultSet resultSet1 = statement.executeQuery(sql);

            while (resultSet1.next()){
                System.out.println(resultSet1.getString("login")+" is "+ resultSet1.getString("role"));
                countUsers++;
            }
            }
        System.out.println("Count users is: "+countUsers);
        System.out.println("Count roles: "+new CrudRole().readCountRole());
        }

    }

