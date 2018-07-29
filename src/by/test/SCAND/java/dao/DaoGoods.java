package by.test.SCAND.java.dao;

import by.test.SCAND.java.DBC.DBConnection;
import by.test.SCAND.java.bean.Goods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DaoGoods extends AbstractDao implements DaoInterface<Goods>{

    @Override
    public Goods read(int id) throws SQLException {
        List<Goods> allGoods = getAll("where idgoods="+id);
        if(allGoods.size()>0){
            return allGoods.get(0);
        }
        else return null;
    }

    @Override
    public boolean create(Goods goods) throws SQLException {
        String sql = String.format(Locale.US,
                "INSERT INTO `goods`(`name`, `description`, `price`, `photo`, `user_iduser`) " +
                        "VALUES ('%s','%s',%f,'%s',%d)",
                goods.getName(),goods.getDescription(),goods.getPrice(),goods.getPhoto(),goods.getUser_iduser());
        int id = executeUpdate(sql);
        if(id>0){
            goods.setIdgoods(id);
            return true;
        }else
        return false;
    }

    @Override
    public boolean update(Goods goods) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE `goods` " +
                        "SET `name`='%s',`description`='%s',`price`=%f,`photo`='%s',`user_iduser`=%d WHERE idgoods=%d",
                goods.getName(),goods.getDescription(),goods.getPrice(),goods.getPhoto(),goods.getUser_iduser(),goods.getIdgoods());

        return executeUpdate(sql)>0;
    }

    @Override
    public boolean delete(Goods goods) throws SQLException {
        String sql = String.format(Locale.US,
                "DELETE FROM `goods` WHERE idgoods=%d",goods.getIdgoods());
        return executeUpdate(sql)>0;
    }

    @Override
    public List<Goods> getAll(String whereAndOrder) throws SQLException {
        List<Goods> allGoods = new ArrayList<>();
        try(Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement()
        ){
            String sql = String.format(Locale.US,
                    "SELECT `idgoods`, `name`, `description`, `price`, `photo`, `user_iduser` FROM `goods` %s",
                    whereAndOrder);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Goods goods = new Goods(
                        resultSet.getInt("idgoods"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"),
                        resultSet.getObject("photo"),
                        resultSet.getInt("user_iduser")
                );
                allGoods.add(goods);
            }
        }
        return allGoods;
    }
}
