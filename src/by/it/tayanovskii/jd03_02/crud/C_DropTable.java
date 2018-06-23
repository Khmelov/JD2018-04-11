package by.it.tayanovskii.jd03_02.crud;

import by.it.tayanovskii.jd03_02.connection.DbConnection;
import java.sql.Connection;
import java.sql.Statement;

public class C_DropTable {

    public static void main(String[] args) {

        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            //пересоздание базы целиком
            statement.executeUpdate("DROP SCHEMA IF EXISTS `tayanovskii` ;");
            //удаление всех таблиц (если работает удаление схемы то это лишнее)
            statement.executeUpdate("DROP TABLE IF EXISTS `tayanovskii`.`roles` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `tayanovskii`.`users` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `tayanovskii`.`publications` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `tayanovskii`.`permissions` ;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
