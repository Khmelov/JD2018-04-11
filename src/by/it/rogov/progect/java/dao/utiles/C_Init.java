package by.it.rogov.progect.java.dao.utiles;






import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }


    public static void creatTables() throws SQLException {

        try(Connection connection=
                    DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            Statement statement=connection.createStatement()
        ){
            statement.executeUpdate("DROP SCHEMA IF EXISTS `rogov`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `rogov` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `rogov`.`roles` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(50) NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB;;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `rogov`.`users` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(45) NULL,\n" +
                    "  `password` VARCHAR(45) NULL,\n" +
                    "  `email` VARCHAR(45) NULL,\n" +
                    "  `roles_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_users_roles1_idx` (`roles_ID` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles1`\n" +
                    "    FOREIGN KEY (`roles_ID`)\n" +
                    "    REFERENCES `rogov`.`roles` (`ID`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `rogov`.`labrary` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `textFree` VARCHAR(10000) NULL,\n" +
                    "  `textPay` VARCHAR(10000) NULL,\n" +
                    "  `users_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_labrary_users1_idx` (`users_ID` ASC),\n" +
                    "  CONSTRAINT `fk_labrary_users1`\n" +
                    "    FOREIGN KEY (`users_ID`)\n" +
                    "    REFERENCES `rogov`.`users` (`ID`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `rogov`.`permission` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `pemissionAccess` INT NULL,\n" +
                    "  `users_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_permission_users1_idx` (`users_ID` ASC),\n" +
                    "  CONSTRAINT `fk_permission_users1`\n" +
                    "    FOREIGN KEY (`users_ID`)\n" +
                    "    REFERENCES `rogov`.`users` (`ID`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
    statement.executeUpdate("INSERT INTO `rogov`.`roles` (`ID`, `role`) VALUES (DEFAULT, 'Administator')");
    statement.executeUpdate("INSERT INTO `rogov`.`roles` (`ID`, `role`) VALUES (DEFAULT, 'User')");
    statement.executeUpdate("INSERT INTO `rogov`.`roles` (`ID`, `role`) VALUES (DEFAULT, 'Guest')");
    statement.executeUpdate("INSERT INTO `rogov`.`users` (`ID`, `login`, `password`, `email`, `roles_ID`) " +
            "VALUES (DEFAULT, 'admin', 'pasadmin', 'admin@mail@ru', 1)");
    statement.executeUpdate("INSERT INTO `rogov`.`labrary` (`ID`, `textFree`, `textPay`, `users_ID`) VALUES\n" +
            "(1, 'СПОРТИВНОЕ ПИТАНИЕ: АМИНОКИСЛОТЫ', 'Аминокислоты – это те кирпичики, которые строят весь наш " +
            "огранизм: от мышц до мозга. Они помогают восстановить мышечную ткань после тренировок, тем самым " +
            "снизив болевые ощущения и подготовив мышцы к дальнейшим нагрузкам.', 1)");
    statement.executeUpdate("INSERT INTO `rogov`.`labrary` (`ID`, `textFree`, `textPay`, `users_ID`) VALUES\n" +
            "(2, 'СПОРТИВНОЕ ПИТАНИЕ: ЖИРОСЖИГАТЕЛИ', 'Жиросжигатели и в частности, L-карнитин, помогают сжигать " +
            "жиры. Они работают только при наличии физических нагрузок и помогают ускорить процесс похудения.  '," +
            " 1)");
    statement.executeUpdate("INSERT INTO `rogov`.`labrary` (`ID`, `textFree`, `textPay`, `users_ID`) VALUES\n" +
            "(3, 'СПОРТИВНОЕ ПИТАНИЕ: ЭНЕРГЕТИКИ', 'При усиленных тренировках, когда организм не успевает " +
            "восстановить силы, в бой вступают энергетики. Они состоят из быстрых углеводов и моментально наполняют " +
            "организм энергией. Именно энергетики в зале пьют накачанные ребята во время тренировки.', 1)");
    statement.executeUpdate("INSERT INTO `rogov`.`labrary` (`ID`, `textFree`, `textPay`, `users_ID`) VALUES\n" +
            "(4, 'СПОРТИВНОЕ ПИТАНИЕ: ГЕЙНЕР', 'Гейнер –  углеводно-белковая смесь для наращивания массы и " +
            "восстановление энергетического баланса. Его употребляют в период активных тренировок, для того," +
            "чтобы мышцы росли быстрее. А также гейнер – отличный вариант для людей, у которых не смотря на " +
            "регулярные тренировки, не сложился нормальный режим питания.', 1)");
    statement.executeUpdate("INSERT INTO `rogov`.`labrary` (`ID`, `textFree`, `textPay`, `users_ID`) VALUES\n" +
            "(5, 'СПОРТИВНОЕ ПИТАНИЕ: ПРОТЕИН', 'Протеиновые продукты – это продукты с высоким содержанием белка " +
            "и почти нулевым содержанием углеводов. Белок – основной строитель и защитник мышечной ткани. Так, если " +
            "Вы наращиваете мышцы, без белка они просто не будут расти. При похудении организм также может терять " +
            "мышечную ткань вместо жира, и именно белок сможет гарантировать Вам, что жир уйдет, а мышцы останутся.'," +
            " 1)");
            System.out.println("Create All Table");
        }

    }
}
