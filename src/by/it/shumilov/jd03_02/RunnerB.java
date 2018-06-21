package by.it.shumilov.jd03_02;

import by.it.shumilov.jd03_02.connection.DbConnection;
import by.it.shumilov.jd03_02.crud.CrudUser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RunnerB {
    public static void main(String[] args) throws SQLException {
        try(
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()){

            CrudUser crudUser = new CrudUser();
            String sql = String.format(Locale.US, "SELECT * FROM `dbusers`");
            ResultSet resultSet = statement.executeQuery(sql);
            List<Long> listId = new ArrayList<>();
            while(resultSet.next()){
                listId.add(resultSet.getLong("id"));
            }
            for (Long aLong : listId) {
                System.out.println(crudUser.read(aLong));
            }



        }

        try(
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()){
            String sql = String.format(Locale.US, "SELECT COUNT(*) as AllCount, COUNT(DISTINCT dbRoles_id) as CountRoles FROM `dbusers`");
            ResultSet resultSet1 = statement.executeQuery(sql);
            if(resultSet1.next()){
                System.out.printf("AllCount=%s, CountRoles=%s", resultSet1.getString("AllCount"),resultSet1.getString("CountRoles"));
            }}

    }
}
