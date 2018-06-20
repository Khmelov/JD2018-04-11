package by.it.dkruchek.jd03_02.utils;

import by.it.dkruchek.jd03_02.connection.DBConnection;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CsvLoader {
    static void loadCsvIntoMysqlDb(String path, String table) {
        File csvFile = new File(path);
        String absPath = csvFile.getAbsolutePath();
        absPath = absPath.replace("\\", "/");

        try (
                Connection connection = DBConnection.getConnection();
                Statement statement = connection.createStatement();
        ) {
            String loadQuery = String.format(Locale.US, "LOAD DATA LOCAL INFILE '%s' INTO TABLE %s FIELDS TERMINATED BY ',' LINES TERMINATED BY '\\r\\n' IGNORE 1 LINES", absPath, table);
            System.out.println(loadQuery);
            statement.execute(loadQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
