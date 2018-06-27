package by.it.shumilov.jd03_02.crud;

import by.it.shumilov.jd03_02.beans.Avto;
import by.it.shumilov.jd03_02.beans.User;
import by.it.shumilov.jd03_02.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CrudAvto {



    public boolean create(Avto avto) throws SQLException {

        try(
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()){

            String foto = "DEFAULT";
             if(avto.getFoto() != null)
                 foto =  String.format(Locale.US,"'%s'",avto.getFoto());


            String sql = String.format(Locale.US, "INSERT INTO `avtos`(`mark`, `model`, `color`, `nvin`, `year`, `ngos`, `rate`, `foto`) VALUES ('%s','%s','%s','%s','%d','%s','%f', %s)",
                   avto.getMark(),avto.getModel(),avto.getColor(), avto.getNvin(),avto.getYear(),avto.getNgos(),avto.getRate(),foto);

            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    avto.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;

    }


    public Avto read(long id) throws SQLException {
        Avto avto = null;

        try(
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()){
            String sql = String.format(Locale.US, " SELECT  `id`, `mark`, `model`, `color`, `nvin`, `year`, `ngos`, `rate`, `foto` FROM `avtos` WHERE id=%d", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                avto = new Avto(
                        resultSet.getLong("id"),
                        resultSet.getString("mark"),
                        resultSet.getString("model"),
                        resultSet.getString("color"),
                        resultSet.getString("nvin"),
                        resultSet.getInt("year"),
                        resultSet.getString("ngos"),
                        resultSet.getDouble("rate"),
                        resultSet.getString("foto"));

            }
        }

        return  avto;
    }

    public boolean update(Avto avto) throws SQLException {

        try(
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()){

            String sql = String.format(Locale.US, " UPDATE `avtos` SET `mark`='%s',`model`='%s',`color`='%s',`nvin`='%s',`year`=%d,`ngos`='%s',`rate`=%f,`foto`='%s' WHERE id=%d",
                    avto.getMark(),avto.getModel(),avto.getColor(), avto.getNvin(),avto.getYear(),avto.getNgos(),avto.getRate(),avto.getFoto(), avto.getId());

            return 1==statement.executeUpdate(sql);
        }


    }

    public boolean delete(Avto avto) throws SQLException {

        try(
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()){
            String sql = String.format(Locale.US, " DELETE FROM `avtos`  WHERE id=%d", avto.getId());


            return 1==statement.executeUpdate(sql);
        }


    }
}
