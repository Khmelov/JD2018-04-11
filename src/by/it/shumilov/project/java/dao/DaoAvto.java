package by.it.shumilov.project.java.dao;

import by.it.shumilov.project.java.beans.Avto;
import by.it.shumilov.project.java.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DaoAvto  extends AbstractDao implements DaoInterface<Avto> {
    
    @Override
    public Avto read(long id) throws SQLException {
        List<Avto> all = getAll("WHERE id=" + id);
        if(all.size()>0)
            return  all.get(0);
        else
            return null;
    }

    @Override
    public boolean create(Avto avto) throws SQLException {

        String foto = "DEFAULT";
        if(avto.getFoto() != null)
            foto =  String.format(Locale.US,"'%s'",avto.getFoto());
        
        String sql = String.format(Locale.US, "INSERT INTO `avtos`(`mark`, `model`, `color`, `nvin`, `year`, `ngos`, `rate`, `foto`) VALUES ('%s','%s','%s','%s','%d','%s','%f', %s)",
                avto.getMark(),avto.getModel(),avto.getColor(), avto.getNvin(),avto.getYear(),avto.getNgos(),avto.getRate(),foto);
        long id = executeUpdate(sql);
        if(id>0) {
            avto.setId(id);
            return  true;
        }
        else
            return  false;
    }

    @Override
    public boolean update(Avto avto) throws SQLException {

        String sql = String.format(Locale.US, " UPDATE `avtos` SET `mark`='%s',`model`='%s',`color`='%s',`nvin`='%s',`year`=%d,`ngos`='%s',`rate`=%f,`foto`='%s' WHERE id=%d",
                avto.getMark(),avto.getModel(),avto.getColor(), avto.getNvin(),avto.getYear(),avto.getNgos(),avto.getRate(),avto.getFoto(), avto.getId());

        return executeUpdate(sql) > 0;
    }

    @Override
    public boolean delete(Avto avto) throws SQLException {

        String sql = String.format(Locale.US, " DELETE FROM `avtos`  WHERE id=%d", avto.getId());

        return executeUpdate(sql) > 0;
    }

    @Override
    public List<Avto> getAll(String whereAndOther) throws SQLException {
        List<Avto> avtos = new ArrayList<>();
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ){
            String sql = String.format(Locale.US, " SELECT  `id`, `mark`, `model`, `color`, `nvin`, `year`, `ngos`, `rate`, `foto` FROM `avtos` %s", whereAndOther);
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Avto avto = new Avto(
                        resultSet.getLong("id"),
                        resultSet.getString("mark"),
                        resultSet.getString("model"),
                        resultSet.getString("color"),
                        resultSet.getString("nvin"),
                        resultSet.getInt("year"),
                        resultSet.getString("ngos"),
                        resultSet.getDouble("rate"),
                        resultSet.getString("foto"));
                avtos.add(avto);
            }

        }
        return  avtos;
    }

}
