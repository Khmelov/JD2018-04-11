package by.it.shumilov.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_init {



    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    public static void main(String[] args) {


        try ( Connection connection = DriverManager.getConnection(CN.DB_URL, CN.DB_USER, CN.DB_PASSWORD);
              Statement statement = connection.createStatement()){

            statement.executeUpdate("DROP SCHEMA IF EXISTS `Shumilov` ;");




            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `Shumilov` DEFAULT CHARACTER SET utf8 ;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Shumilov`.`dbRoles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Shumilov`.`dbUsers` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(45) NULL,\n" +
                    "  `password` VARCHAR(45) NULL,\n" +
                    "  `email` VARCHAR(45) NULL,\n" +
                    "  `dbRoles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_dbUsers_dbRoles1_idx` (`dbRoles_id` ASC),\n" +
                    "  CONSTRAINT `fk_dbUsers_dbRoles1`\n" +
                    "    FOREIGN KEY (`dbRoles_id`)\n" +
                    "    REFERENCES `Shumilov`.`dbRoles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Shumilov`.`dbAvto` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `mark` VARCHAR(45) NULL,\n" +
                    "  `model` VARCHAR(45) NULL,\n" +
                    "  `color` VARCHAR(45) NULL,\n" +
                    "  `nvin` VARCHAR(17) NULL,\n" +
                    "  `year` INT NULL,\n" +
                    "  `ngos` VARCHAR(9) NULL,\n" +
                    "  `rate` DOUBLE NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Shumilov`.`dbOrder` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `startorder` DATE NULL,\n" +
                    "  `tenancy` INT NULL,\n" +
                    "  `endorder` DATE NULL,\n" +
                    "  `cost` DOUBLE NULL,\n" +
                    "  `discount` INT NULL,\n" +
                    "  `realcost` DOUBLE NULL,\n" +
                    "  `dbAvto_id` INT NOT NULL,\n" +
                    "  `dbUsers_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_dbOrder_dbAvto_idx` (`dbAvto_id` ASC),\n" +
                    "  INDEX `fk_dbOrder_dbUsers1_idx` (`dbUsers_id` ASC),\n" +
                    "  CONSTRAINT `fk_dbOrder_dbAvto`\n" +
                    "    FOREIGN KEY (`dbAvto_id`)\n" +
                    "    REFERENCES `Shumilov`.`dbAvto` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT,\n" +
                    "  CONSTRAINT `fk_dbOrder_dbUsers1`\n" +
                    "    FOREIGN KEY (`dbUsers_id`)\n" +
                    "    REFERENCES `Shumilov`.`dbUsers` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Shumilov`.`dbPassport` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `firstname` VARCHAR(100) NULL,\n" +
                    "  `lastname` VARCHAR(100) NULL,\n" +
                    "  `pasportid` VARCHAR(45) NULL,\n" +
                    "  `phone` VARCHAR(12) NULL,\n" +
                    "  `dbUsers_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_dbPasport_dbUsers1_idx` (`dbUsers_id` ASC),\n" +
                    "  CONSTRAINT `fk_dbPasport_dbUsers1`\n" +
                    "    FOREIGN KEY (`dbUsers_id`)\n" +
                    "    REFERENCES `Shumilov`.`dbUsers` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;\n");




            statement.executeUpdate("INSERT INTO `Shumilov`.`dbRoles` (`id`, `role`) VALUES (1, 'Admin');");
            statement.executeUpdate("INSERT INTO `Shumilov`.`dbRoles` (`id`, `role`) VALUES (2, 'User');");
            statement.executeUpdate("INSERT INTO `Shumilov`.`dbRoles` (`id`, `role`) VALUES (3, 'Guest');");

            statement.executeUpdate("INSERT INTO `Shumilov`.`dbUsers` (`id`, `login`, `password`, `email`, `dbRoles_id`) VALUES (1, 'admin', 'admin1', 'admin@it.by', 1);");
            statement.executeUpdate("INSERT INTO `Shumilov`.`dbUsers` (`id`, `login`, `password`, `email`, `dbRoles_id`) VALUES (2, 'sas', 'qwerty', 'sas@tut.by', 2);");
            statement.executeUpdate("INSERT INTO `Shumilov`.`dbUsers` (`id`, `login`, `password`, `email`, `dbRoles_id`) VALUES (3, 'dsa', 'asd12', 'dima2017', 2);");

            statement.executeUpdate("INSERT INTO `Shumilov`.`dbAvto` (`id`, `mark`, `model`, `color`, `nvin`, `year`, `ngos`, `rate`) VALUES (1, 'VW', 'Pasat B6', 'Black', '1A2S3D4F5G6H7J8K9', 2012, '1234 SW-5', 40.4);");
            statement.executeUpdate("INSERT INTO `Shumilov`.`dbAvto` (`id`, `mark`, `model`, `color`, `nvin`, `year`, `ngos`, `rate`) VALUES (2, 'Porshe', '911', 'Red', '1A2S3D4F5G6H7J8KY', 2017, '5432 AD-4', 199.9);");
            statement.executeUpdate("INSERT INTO `Shumilov`.`dbAvto` (`id`, `mark`, `model`, `color`, `nvin`, `year`, `ngos`, `rate`) VALUES (3, 'Infiniti', 'p40', 'White', '1A2S3D4F5G6H7J8FD', 2015, '8888 BO-7', 149.9);");

            statement.executeUpdate("INSERT INTO `Shumilov`.`dbOrder` (`id`, `startorder`, `tenancy`, `endorder`, `cost`, `discount`, `realcost`, `dbAvto_id`, `dbUsers_id`) VALUES (1, '2018-03-11', 11, '2018-03-21', 444.4, 1, 439.96, 1, 2);");
            statement.executeUpdate("INSERT INTO `Shumilov`.`dbOrder` (`id`, `startorder`, `tenancy`, `endorder`, `cost`, `discount`, `realcost`, `dbAvto_id`, `dbUsers_id`) VALUES (2, '2018-05-26', 2, '2018-05-27', 399.8, 0, 399.8, 2, 3);");
            statement.executeUpdate("INSERT INTO `Shumilov`.`dbOrder` (`id`, `startorder`, `tenancy`, `endorder`, `cost`, `discount`, `realcost`, `dbAvto_id`, `dbUsers_id`) VALUES (3, '2018-06-11', 30, NULL, 4497.0, 10, 4047.3, 3, 3);");

            statement.executeUpdate("INSERT INTO `Shumilov`.`dbPassport` (`id`, `firstname`, `lastname`, `pasportid`, `phone`, `dbUsers_id`) VALUES (1, 'Aleks', 'State', '866534435908896RB7', '375771234567', 2);");
            statement.executeUpdate("INSERT INTO `Shumilov`.`dbPassport` (`id`, `firstname`, `lastname`, `pasportid`, `phone`, `dbUsers_id`) VALUES (2, 'Dmitrii', 'Amenko', '854352754324123RB3', '375227654323', 3);");




        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
