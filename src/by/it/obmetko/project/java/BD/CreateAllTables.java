package by.it.obmetko.project.java.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateAllTables {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    public static void main(String[] args) {
        try (
                Connection connection =
                        DriverManager.getConnection(CN.DB_URL, CN.DB_USER, CN.DB_PASSWORD);
                Statement statement = connection.createStatement()
        ) {

            statement.executeUpdate("DROP SCHEMA IF EXISTS `obmetko` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `obmetko` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `obmetko`.`Roles` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `obmetko`.`Roles` (" +
                    "`id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "`role` VARCHAR(405) NULL, \n" +
                    "PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate("DROP TABLE IF EXISTS `obmetko`.`Users` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `obmetko`.`Users` (" +
                    "`id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "`login` VARCHAR(4000) NULL,\n" +
                    "`password` VARCHAR(4000) NULL,\n" +
                    "`email` VARCHAR(4000) NULL,\n" +
                    "  `Roles_id` INT NOT NULL DEFAULT 2," +
                    "  PRIMARY KEY (`id`)," +
                    "  INDEX `fk_Users_Roles1_idx` (`Roles_id` ASC)," +
                    "CONSTRAINT `fk_Users_Roles`\n" +
                    "FOREIGN KEY (`Roles_id`)\n" +
                    "REFERENCES `obmetko`.`Roles` (`id`)\n" +
                    "ON DELETE RESTRICT\n" +
                    "ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate("DROP TABLE IF EXISTS `obmetko`.`Catalog` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `obmetko`.`Catalog` (\n" +
                    "`id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "`catalogName` VARCHAR(4000) NULL,\n" +
                    "PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            statement.executeUpdate("DROP TABLE IF EXISTS `obmetko`.`Category` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `obmetko`.`Category` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `categoryName` VARCHAR(100) NULL,\n" +
                    "  `Catalog_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_Category_Catalog2_idx` (`Catalog_id` ASC),\n" +
                    "  CONSTRAINT `fk_Category_Catalog2`\n" +
                    "    FOREIGN KEY (`Catalog_id`)\n" +
                    "    REFERENCES `obmetko`.`Catalog` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `obmetko`.`Books` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `obmetko`.`Books` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `name` VARCHAR(200) NULL," +
                    "  `author` VARCHAR(200) NULL," +
                    "  `price` VARCHAR(4000) NULL," +
                    "  `Category_id` INT NOT NULL," +
                    "  PRIMARY KEY (`id`)," +
                    "  INDEX `fk_Books_Category1_idx` (`Category_id` ASC)," +
                    "  CONSTRAINT `fk_Books_Category1`" +
                    "    FOREIGN KEY (`Category_id`)" +
                    "    REFERENCES `obmetko`.`Category` (`id`)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `obmetko`.`List of purchases` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `obmetko`.`List of purchases` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Users_id` INT NOT NULL,\n" +
                    "  `Books_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_List of purchases_Users2_idx` (`Users_id` ASC),\n" +
                    "  INDEX `fk_List of purchases_Books1_idx` (`Books_id` ASC),\n" +
                    "  CONSTRAINT `fk_List of purchases_Users2`\n" +
                    "    FOREIGN KEY (`Users_id`)\n" +
                    "    REFERENCES `obmetko`.`Users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE,\n" +
                    "  CONSTRAINT `fk_List of purchases_Books1`\n" +
                    "    FOREIGN KEY (`Books_id`)\n" +
                    "    REFERENCES `obmetko`.`Books` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `obmetko`.`Catalog` (`id`, `catalogName`) VALUES (DEFAULT, 'Book Catalog');");
            statement.executeUpdate("INSERT INTO `obmetko`.`Catalog` (`id`, `catalogName`) VALUES (DEFAULT, 'Manga and comics catalog');");
            statement.executeUpdate("INSERT INTO `obmetko`.`Category` (`id`, `categoryName`, `Catalog_id`) VALUES (DEFAULT, 'fiction', 1);");
            statement.executeUpdate("INSERT INTO `obmetko`.`Category` (`id`, `categoryName`, `Catalog_id`) VALUES (DEFAULT, 'programming', 1);");
            statement.executeUpdate("INSERT INTO `obmetko`.`Category` (`id`, `categoryName`, `Catalog_id`) VALUES (DEFAULT, 'comics', 2);");
            statement.executeUpdate("INSERT INTO `obmetko`.`Category` (`id`, `categoryName`, `Catalog_id`) VALUES (DEFAULT, 'manga', 2);");
            statement.executeUpdate("INSERT INTO `obmetko`.`Books` (`id`, `name`, `author`, `price`, `Category_id`) VALUES (DEFAULT, 'The Witcher', 'Anzhej Sapkowski', '100', 1);");
            statement.executeUpdate("INSERT INTO `obmetko`.`Books` (`id`, `name`, `author`, `price`, `Category_id`) VALUES (DEFAULT, 'Java for beginners. Object-oriented approach', 'Bart Bazins', '55', 2);");
            statement.executeUpdate("INSERT INTO `obmetko`.`Books` (`id`, `name`, `author`, `price`, `Category_id`) VALUES (DEFAULT, 'Thor. God of Thunder', 'Jason Aaron', '49', 3);");
            statement.executeUpdate("INSERT INTO `obmetko`.`Books` (`id`, `name`, `author`, `price`, `Category_id`) VALUES (DEFAULT, 'Java. Effective Programming', 'Joshua Bloch', 200, 1);");
            statement.executeUpdate("INSERT INTO `obmetko`.`Books` (`id`, `name`, `author`, `price`, `Category_id`) VALUES (DEFAULT, 'Spice and Wolf. Volume 1', '\n" +
                    "Isuna Hasekura', '18', 4);");
            statement.executeUpdate("INSERT INTO `obmetko`.`Roles` (`id`, `role`) VALUES (DEFAULT, 'Admin');");
            statement.executeUpdate("INSERT INTO `obmetko`.`Roles` (`id`, `role`) VALUES (DEFAULT, 'Buyer');");
            statement.executeUpdate("INSERT INTO `obmetko`.`Users` (`id`, `login`, `password`, `email`, `Roles_id`) VALUES (DEFAULT, 'admin', 'admin', 'admin@tut.by', 1);\n");
            statement.executeUpdate("INSERT INTO `obmetko`.`Users` (`id`, `login`, `password`, `email`, `Roles_id`) VALUES (DEFAULT, 'user', 'user', 'user@tut.by', 2);\n");
            statement.executeUpdate("INSERT INTO `obmetko`.`List of purchases` (`id`, `Users_id`, `Books_id`) " +
                                        "VALUES (DEFAULT, 1, 3);\n");
            statement.executeUpdate("INSERT INTO `obmetko`.`List of purchases` (`id`, `Users_id`, `Books_id`) " +
                    "VALUES (DEFAULT, 2, 1);\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}