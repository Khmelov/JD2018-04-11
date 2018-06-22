package by.it.rogov.jd03_02;


import by.it.rogov.jd03_02.connection.DBConnection;
import by.it.rogov.jd03_02.crud.CrudRole;
import by.it.rogov.jd03_02.crud.CrudUser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class TaskB {
    public static void main(String[] args) throws SQLException {
        int countUsers=0;
        CrudRole crudRole = new CrudRole();

        try(Connection connection= DBConnection.getConnection();
            Statement statement=connection.createStatement()
        ){
            String sql =String.format(Locale.US,"SELECT * FROM `users` ");
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println(resultSet.getString("login")+" is "+crudRole.readRole(resultSet.getInt("roles_ID")) );
                countUsers++;
            }

            }
        System.out.println(countUsers);
        System.out.println(crudRole.readCountRole());
        }

    }

