package by.it.dkruchek.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class C_Init{

    // static block to load driver
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
        }

    public static void main(String[] args) {
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.DB_URL, CN.DB_USER, CN.DB_PASSWORD);
             Statement statement = connection.createStatement()){

        statement.executeUpdate("DROP SCHEMA IF EXISTS `dkruchek` ;");
        statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `dkruchek` DEFAULT CHARACTER SET utf8;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `dkruchek`.`roles` (\n" +
                                     "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                                     "  `role` VARCHAR(100) NULL,\n" +
                                     "  PRIMARY KEY (`id`))\n" +
                                     "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `dkruchek`.`employees` (\n" +
                                     "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                                     "  `name` VARCHAR(45) NULL,\n" +
                                     "  `lastname` VARCHAR(45) NULL,\n" +
                                     "  `middlename` VARCHAR(45) NULL,\n" +
                                     "  `email` VARCHAR(45) NULL,\n" +
                                     "  `password` VARCHAR(45) NULL,\n" +
                                     "  `roles_id` INT NOT NULL,\n" +
                                     "  PRIMARY KEY (`id`),\n" +
                                     "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                                     "  CONSTRAINT `fk_users_roles`\n" +
                                     "    FOREIGN KEY (`roles_id`)\n" +
                                     "    REFERENCES `dkruchek`.`roles` (`id`)\n" +
                                     "    ON DELETE RESTRICT\n" +
                                     "    ON UPDATE RESTRICT)\n" +
                                     "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `dkruchek`.`vacations` (\n" +
                                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                                    "  `dates` VARCHAR(45) NULL,\n" +
                                    "  `approved` TINYINT(1) NULL,\n" +
                                    "  `employees_id` INT NOT NULL,\n" +
                                    "  PRIMARY KEY (`id`),\n" +
                                    "  INDEX `fk_Vacations_employees1_idx` (`employees_id` ASC),\n" +
                                    "  CONSTRAINT `fk_Vacations_employees1`\n" +
                                    "    FOREIGN KEY (`employees_id`)\n" +
                                    "    REFERENCES `dkruchek`.`employees` (`id`)\n" +
                                    "    ON DELETE CASCADE\n" +
                                    "    ON UPDATE CASCADE)\n" +
                                    "ENGINE = InnoDB;");
        // -- Data for table roles
        statement.execute("INSERT INTO `dkruchek`.`roles` (`id`, `role`) VALUES (DEFAULT, 'Department Manager');\n" +
                              "INSERT INTO `dkruchek`.`roles` (`id`, `role`) VALUES (DEFAULT, 'Unit Manager');\n" +
                              "INSERT INTO `dkruchek`.`roles` (`id`, `role`) VALUES (DEFAULT, 'Employee');");
        // -- Data for table employees
        statement.execute("INSERT INTO `dkruchek`.`employees` (`id`, `name`, `lastname`, `middlename`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'Anatoliy', 'Konev', 'Sergeevich', 'konev@qwe.com', 'konev123', 1);\n" +
                              "INSERT INTO `dkruchek`.`employees` (`id`, `name`, `lastname`, `middlename`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'Viktor', 'Ovsov', 'Semenovich', 'ovsov@qwe.com', 'ovsov123', 2);\n" +
                              "INSERT INTO `dkruchek`.`employees` (`id`, `name`, `lastname`, `middlename`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'Denis', 'Kopytov', 'Viktorovich', 'kopytov@qwe.com', 'kopytov123', 3);\n");
        // -- Data for table vacations
        statement.execute("INSERT INTO `dkruchek`.`vacations` (`id`, `dates`, `approved`, `employees_id`) VALUES (DEFAULT, '11.12.2018-15.12.2018', true, 2);\n" +
                              "INSERT INTO `dkruchek`.`vacations` (`id`, `dates`, `approved`, `employees_id`) VALUES (DEFAULT, '06.07.2018-21.07.2018', false, 3);\n");

        }

        catch (Exception e){
            e.printStackTrace();
        }
    }
}
