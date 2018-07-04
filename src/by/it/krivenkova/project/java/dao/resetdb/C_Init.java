package by.it.krivenkova.project.java.dao.resetdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {
    public static void main(String[] args) {
        initDB();
    }
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }


    public static void initDB() {
            try (
                    Connection connection =
                            DriverManager.getConnection(CN.DB_URL + "?useUnicode=true&characterEncoding=UTF-8", CN.DB_USER, CN.DB_PASSWORD);
                    Statement statement = connection.createStatement()
            ) {
                statement.executeUpdate("DROP SCHEMA IF EXISTS `krivenkova` ;");
                statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `krivenkova` DEFAULT CHARACTER SET utf8 ;");
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS `krivenkova`.`roles` (\n" +
                        "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                        "  `role` VARCHAR(100) NULL,\n" +
                        "  PRIMARY KEY (`id`))\n" +
                        "ENGINE = InnoDB;");
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS `krivenkova`.`users` (\n" +
                        "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                        "  `login` VARCHAR(45) NULL,\n" +
                        "  `password` VARCHAR(45) NULL,\n" +
                        "  `surname` VARCHAR(45) NULL,\n" +
                        "  `name` VARCHAR(45) NULL,\n" +
                        "  `patronymic` VARCHAR(45) NULL,\n" +
                        "  `email` VARCHAR(100) NULL,\n" +
                        "  `roles_id` INT NOT NULL,\n" +
                        "  PRIMARY KEY (`id`),\n" +
                        "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                        "  CONSTRAINT `fk_users_roles`\n" +
                        "    FOREIGN KEY (`roles_id`)\n" +
                        "    REFERENCES `krivenkova`.`roles` (`id`)\n" +
                        "    ON DELETE RESTRICT\n" +
                        "    ON UPDATE RESTRICT)\n" +
                        "ENGINE = InnoDB;");
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS `krivenkova`.`routes` (\n" +
                        "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                        "  `depTown` VARCHAR(50) NULL,\n" +
                        "  `depDate` VARCHAR(10) NULL,\n" +
                        "  `depTime` VARCHAR(10) NULL,\n" +
                        "  `arrTown` VARCHAR(50) NULL,\n" +
                        "  `price` DOUBLE NULL,\n" +
                        "  `numTickets` INT NULL,\n" +
                        "  `users_id` INT NOT NULL,\n" +
                        "  PRIMARY KEY (`id`),\n" +
                        "  INDEX `fk_ads_users1_idx` (`users_id` ASC),\n" +
                        "  CONSTRAINT `fk_ads_users1`\n" +
                        "    FOREIGN KEY (`users_id`)\n" +
                        "    REFERENCES `krivenkova`.`users` (`id`)\n" +
                        "    ON DELETE CASCADE\n" +
                        "    ON UPDATE CASCADE)\n" +
                        "ENGINE = InnoDB;");
                statement.executeUpdate("INSERT INTO `krivenkova`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');\n");
                statement.executeUpdate("INSERT INTO `krivenkova`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
                statement.executeUpdate("INSERT INTO `krivenkova`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");
                statement.executeUpdate("INSERT INTO `krivenkova`.`users` (`id`, `login`, `password`,`surname`,`name`,`patronymic`, `email`, `roles_id`) VALUES (DEFAULT, 'Kira', 'moon','Афонко','Кирилл','Васильевич', 'kirAf@mail.ru', 1);");
                statement.executeUpdate("INSERT INTO `krivenkova`.`users` (`id`, `login`, `password`,`surname`,`name`,`patronymic`, `email`, `roles_id`) VALUES (DEFAULT, 'lemon', 'tark','Самохин','Максим','Николаевич', 'Samoh@mail.ru', 1);");
                statement.executeUpdate("INSERT INTO `krivenkova`.`routes` (`id`, `depTown`, `depDate`, `depTime`, `arrTown`, `price`, `numTickets`, `users_id`) VALUES (DEFAULT, 'Белосток', '08.04.2017', '12:15', 'Львов', 50.3, 1, 2);");
                System.out.println("Database successfully created");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
}
